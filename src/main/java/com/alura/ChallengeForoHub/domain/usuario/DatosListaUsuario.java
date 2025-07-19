package com.alura.ChallengeForoHub.domain.usuario;

public record DatosListaUsuario(
        Long id,
        String nombre,
        String correo,
        String contrasena
) {
    public DatosListaUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getContrasena()
        );

    }
}
