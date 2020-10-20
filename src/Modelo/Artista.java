package Modelo;

import Controlador.Controller;
import Vista.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Artista extends Conexiones{

    private int ID;
    private String nombre;
    private String apellido;
    private String localidad;


    public Artista(String nombre, String apellido, String localidad) throws SQLException {
        abrirConexion();
        this.ID = sacar_mayor_id();
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        insertar_artista(this.ID,this.nombre,this.apellido,this.localidad);
        cerrar_conexion(dbConnection);
    }


    public Artista(int ID,String nombre, String apellido, String localidad){
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

    private static void insertar_artista(int ID, String nombre, String apellido, String localidad) throws SQLException {
        stmt = dbConnection.createStatement ();
        String sql = "INSERT INTO artista ('id','nombre','apellido','localidad') VALUES ("+ID+",'"+nombre+"','"+apellido+"','"+localidad+"')";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close ();
        System.out.println("Se ha añadido correctamente el artista");
    }

    private static int sacar_mayor_id() throws SQLException {
        int resultado;
        stmt = dbConnection.createStatement ();
        String sql = "Select max(id) from artista";
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

    public static void select_artistas() throws SQLException {
        abrirConexion();
        stmt = dbConnection.createStatement ();
        String sql = "Select * from artista";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            // Agregar nueva fila
            Object[] newRow = { rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("localidad")
            };
            MostrarArtistas.dtm.addRow(newRow);
        }
        rs.close();
        stmt.close();
        cerrar_conexion(dbConnection);
    }

    public static ArrayList<Integer> listar_artistas_seleccion() throws SQLException {
        ArrayList<Integer> lista_IDs = new ArrayList<Integer>();
        abrirConexion();
        stmt = dbConnection.createStatement ();
        String sql = "Select * from artista";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            // Agregar nueva fila
            Object[] newRow = { rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("localidad")
            };
            SeleccionUser.dtm.addRow(newRow);
            lista_IDs.add(rs.getInt("id"));
        }
        rs.close();
        stmt.close();
        cerrar_conexion(dbConnection);
        return lista_IDs;
    }

    public static ArrayList<Integer> listar_artistas_seleccion_eliminar() throws SQLException {
        ArrayList<Integer> lista_IDs = new ArrayList<Integer>();
        abrirConexion();
        stmt = dbConnection.createStatement ();
        String sql = "Select * from artista";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            // Agregar nueva fila
            Object[] newRow = { rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("localidad")
            };
            SeleccionUserEliminar.dtm.addRow(newRow);
            lista_IDs.add(rs.getInt("id"));
        }
        rs.close();
        stmt.close();
        cerrar_conexion(dbConnection);
        return lista_IDs;
    }

    public static ArrayList<Integer> listar_artistas_seleccion_disco() throws SQLException {
        ArrayList<Integer> lista_IDs = new ArrayList<Integer>();
        abrirConexion();
        stmt = dbConnection.createStatement ();
        String sql = "Select * from artista";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            // Agregar nueva fila
            Object[] newRow = { rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("localidad")
            };
            SeleccionUserDiscos.dtm.addRow(newRow);
            lista_IDs.add(rs.getInt("id"));
        }
        rs.close();
        stmt.close();
        cerrar_conexion(dbConnection);
        return lista_IDs;
    }

    public static ArrayList datos_de_artista(int ID) throws SQLException {
        ArrayList<String> datos_Artista = new ArrayList<String>();
        abrirConexion();
        stmt = dbConnection.createStatement ();
        String sql = "Select * from artista where id="+ID;
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
            datos_Artista.add(String.valueOf(rs.getInt("id")));
            datos_Artista.add(rs.getString("nombre"));
            datos_Artista.add(rs.getString("apellido"));
            datos_Artista.add(rs.getString("localidad"));
        rs.close();
        stmt.close();
        cerrar_conexion(dbConnection);
        return datos_Artista;
    }

    public static void cambiarDatosArtista(int ID, String nombre, String apellido, String localidad) throws SQLException {
        abrirConexion();
        stmt = dbConnection.createStatement ();
        String sql = "UPDATE artista SET nombre='"+nombre+"',apellido='"+apellido+"',localidad='"+localidad+"' WHERE id='"+ID+"'";
        stmt.executeUpdate(sql);
        stmt.close ();
        System.out.println("Se ha modificado correctamente");
        cerrar_conexion(dbConnection);
    }

    public static void eliminarArtista(int ID) throws SQLException {
        abrirConexion();
        stmt = dbConnection.createStatement();
        String sql = "Delete from artista where ID='"+ID+"'";
        stmt.executeUpdate(sql);
        stmt.close ();
        System.out.println("Se ha eliminado el artista correctamente");
        cerrar_conexion(dbConnection);
    }
}
