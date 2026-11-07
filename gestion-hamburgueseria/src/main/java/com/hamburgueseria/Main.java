/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



package com.hamburgueseria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hamburgueseria";
        String user = "root";
        String pass = "root123";

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== HAMBURGUESERÍA =====");
            System.out.println("1. Listar productos");
            System.out.println("2. Añadir producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1: {
                        // LISTAR PRODUCTOS

                        String sqlListar = "SELECT * FROM productos";

                        try (Connection c = DriverManager.getConnection(url, user, pass);
                             PreparedStatement sentencia = c.prepareStatement(sqlListar);
                             ResultSet rs = sentencia.executeQuery()) {

                            System.out.println("\n--- LISTA DE PRODUCTOS ---");

                            boolean hayProductos = false;

                            while (rs.next()) {
                                hayProductos = true;

                                Producto p = new Producto(
                                        rs.getInt("id"),
                                        rs.getString("nombre"),
                                        rs.getString("descripcion"),
                                        rs.getDouble("precio"),
                                        rs.getInt("stock")
                                );

                                System.out.println(p);
                            }

                            if (!hayProductos) {
                                System.out.println("No hay productos registrados.");
                            }

                        } catch (SQLException e) {
                            System.out.println("Error al listar: " + e.getMessage());
                        }

                        break;
                    }

                    case 2: {
                        // AÑADIR PRODUCTO

                        System.out.println("\n--- AÑADIR PRODUCTO ---");

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Descripción: ");
                        String descripcion = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(
                                sc.nextLine().replace(",", ".")
                        );

                        System.out.print("Stock: ");
                        int stock = Integer.parseInt(sc.nextLine());

                        Producto nuevo = new Producto(
                                nombre, descripcion, precio, stock
                        );

                        String sqlInsertar =
                                "INSERT INTO productos (nombre, descripcion, precio, stock) "
                                + "VALUES (?, ?, ?, ?)";

                        try (Connection c = DriverManager.getConnection(url, user, pass);
                             PreparedStatement sentencia = c.prepareStatement(sqlInsertar)) {

                            sentencia.setString(1, nuevo.getNombre());
                            sentencia.setString(2, nuevo.getDescripcion());
                            sentencia.setDouble(3, nuevo.getPrecio());
                            sentencia.setInt(4, nuevo.getStock());

                            sentencia.executeUpdate();

                            System.out.println("Producto añadido correctamente.");

                        } catch (SQLException e) {
                            System.out.println("Error al añadir: " + e.getMessage());
                        }

                        break;
                    }

                    case 3: {
                        // MODIFICAR PRODUCTO

                        System.out.println("\n--- MODIFICAR PRODUCTO ---");

                        System.out.print("ID del producto: ");
                        int idModificar = Integer.parseInt(sc.nextLine());

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();

                        System.out.print("Nueva descripción: ");
                        String nuevaDescripcion = sc.nextLine();

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(
                                sc.nextLine().replace(",", ".")
                        );

                        System.out.print("Nuevo stock: ");
                        int nuevoStock = Integer.parseInt(sc.nextLine());

                        Producto modificado = new Producto(
                                idModificar,
                                nuevoNombre,
                                nuevaDescripcion,
                                nuevoPrecio,
                                nuevoStock
                        );

                        String sqlModificar =
                                "UPDATE productos SET nombre = ?, descripcion = ?, "
                                + "precio = ?, stock = ? WHERE id = ?";

                        try (Connection c = DriverManager.getConnection(url, user, pass);
                             PreparedStatement sentencia = c.prepareStatement(sqlModificar)) {

                            sentencia.setString(1, modificado.getNombre());
                            sentencia.setString(2, modificado.getDescripcion());
                            sentencia.setDouble(3, modificado.getPrecio());
                            sentencia.setInt(4, modificado.getStock());
                            sentencia.setInt(5, modificado.getId());

                            int filas = sentencia.executeUpdate();

                            if (filas > 0) {
                                System.out.println("Producto modificado correctamente.");
                            } else {
                                System.out.println("No existe un producto con ese ID.");
                            }

                        } catch (SQLException e) {
                            System.out.println("Error al modificar: " + e.getMessage());
                        }

                        break;
                    }

                    case 4: {
                        // ELIMINAR PRODUCTO

                        System.out.println("\n--- ELIMINAR PRODUCTO ---");

                        System.out.print("ID del producto: ");
                        int idEliminar = Integer.parseInt(sc.nextLine());

                        String sqlEliminar =
                                "DELETE FROM productos WHERE id = ?";

                        try (Connection c = DriverManager.getConnection(url, user, pass);
                             PreparedStatement sentencia = c.prepareStatement(sqlEliminar)) {

                            sentencia.setInt(1, idEliminar);

                            int filas = sentencia.executeUpdate();

                            if (filas > 0) {
                                System.out.println("Producto eliminado correctamente.");
                            } else {
                                System.out.println("No existe un producto con ese ID.");
                            }

                        } catch (SQLException e) {
                            System.out.println("Error al eliminar: " + e.getMessage());
                        }

                        break;
                    }

                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
