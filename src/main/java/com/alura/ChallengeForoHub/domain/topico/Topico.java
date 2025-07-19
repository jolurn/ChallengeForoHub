package com.alura.ChallengeForoHub.domain.topico;

import com.alura.ChallengeForoHub.domain.curso.Curso;
import com.alura.ChallengeForoHub.domain.usuario.Usuario;
import com.alura.ChallengeForoHub.domain.statu.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name ="topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean activo;
    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    @JsonProperty("fecha_Creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String respuestas;

    public Topico(DatosRegistroTopico datos, Usuario autor, Curso curso) {
        this.id = null;
        this.activo = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = datos.fechaCreacion() != null ?
                datos.fechaCreacion() : LocalDateTime.now();
        this.status = datos.status() != null ?
                datos.status() : Status.ABIERTO;
        this.autor = autor;
        this.curso = curso;
        this.respuestas = datos.respuestas();

    }

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.fechaCreacion() != null) {
            this.fechaCreacion = datos.fechaCreacion();
        }
        if (datos.status() != null) {
            this.status = datos.status();
        }

        if (datos.respuestas() != null) {
            this.respuestas = datos.respuestas();
        }
    }

    public void eliminar() {
        this.activo = false;
    }

}
