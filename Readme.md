# 🧾 Proyecto: Transformación Digital - Perfulandia SPA


Este repositorio contiene el desarrollo técnico del sistema basado en microservicios para la empresa Perfulandia SPA, como parte de la Evaluación Parcial 2 de la asignatura **Desarrollo Full Stack I**.

## 📦 Descripción General del Proyecto

Perfulandia SPA es una empresa chilena en expansión, con nuevas sucursales en Concepción y Viña del Mar. Su sistema actual, de arquitectura monolítica, ha comenzado a presentar problemas de rendimiento y disponibilidad, afectando las operaciones diarias y la experiencia del cliente.

Para enfrentar estos desafíos, se ha optado por migrar a una arquitectura de microservicios, que permite mayor flexibilidad, escalabilidad y mantenimiento.

Algunos Beneficios del nuevo sistema:

- Mejor rendimiento y estabilidad.

- Escalabilidad por servicio.

- Mayor rapidez en el desarrollo y despliegue.

- Mejor experiencia para el usuario final.


## 🧩 Arquitectura de Microservicios

> 📝 Describir cómo está estructurado el sistema en microservicios. Pueden incluir un diagrama y explicar brevemente la función de cada servicio.

### Microservicios Desarrollados

- `usuarioservice`: > Permite la manipulación y almacenar distintos datos en la base de datos se los usuarios.
- `productoservice`: > Permite la manipulación y almacenar distintos datos en la base de datos se los productos.
- `carritoservice`: > 📝 Indicar el nombre y función del microservicio adicional implementado.

## 🛠️ Tecnologías Utilizadas

- Sprint Boot
- Maven
- Laragon
- Github
- IntelliJ
- Postman

## 🗄️ Configuración de Bases de Datos
La base de datos que se utilizó para la verificación de las distintas funcionalidades y almacenamiento de datos de los distintintos microservicios fue **Laragon**.


Para la correcta configuración de la conexión del programa a la base de datos, Agregamos diferentes propiedades en el archivo "application.properties":

spring.application.name: Define el nombre del microservicio.

![image](https://github.com/user-attachments/assets/3f694bcc-4383-4ef7-a6b6-4c4a4afae512)


server.port: Puerto donde se ejecutará la aplicación.

![image](https://github.com/user-attachments/assets/297435e5-1d0e-431f-8c97-9bd46f9bf2ec)


spring.datasource.url: Dirección URL de conexión a la base de datos.

![image](https://github.com/user-attachments/assets/1cc42a25-b7ae-4362-94b2-ac8a8a173858)


spring.datasource.username y password: Credenciales de acceso a la base de datos (usuario y contraseña).

![image](https://github.com/user-attachments/assets/12eca86c-f5c3-4b89-a052-a33de6c5500b)


spring.jpa.hibernate.ddl-auto: Indica cómo Hibernate debe manejar el esquema (en este caso, update actualiza la estructura sin borrar datos).

![image](https://github.com/user-attachments/assets/fa2b61b7-85b4-4704-bb8b-f1392ce93c47)


spring.jpa.show-sql: Muestra las consultas SQL en la consola.

![image](https://github.com/user-attachments/assets/f611ac42-ae69-492d-bdf9-b7cef5b68bcc)

hibernate.dialect: Define el dialecto específico de la base de datos como MYSQL, etc...

![image](https://github.com/user-attachments/assets/90f20239-cb10-4f41-aef1-76d616a56aac)


## 📮 Endpoints y Pruebas

> 📝 Especificar los principales endpoints disponibles por microservicio (CRUD y llamadas entre servicios).  
> Incluir capturas o descripciones de pruebas realizadas con Postman (mínimo 3 por micro-servicio).

## 🧑‍💻 Integrantes del Equipo

> 📝 Indicar nombre completo y rol de cada integrante del equipo.

| Nombre                  | Rol en el proyecto         | Servicio principal trabajado |
|-------------------------|----------------------------|------------------------------|
| Brian Aravena | Backend   | usuarioservice               |
| Benjamín García | Lider de equipo | productoservice              |
| Genesis Montero | Desarrolladora           | carritoservice                |

## 📂 Estructura del Repositorio

> 📝 Explicar brevemente la organización de carpetas del repositorio (por ejemplo, cada carpeta corresponde a un microservicio separado con su propio `pom.xml`).

```

📦 perfulandia-microservices
├── usuarioservice
├── productoservice
├── carritoservice
└── README.md

```

## 👥 Colaboración en GitHub

> 📝 Explicar cómo se organizó el trabajo en ramas (`master`, `pruebas`), frecuencia de commits y cómo se coordinaron como equipo.

## 📈 Lecciones Aprendidas

> 📝 Reflexionar brevemente sobre qué aprendieron durante el desarrollo del proyecto (técnico y en trabajo en equipo).

---

[Guía Oficial en Notion – Evaluación Parcial 2 (35%)](https://quilt-canary-969.notion.site/Gu-a-Oficial-Evaluaci-n-Parcial-2-35-1f75b3c4e31280aaab79c9a71f1cfb7b?pvs=4)
