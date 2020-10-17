package Modelo;

import java.sql.SQLException;

public class Artista extends Conexiones{

    private int ID;
    private String nombre;
    private String apellido;
    private String localidad;

    public Artista(int ID, String nombre, String apellido, String localidad){
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;


    }

    public int getID() {
        return ID;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getNombre() {
        return nombre;
    }

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
}
