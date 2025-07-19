# 🚀 ForoHub API - Spring Boot + MySQL

API REST para un sistema de foros educativos con autenticación JWT. Permite crear, gestionar y moderar tópicos en comunidades de aprendizaje.

## 📌 Características Principales
- **Autenticación JWT** con Spring Security
- **CRUD completo** de tópicos (crear, leer, actualizar, eliminar)
- **Validación de datos** con `@Valid`
- **Base de datos MySQL 8+** con relaciones JPA
- **Paginación y filtros** avanzados
- **Pruebas integradas** con Postman/Insomnia

## 🛠️ Stack Tecnológico
| Componente       | Tecnología                     |
|------------------|--------------------------------|
| **Backend**      | Java 17, Spring Boot 3.x       |
| **Base de Datos**| MySQL 8.0                      |
| **Seguridad**    | JWT, Spring Security, BCrypt   |
| **Build**        | Maven 4.x                      |
| **IDE**          | IntelliJ IDEA (recomendado)    |

---
![My Skills](https://skillicons.dev/icons?i=html,spring,mysql,git,github,vscode)

## ⚙️ Configuración Inicial

### 📋 Requisitos
1. [Java JDK 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
2. [MySQL 8+](https://dev.mysql.com/downloads/installer/)
3. [Maven 4+](https://maven.apache.org/download.cgi)
4. [Insomnia/Postman](https://insomnia.rest/download)

### 🐳 Configuración de MySQL
1. **Ejecutar servidor MySQL**:
   
   # Opción con Docker (recomendada)
   docker run --name mysql-forohub -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=forohub_db -p 3306:3306 -d mysql:8.0

   # O instalar manualmente desde MySQL Installer

## 🚀 Ejecución del Proyecto

### Clonar repositorio:
git clone https://github.com/tu-usuario/forohub-api.git

### Configurar aplicación (src/main/resources/application.properties):
spring.datasource.url=jdbc:mysql://localhost:3306/challengeForoHub
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=123456

### Iniciar aplicación:
mvn spring-boot:run

## 📡 Endpoints Principales

### 🔐 Autenticación
POST /login
Content-Type: application/json

{
  "login": "usuario@example.com",
  "contrasena": "secreto123"
}

### 📝 Tópicos
Método	Endpoint	Descripción
POST	/topicos	Crear nuevo tópico (Requiere JWT)
GET	/topicos	Listar todos (con paginación)
GET	/topicos/{id}	Detalles de un tópico
PUT	/topicos/{id}	Actualizar tópico (Requiere JWT)
DELETE	/topicos/{id}	Eliminar tópico (Requiere JWT)

### Ejemplo de JSON para crear tópico:
{
    "titulo": "Spring Boot 3: aplique las mejores prácticas y proteja una API Rest",
    "mensaje": "¿Cómo mapear relaciones 777?",
    "fecha_Creacion": "2023-12-16T10:30:00",
    "status": null,
    "autorId": 1,
    "cursoId": 1,
    "respuestas": ""
}
### 🗄️ Diagrama de Base de Datos
<img width="30px" src="[https://raw.githubusercontent.com/iampavangandhi/iampavangandhi/master/gifs/Hi.gif](https://firebasestorage.googleapis.com/v0/b/confecciones-5368b.appspot.com/o/diagrama_base_de_datos_forohub.png?alt=media&token=d2d6fd64-353e-4d55-9e52-c326e5e762be)">

### 🧪 Pruebas con Insomnia
Configura environment con:
{
  "base_url": "http://localhost:8080",
  "jwt_token": "token_generado_en_login"
}

### 📌 Reglas de Negocio
Validaciones:

- Todos los campos son obligatorios

- No se permiten tópicos duplicados (mismo título + mensaje)

- Status debe ser uno de: NO_RESPONDIDO, NO_SOLUCIONADO, SOLUCIONADO, CERRADO

Paginación:

- Por defecto: 10 registros ordenados por fecha ASC

Ejemplo: /topicos?page=0&size=5&sort=fecha_Creacion,desc

Filtros:

- Por curso: /topicos?curso=Spring

- Por año: /topicos?ano=2023

- Por status: /topicos?status=SOLUCIONADO

### 🤝 Contribución
- git checkout -b feature/nueva-funcionalidad
- Realiza tus cambios
- git commit -m "Descripción clara"
- git push origin nombre-rama

[![Profile Summary](https://github-profile-summary-cards.vercel.app/api/cards/profile-details?username=jolurn&theme=github_dark)](https://github.com/jolurn)
