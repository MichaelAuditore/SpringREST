# SpringREST

    Esta aplicación esta desarrollada con JAVA 11 y SpringBoot Release 2.3.4,
    esta aplicacion tiene una arquitectura REST y un patrón de diseño MVC,
    por lo cual puede ser consumida en navegadores Web tales como Chrome, Firefox.

    Para explicar que es REST y MVC nos remontaremos a ¿Qué es un servicio web?

    Un servicio Web es un sistema software diseñado para soportar interacciones
    máquina a máquina a través de la red. Dicho de otro modo, los servicios Web
    proporcionan una forma estándar de interoperar entre aplicaciones software
    que se ejecutan en diferentes plataformas. Por lo tanto, su principal característica
    su gran interoperabilidad y extensibilidad así como por proporcionar información
    fácilmente procesable por las máquinas gracias al uso de XML o JSON.

    A nivel conceptual, un servicio es un componente software proporcionado a través de
    un endpoint accesible a través de la red. Los servicios productores y consumidores
    utilizan mensajes para intercambiar información de invocaciones de petición y respuesta
    en forma de documentos auto-contenidos que hacen muy pocas asunciones sobre las capacidades
    tecnológicas de cada uno de los receptores.

## XML y JSON

    Son formatos en los cuales las respuestas dadas por el servicio productor
    se envian a traves de la red. Estos son los formatos mas comunes.

### XML
    Este acrónimo significa Extensible Markup Language, que es un lenguaje de marcado que
    define un conjunto de reglas para la codificación de documentos.

### JSON
    Este acrónimo significa JavaScript Object Notation, JSON es un formato de texto sencillo
    para el intercambio de datos. Se trata de un subconjunto de la notación literal de objetos
    de JavaScript, aunque, debido a su amplia adopción como alternativa a XML, se considera un
    formato independiente del lenguaje.

# REST

    REST significa REpresentational State Transfer, son un tipo de Servicios Web, que se adhieren
    a una serie de restricciones arquitectónicas englobadas bajo las siglas de REST, y que utilizan
    estándares Web tales como URIs, HTTP, XML, y JSON.

    REST es un conjunto de restricciones que, cuando son aplicadas al diseño de un sistema, crean
    un estilo arquitectónico de software. Dicho estilo arquitectónico se caracteriza por seguir
    los siguientes principios:

        [x] Debe ser un sistema cliente-servidor

        [x] Tiene que ser sin estado, es decir, no hay necesidad de que los servicios guarden
        las sesiones de los usuarios (cada petición al servicio tiene que ser independiente de las demás)

        [x] Debe soportar un sistema de cachés: la infraestructura de la red debería soportar
        caché en diferentes niveles

        [x] Entre otros.

# Metodos comunmente usados en REST

    [X] GET: para obtener información del servidor hacia el cliente
    [X] POST: para enviar información que sera procesada y guardada en el servidor
    [X] PUT: para enviar información que sera procesa y modificará algún dato existente en el servidor
    [X] DELETE: para eliminar algún dato existente en el servidor

# Desarrollo de API REST

    Esta aplicación consta de 4 Endpoints y localmente se monta sobre el puerto 8080,
    para acceder a la API debes usar este recurso http://localhost:8080/;


    Los endpoints creados son:

        [x] GET /users para obtener todos los usuarios registrados en la aplicación dentro del servidor
        [X] POST /users para registrar a un usuario en la aplicación dentro del servidor
        [X] PUT /update/{id} para actualizar información de un usuario ya existente
        en la aplicación dentro del servidor, "{id}" representa la llave para acceder usuario que será modificado.
        [X] DELETE /users/{id} para eliminar un usuario registrado en la aplicación
        dentro del servidor, "{id}" representa la llave para acceder al usuario que será eliminado en la aplicación.

# Utilidades de JAVA usadas para el desarrollo de la APP
    [X] H2 Database
    [X] SpringBoot DevTools
    [X] Spring Web Services
    [X] Spring Data JPA

# Para más información visita el javadoc

# Desarrollado por:

Miguel Angel Parada Cañon <michael_v613@hotmail.com>

