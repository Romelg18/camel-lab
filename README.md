# Laboratorio de Apache Camel - Patrón File Transfer

**Materia:** Integración de Sistemas  
**Integrantes:**
* Paulo Olivo
* Romel Gualoto
* Isaac Trujillo
* Brandon Arellano

## Descripción del Proyecto

Este repositorio contiene la implementación práctica del patrón de integración **File Transfer** utilizando el framework **Apache Camel** y **Maven**. 

El flujo de integración está diseñado para automatizar el procesamiento de archivos asíncronos con las siguientes características:
1. **Monitoreo (Endpoint de origen):** Escucha activamente la carpeta `/input`.
2. **Filtrado:** Utiliza `.filter(header("CamelFileName").endsWith(".csv"))` para procesar únicamente archivos con extensión CSV. Cualquier otro archivo (como `.txt`) es ignorado automáticamente.
3. **Transformación:** Convierte el cuerpo del archivo procesado a texto y transforma todo su contenido a mayúsculas utilizando el lenguaje simple de Camel (`${body.toUpperCase()}`).
4. **Enrutamiento (Endpoint de destino):** Escribe el archivo resultante en la carpeta `/output`.

## Simulador Interactivo

Adicionalmente, el proyecto incluye un **Simulador Interactivo Web (Cyberpunk Theme)** desarrollado en HTML/TailwindCSS (`simulador.html`). Este simulador permite visualizar de manera didáctica cómo funciona el patrón File Transfer, el enrutamiento de Camel y la validación de archivos (CSV vs TXT) sin necesidad de ejecutar el código Java.

## Instrucciones de Ejecución

### Prerrequisitos
* Java Development Kit (JDK) 11 o superior.
* Apache Maven instalado.

### Ejecutar la Ruta de Integración (Java)
1. Clonar este repositorio.
2. Abrir una terminal en el directorio raíz del proyecto.
3. Ejecutar el siguiente comando de Maven:
   ```bash
   mvn clean compile exec:java
   ```
4. Colocar un archivo `ventas.csv` en la carpeta `input` y revisar la consola y la carpeta `output`.

### Ejecutar el Simulador
1. Navegar a la carpeta raíz del proyecto.
2. Hacer doble clic en el archivo `simulador.html` para abrirlo en cualquier navegador web moderno.