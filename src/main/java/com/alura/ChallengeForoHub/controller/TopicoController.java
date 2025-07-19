package com.alura.ChallengeForoHub.controller;

import com.alura.ChallengeForoHub.domain.curso.Curso;
import com.alura.ChallengeForoHub.domain.curso.CursoRepository;
import com.alura.ChallengeForoHub.domain.topico.*;
import com.alura.ChallengeForoHub.domain.usuario.Usuario;
import com.alura.ChallengeForoHub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(datos.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        var topico = new Topico(datos, autor, curso);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico> > listar(@PageableDefault(size=10, sort={"fechaCreacion"}) Pageable pageable){
        var page = repository.findAllByActivoTrue(pageable).map(DatosListarTopico:: new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

   @Transactional
   @PutMapping("/{id}")
   public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {

       // Verificamos si el tópico existe (cumpliendo con el requerimiento de verificación)
       if (!repository.existsById(id)) {
           return ResponseEntity.notFound().build();
       }

       // Mantenemos el estilo de tu profesor usando getReferenceById
       var topico = repository.getReferenceById(id);
       topico.actualizarInformaciones(datos);

       return ResponseEntity.ok(new DatosDetalleTopico(topico));
   }

   @Transactional
   @DeleteMapping("{id}")
   public ResponseEntity eliminar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.eliminar();

        return ResponseEntity.noContent().build();
   }

}
