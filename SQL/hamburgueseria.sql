-- Crear la base de datos
CREATE DATABASE hamburgueseria;

-- Seleccionar la base de datos
USE hamburgueseria;

-- Crear la tabla de productos
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    precio DECIMAL(6,2) NOT NULL,
    stock INT NOT NULL
);

-- Insertar productos iniciales
INSERT INTO productos (nombre, descripcion, precio, stock)
VALUES
('Hamburguesa clásica', 'Carne, lechuga y tomate', 6.50, 20),
('Hamburguesa doble', 'Doble carne y queso', 9.00, 15),
('Hamburguesa BBQ', 'Carne, bacon y salsa barbacoa', 8.50, 10),
('Patatas fritas', 'Ración de patatas fritas', 3.00, 30),
('Refresco', 'Refresco de 330 ml', 2.00, 40);
SELECT CURRENT_USER(), @@hostname, @@port;
SELECT user, host, plugin
FROM mysql.user
WHERE user = 'root';
ALTER USER 'root'@'localhost'
IDENTIFIED BY 'root123';