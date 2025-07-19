CREATE TABLE topicos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,  -- Cambiado a TEXT para mensajes más largos
    fecha_Creacion DATETIME NOT NULL,  -- Cambiado a DATETIME
    status VARCHAR(20) NOT NULL,  -- Reducido el tamaño para ENUM
    autor_id BIGINT NOT NULL,  -- Renombrado y tipo consistente
    curso_id BIGINT NOT NULL,  -- Renombrado y tipo consistente
    respuestas TEXT,  -- Coincide con tu entidad y permite NULL

    PRIMARY KEY(id),
    CONSTRAINT fk_topico_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES cursos(id)
);