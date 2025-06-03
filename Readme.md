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

---

## Ejemplo práctico de flujo ##
![Diagrama de arquitectura de Microservicios](https://github.com/user-attachments/assets/00324847-f230-4051-b8f1-8a360d4b43bb)


El cliente entra a la tienda -> ve perfumes.

Cliente pide perfumes -> Microservicio Productos.

Cliente elige uno -> lo agrega al carrito.

Microservicio Carrito llama al Microservicio Productos para validar stock.

Carrito lo guarda en su base de datos.

Al comprar, el Carrito consulta al Microservicio Usuarios para saber quién eres.

Si todo está bien -> La compra es realizada exitosamente.

---
### Microservicios Desarrollados

- `usuarioservice`: > Permite la manipulación y almacenar distintos datos en la base de datos se los usuarios.
- `productoservice`: > Permite la manipulación y almacenar distintos datos en la base de datos se los productos.
- `carritoservice`: > Permite almacenar distintos productos de los usuarios.

## 🛠️ Tecnologías Utilizadas

- Spring Boot
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
  
> Incluir capturas o descripciones de pruebas realizadas con Postman (mínimo 3 por micro-servicio).

**Microservicio userservice**

Endpoints CRUD:

- GET /users
Lista todos los usuarios registrados.

- PATCH /usuarios/{id}
Actualiza los datos de un usuario existente por su ID.

- POST /usuarios
Guarda (crea) un nuevo usuario en el sistema.

- DELETE /usuarios/{id}
Elimina un usuario existente por su ID.

---
1) Endpoint que realiza la función de buscar mediante una id especifica de un usuario (user):
   
![image](https://github.com/user-attachments/assets/98319222-631a-4e5a-b6d6-f5a1236f21de)

Prueba realizada en Postman :

![image](https://github.com/user-attachments/assets/602eeac3-6554-41da-9e5f-b95dbd54f9fb)

2) Endpoint que permite eliminar un user mediante una id en especifica:

![image](https://github.com/user-attachments/assets/9e7659d5-3d4a-466b-8041-3716b2d184d7)

Prueba realizada en Postman:

![image](https://github.com/user-attachments/assets/dbd9b7d0-086d-4acf-bd7e-559d0fd614db)

3) Endpoint que permite obtener las diferentes colecciones almacenadas:

![image](https://github.com/user-attachments/assets/d04231f0-d1c8-4a22-a496-3fbfb29cf215)

Prueba realizada en Postman:

![image](https://github.com/user-attachments/assets/548d17fc-46b0-4144-8096-95af1ee510ab)


**Microservicio productservice:**

Endpoints CRUD:

GET /products
Lista todos los productos disponibles.

POST /products
Crea un nuevo producto en el sistema.

PATCH /products/{id}
Actualiza los datos de un producto existente por su ID.

DELETE /products/{id}
Elimina un producto por su ID.

---
1) Endpoint que permite obtener las colecciones de productos:

![image](https://github.com/user-attachments/assets/5995a295-043a-4bf0-a64a-aa9f81c5e9e5)

Prueba en Postman:

![image](https://github.com/user-attachments/assets/866e7a20-f99a-4163-85f7-7a85f2a6716c)

2) Endpoint que permite guardar un nuevo producto:

![image](https://github.com/user-attachments/assets/e9b062ac-1b20-48ed-a15e-5beb8b0692d6)

Prueba en Postman:

![image](https://github.com/user-attachments/assets/b58d1564-ea3f-4962-bf73-2df1eb4255a6)

3) Endpoint que permite actualizar producto mediante su id:
   
![image](https://github.com/user-attachments/assets/2be05e41-b79b-48d0-a93b-ee3aea7638d4)

Prueba en Postman:

![image](https://github.com/user-attachments/assets/63cf2af9-5c07-4bfd-9931-6a8d4a24a8cb)

**Microservicio carritoservice:**

Endpoints CRUD:

GET /products
Lista todos los carritos disponibles.

POST /products
Crea un nuevo carrito en el sistema.

PATCH /products
Actualiza datos existentes a un producto por su ID.

DELETE /products/{id}
Elimina un carrito por su ID.

1) Endpoint que permite obtener las colecciones de productos:

![image](https://github.com/user-attachments/assets/75b2d9db-3140-4760-b6b5-c6a2b2ac5a7b)

Prueba en Postman:

![image](https://github.com/user-attachments/assets/15648c60-6fd8-4fdc-81b5-bffbd7049aad)

2) Endpoint que permite guardar un nuevo producto:

![image](https://github.com/user-attachments/assets/af2eaeb6-6f13-480f-b67a-2996d53a9ddf)

Prueba en Postman:

![image](https://github.com/user-attachments/assets/8134f619-6d2f-45c5-96f2-4e0e7b8a6752)

3) Endpoint que permite obtener producto mediante su id:

![image](https://github.com/user-attachments/assets/ee0bd9fe-9705-469b-b8d2-67d7cc3bcc54)

Prueba en Postman:

![image](https://github.com/user-attachments/assets/bbf20db9-16d9-448b-a1bd-4d4ca746c0a5)

---

## 🧑‍💻 Integrantes del Equipo

| Nombre                  | Rol en el proyecto         | Servicio principal trabajado |
|-------------------------|----------------------------|------------------------------|
| Brian Aravena | Backend   | usuarioservice               |
| Benjamín García | Lider de equipo | productoservice              |
| Genesis Montero | Desarrolladora           | carritoservice                |

## 📂 Estructura del Repositorio

```

📦 perfulandia-microservices
├── usuarioservice
├── productoservice
├── carritoservice
└── README.md

```

## 👥 Colaboración en GitHub

Para el trabajo en equipo cordinamos las tareas mediante la red social whatsapp y utilizamos el repositorio general de Github para hacer nuestros aportes.

## 📈 Lecciones Aprendidas

A lo largo de este proyecto, como equipo, no solo aprendimos a aplicar conceptos técnicos como la arquitectura de microservicios, sino también a trabajar de forma colaborativa, enfrentando desafíos reales del desarrollo de software moderno.
Además, fortalecimos nuestras habilidades en herramientas como Spring Boot, bases de datos, configuración de servicios y comunicación entre componentes.


---

[Guía Oficial en Notion – Evaluación Parcial 2 (35%)](https://quilt-canary-969.notion.site/Gu-a-Oficial-Evaluaci-n-Parcial-2-35-1f75b3c4e31280aaab79c9a71f1cfb7b?pvs=4)
