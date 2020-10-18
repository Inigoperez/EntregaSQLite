package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Disco extends Conexiones{

    private int ID;
    private String nombre;
    private String fecha_publi;
    private int ID_artista;

    public Disco(String nombre, String fecha_publi, int ID_artista) throws SQLException {
        abrirConexion();
        this.ID = sacar_mayor_id_disco();
        this.nombre = nombre;
        this.fecha_publi = fecha_publi;
        this.ID_artista = ID_artista;
        insertar_disco(this.ID,this.nombre,this.fecha_publi,this.ID_artista);
        cerrar_conexion(dbConnection);
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

    private static void insertar_disco(int ID, String nombre, String fecha_publi, int ID_artista) throws SQLException {
        stmt = dbConnection.createStatement ();
        String sql = "INSERT INTO disco ('id','nombre','fecha_publi','id_artista') VALUES ("+ID+",'"+nombre+"','"+fecha_publi+"','"+ID_artista+"')";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close ();
        System.out.println("Se ha añadido correctamente el disco");
    }

    private static int sacar_mayor_id_disco() throws SQLException {
        int resultado;
        stmt = dbConnection.createStatement ();
        String sql = "Select max(id) from disco";
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.getInt("max(id)")==0) {
            resultado = 1;
        }else{
            resultado = rs.getInt("max(id)") + 1;
            rs.close();
            stmt.close();
        }
        return resultado;
    }
}
