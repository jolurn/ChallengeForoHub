package com.alura.ChallengeForoHub.controller;

import com.alura.ChallengeForoHub.domain.curso.*;
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
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroCurso datos, UriComponentsBuilder uriComponentsBuilder){
        var curso = new Curso(datos);
        repository.save(curso);

        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarCurso>> listar(@PageableDefault(size=10, sort={"nombre"}) Pageable pageable){
        var page = repository.findAllByActivoTrue(pageable).map(DatosListarCurso::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleCurso(curso));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionCurso datos) {


        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }


        var curso = repository.getReferenceById(id);
        curso.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DatosDetalleCurso(curso));
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var curso = repository.getReferenceById(id);
        curso.eliminar();

        return ResponseEntity.noContent().build();
    }
}
