# Fragments App
Esta es una aplicación de Android desarrollada con Kotlin que utiliza el patrón de Fragments para gestionar distintas secciones de la interfaz de usuario. La aplicación cuenta con una barra de navegación inferior que permite al usuario cambiar entre cuatro Fragments principales.

### Funcionalidad
La aplicación consta de los siguientes cuatro Fragments principales, cada uno con su propia funcionalidad:

1. Inicio: Este Fragment muestra la página principal de la aplicación. Muestra el uso de recycleview que mmuestra una lista de idiomas y el nombre del fragment.

2. Categorias: En este Fragment, se muestra un recycleview con diferentes lenguajes de programacion y el nombre del fragment.

3. Comprar: Aquí, el usuario puede ver una lista de comidas contenidas en un recycleview y el nombre del fragment.

4. Productos: En este Fragment, se usa un recycleview con una lista de productos del hogar y el nombre del fragment.

### Barra de navegación inferior
La barra de navegación inferior se encuentra en la parte inferior de la pantalla y proporciona acceso rápido a cada uno de los Fragments principales de la aplicación. Cada ítem de la barra de navegación está asociado con un Fragment específico y al hacer clic en un ítem, se carga el Fragment correspondiente en el área principal de la interfaz de usuario.

### Uso de fragments
Los Fragments se utilizan para modularizar la interfaz de usuario de la aplicación y facilitar la navegación entre las diferentes secciones. Cada Fragment contiene su propio conjunto de componentes de interfaz de usuario y lógica de presentación, lo que permite un desarrollo y mantenimiento más organizado y escalable.
