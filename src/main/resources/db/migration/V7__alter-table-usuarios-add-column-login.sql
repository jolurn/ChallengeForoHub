ALTER TABLE usuarios
ADD COLUMN login VARCHAR(255) UNIQUE; -- Tipo String, compatible con JPA