package com.alura.ChallengeForoHub.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // es para que el sistema identifique que dos objetos son iguales si el id es igual
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private boolean activo;
    private String nombre;
    private String correo;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    public Usuario(DatosRegistroUsuario autor) {
        this.id = null;
        this.activo = true;
        this.nombre = autor.nombre();
        this.correo = autor.correo();
        this.contrasena = autor.contrasena();
        this.perfil = autor.perfil();
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public void actualizarInformaciones(DatosActualizacionUsuario datos) {
        if (datos.nombre()!=null){
            this.nombre = datos.nombre();
        }
        if (datos.correo()!=null){
            this.correo = datos.correo();
        }
        if (datos.contrasena()!=null){
            this.contrasena = datos.contrasena();
        }
        if (datos.perfil()!=null){
            this.perfil = datos.perfil();
        }
    }

    public void eliminar() {
        this.activo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
