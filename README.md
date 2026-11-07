# Gestión de Hamburguesería (Java + MySQL)

Proyecto de consola desarrollado en Java para la gestión de productos y stock de una hamburguesería, conectado a una base de datos relacional MySQL mediante JDBC.

## Funcionalidades
* **Listar productos:** Consulta y muestra en consola los productos registrados con su stock y precio.
* **Añadir producto:** Inserta nuevos productos en la base de datos validando los datos de entrada.
* **Modificar producto:** Actualiza el nombre, descripción, precio y stock de un producto mediante su ID.
* **Eliminar producto:** Borra registros de la base de datos seleccionando el ID correspondiente.

## Tecnologías utilizadas
* **Lenguaje:** Java
* **Base de Datos:** MySQL
* **Persistencia:** JDBC (`DriverManager`, `PreparedStatement`, `ResultSet`)
* **Control de errores:** Manejo de `SQLException` y `NumberFormatException`

## Estructura de la Base de Datos

Para ejecutar este proyecto localmente, es necesario crear la base de datos `hamburgueseria` y la tabla `productos` ejecutando el siguiente script SQL:

```sql
CREATE DATABASE IF NOT EXISTS hamburgueseria;
USE hamburgueseria;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL
);
