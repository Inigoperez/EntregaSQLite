package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexiones {

    public static Connection dbConnection = null;
    public static Statement stmt = null;

    //Creación BD o conexión a esta, creación de tablas 'artista' y 'disco'//
    public static void accionInicial() throws SQLException {
        abrirConexion();
        Artista.create_table_artista();
        Disco.create_table_disco();
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

}
