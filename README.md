# Sistema de gestión de notebooks
## Descripción del Proyecto :memo:

Este proyecto es un sistema de gestión de notebooks (computadoras portátiles) desarrollado en JavaScript (vanilla) para el frontend y Spring Boot para el backend, con una base de datos MySQL.

El sistema permite crear, leer, actualizar y eliminar (CRUD) notebooks, utilizando una API RESTful construida con Spring Boot. La aplicación de frontend es interactiva y sencilla, con un diseño limpio que permite al usuario administrar los notebooks de manera eficiente.
Requerimientos Funcionales :clipboard:

    Backend (API REST):
        Creación, obtención, actualización y eliminación de notebooks.
        Los notebooks tienen atributos como: Marca, Modelo, Procesador, RAM, Almacenamiento, GPU, Precio.
    Frontend (Interfaz de usuario):
        Una única página con un formulario que permite crear y editar notebooks.
        Una tabla para mostrar todas las notebooks almacenadas.
        Funcionalidades para modificar o eliminar notebooks.

### Tecnologías Utilizadas :wrench:

    Frontend:
        JavaScript (Vanilla)
        HTML & CSS (Estilización básica)
    Backend:
        Spring Boot (Java)
        MySQL (Base de datos)
        H2 (Base de datos independiente para los test)
    Otras herramientas:
        Git & GitHub para control de versiones
        Postman para probar la API

        Flujo del Proyecto:

    Crear una notebook:
    El usuario puede ingresar los detalles de una nueva notebook (Marca, Modelo, Procesador, etc.) en el formulario y guardarla en la base de datos.

    Leer notebooks:
    Las notebooks creadas se muestran en una tabla en la misma página.

    Actualizar una notebook:
    El usuario puede modificar cualquier notebook existente.

    Eliminar una notebook:
    El usuario puede eliminar notebooks de la base de datos.

### Pruebas Unitarias y Funcionales :test_tube:

Se han implementado pruebas unitarias para el backend, asegurando que las operaciones CRUD sobre las notebooks se realicen de manera correcta. También se ha probado la API utilizando Postman para garantizar la integridad de los datos y las respuestas de la API.
Objetivos Alcanzados :trophy:

    Implementación completa de la API RESTful para la gestión de notebooks.
    Creación de una interfaz de usuario sencilla y eficaz usando JavaScript.
    Integración exitosa de frontend y backend.
    Pruebas unitarias para validar la lógica de negocio en el backend.
### Demostración Visual :camera_flash:

Aquí está un ejemplo de cómo se ve la aplicación:

Pantalla principal: ![image](https://github.com/user-attachments/assets/7474d22c-2313-4e49-90bc-244b34186382)


Una vista limpia de la tabla de notebooks, con botones para crear, modificar o eliminar notebooks.
    
