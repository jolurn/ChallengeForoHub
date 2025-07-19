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
1. Ejecutar servidor MySQL:
   
   - instalar manualmente desde MySQL Installer

## 🚀 Ejecución del Proyecto

### Clonar repositorio:
- git clone https://github.com/tu-usuario/forohub-api.git

### Configurar aplicación (src/main/resources/application.properties):
- spring.datasource.url=jdbc:mysql://localhost:3306/challengeForoHub
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.datasource.username=root
- spring.datasource.password=123456

### Iniciar aplicación:
- mvn spring-boot:run

## 📡 Endpoints Principales

### 🔐 Autenticación
- POST /login
- Content-Type: application/json

![Texto alternativo](https://firebasestorage.googleapis.com/v0/b/confecciones-5368b.appspot.com/o/login.jpg?alt=media&token=85c2cf56-bb11-4f05-a1bb-fdb51ace190a)

### 📝 Tópicos
### 🔐 Endpoints de Autenticación
| Método | Endpoint   | Descripción               | Requiere Token |
|--------|------------|---------------------------|----------------|
| POST   | `/login`   | Iniciar sesión            | ❌ No          |

### 📝 Endpoints de Tópicos
| Método | Endpoint          | Descripción                          | Requiere Token |
|--------|-------------------|--------------------------------------|----------------|
| POST   | `/topicos`        | Crear nuevo tópico                   | ✔️ Sí          |
| GET    | `/topicos`        | Listar todos (con paginación)        | ✔️ Sí          |
| GET    | `/topicos/{id}`   | Detalles de un tópico                | ✔️ Sí          |
| PUT    | `/topicos/{id}`   | Actualizar tópico                    | ✔️ Sí          |
| DELETE | `/topicos/{id}`   | Eliminar tópico                      | ✔️ Sí          |

### 🔌 Esquema de Seguridad

- POST /login → Publico (sin token)
- Authorization: Bearer {token} → Requerido en TODOS los demás endpoints

### Ejemplo de JSON para crear tópico:
![Texto alternativo](https://firebasestorage.googleapis.com/v0/b/confecciones-5368b.appspot.com/o/Captura%20de%20pantalla%202025-07-19%20023558.jpg?alt=media&token=88661a60-33ab-45c2-92de-58b2598d8f87)
### 🗄️ Diagrama de Base de Datos
![Texto alternativo](https://firebasestorage.googleapis.com/v0/b/confecciones-5368b.appspot.com/o/diagrama_base_de_datos_forohub.png?alt=media&token=d2d6fd64-353e-4d55-9e52-c326e5e762be)

### 🧪 Pruebas con Insomnia
Configura environment con:
![Texto alternativo](https://firebasestorage.googleapis.com/v0/b/confecciones-5368b.appspot.com/o/Captura%20de%20pantalla%202025-07-19%20022912.jpg?alt=media&token=0321c855-44ae-454d-96f7-e776d53f6dec)

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
