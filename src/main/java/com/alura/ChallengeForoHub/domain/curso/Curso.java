package com.alura.ChallengeForoHub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // es para que el sistema identifique que dos objetos son iguales si el id es igual
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean activo;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosRegistroCurso curso) {
        this.id = null;
        this.activo = true;
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }

    public Curso(Long id) {
        this.id = id;
    }

    public void actualizarInformaciones(@Valid DatosActualizacionCurso datos) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if (datos.categoria() != null) {
            this.categoria = datos.categoria();
        }
    }

    public void eliminar() {
        this.activo = false;
    }
}
