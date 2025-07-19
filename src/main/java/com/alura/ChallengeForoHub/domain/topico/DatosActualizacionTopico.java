package com.alura.ChallengeForoHub.domain.topico;

import com.alura.ChallengeForoHub.domain.statu.Status;

import java.time.LocalDateTime;

public record DatosActualizacionTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        Long autorId,
        Long cursoId,
        String respuestas
) {
}
