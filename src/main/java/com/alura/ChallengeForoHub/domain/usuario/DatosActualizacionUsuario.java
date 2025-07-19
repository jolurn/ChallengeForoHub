package com.alura.ChallengeForoHub.domain.usuario;

public record DatosActualizacionUsuario(
        Long id,
        String nombre,
        String correo,
        String contrasena,
        Perfil perfil
) {
}
