package com.alura.ChallengeForoHub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosListarCurso(
        @NotNull Long id,
        String nombre,
        Categoria categoria
) {
    public DatosListarCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria()
        );
    }
}
