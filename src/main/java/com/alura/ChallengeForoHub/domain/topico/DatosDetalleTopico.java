package com.alura.ChallengeForoHub.domain.topico;

import com.alura.ChallengeForoHub.domain.statu.Status;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String curso,
        String respuestas) {

    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre(),
                topico.getRespuestas()
        );
    }
}