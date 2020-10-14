package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexiones {

    private static Connection dbConnection = null;
    private static Statement stmt = null;

    //Creación BD o conexión a esta, creación de tablas 'artista' y 'disco'//
    public static void accionInicial() throws SQLException {
        abrirConexion();
        create_table_artista();
        create_table_disco();
        cerrar_conexion(dbConnection);
    }

    // Conexion con la BD //
    public static void abrirConexion(){
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:W:/Sqlite/entrega.db");
            System.out.println("La conexión con la BBDD SQlite se ha establecido correctamente");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }

    }

    // Cerrar la conexión con la BD //
    public static void cerrar_conexion( Connection con ) {
        try {
            if ( con != null )
                if ( !con.isClosed() )    // Si no está cerrada, la cierro
                    con.close();
        }
        catch (SQLException e) { e.printStackTrace();  }
    }

    // Creación de tablas si no existen //
    public static void create_table_artista() throws SQLException {
        stmt = dbConnection.createStatement ();
        String sql = "create table if not exists artista(" +
                "id TINYINT(2) NOT NULL PRIMARY KEY," +
                "nombre VARCHAR(10)," +
                "apellido VARCHAR(10)," +
                "localidad VARCHAR(15))";
        stmt.executeUpdate(sql);
        stmt.close ();
        System.out.println("Se ha creado correctamente la tabla 'artista'");
    }
    public static void create_table_disco() throws SQLException {
        stmt = dbConnection.createStatement ();
        String sql = "create table if not exists disco(" +
                "id TINYINT(2) NOT NULL PRIMARY KEY," +
                "nombre VARCHAR(10)," +
                "fecha_publi VARCHAR(10)," +
                "id_artista TINYINT(2) NOT NULL REFERENCES artista(id))";
        stmt.executeUpdate(sql);
        stmt.close ();
        System.out.println("Se ha creado correctamente la tabla 'disco'");
    }

}
