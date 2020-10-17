package Modelo;

import java.sql.SQLException;

public class Disco extends Conexiones{

    private int ID;
    private String nombre;
    private String fecha_publi;
    private int ID_artista;

    public Disco(int ID, String nombre, String fecha_publi, int ID_artista) {
        this.ID = ID;
        this.nombre = nombre;
        this.fecha_publi = fecha_publi;
        this.ID_artista = ID_artista;
    }

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }

    public int getID_artista() {
        return ID_artista;
    }

    public String getFecha_publi() {
        return fecha_publi;
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
