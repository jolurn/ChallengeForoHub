package com.alura.ChallengeForoHub.controller;

import com.alura.ChallengeForoHub.domain.usuario.*;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder){
        var usuario = new Usuario(datos);
        repository.save(usuario);

        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaUsuario>> listar(@PageableDefault(size=10, sort={"nombre"}) Pageable paginacion){
        var page = repository.findAllByActivoTrue(paginacion).map(DatosListaUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleUsuario(usuario));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionUsuario datos) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var usuario = repository.getReferenceById(id);
        usuario.actualizarInformaciones(datos);

        return ResponseEntity.ok( new DatosDetalleUsuario(usuario));
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.eliminar();

        return ResponseEntity.noContent().build();
    }
}
