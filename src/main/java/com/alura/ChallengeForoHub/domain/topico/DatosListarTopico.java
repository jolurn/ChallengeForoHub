package com.alura.ChallengeForoHub.domain.topico;

import com.alura.ChallengeForoHub.domain.statu.Status;
import java.time.LocalDateTime;

public record DatosListarTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        Long autorId,
        Long cursoId
) {
    public DatosListarTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
        );

    }
}
