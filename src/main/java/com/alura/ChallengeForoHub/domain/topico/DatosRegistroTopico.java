package com.alura.ChallengeForoHub.domain.topico;

import com.alura.ChallengeForoHub.domain.statu.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        @NotNull Long autorId,
        @NotNull Long cursoId,
        String respuestas
        ) {
}
