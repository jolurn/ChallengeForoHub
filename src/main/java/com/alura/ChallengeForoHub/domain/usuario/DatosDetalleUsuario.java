package com.alura.ChallengeForoHub.domain.usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String correo,
        String contraeña,
        Perfil perfil
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getPerfil()
        );
    }
}
