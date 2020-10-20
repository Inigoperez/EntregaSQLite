package Controlador;

import Modelo.Conexiones;
import Vista.*;
import Modelo.Artista;
import Modelo.Disco;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {

    public static NuevoArtista nuevoArtista;
    public static NuevoDisco nuevoDisco;
    public static VentanaInicial menu;
    public static MostrarArtistas listaArtistas;
    public static ConsultaArtista datosArtista;
    public static SeleccionUser seleccionUser;
    public static EditarArtista editarArtista;
    public static SeleccionUserEliminar seleccionUserEliminar;
    public static SeleccionUserDiscos seleccionUserDiscos;

    public static void iniciarApp() throws SQLException {
        Conexiones.accionInicial();
        menu = new VentanaInicial();
        menu.setVisible(true);
    }

    /// VISTAS DE PROGRAMA ///
    public static void vistaAgregarArtista(){
        nuevoArtista = new NuevoArtista();
        nuevoArtista.setVisible(true);
    }

    public static void vistaAgregarDisco(){
        nuevoDisco = new NuevoDisco();
        nuevoDisco.setVisible(true);
    }

    public static void vistaListaArtistas() throws SQLException {
        listaArtistas = new MostrarArtistas();
        listaArtistas.setVisible(true);
    }

    public static void vistaMostrarArtista(ArrayList ID) throws SQLException {
        datosArtista = new ConsultaArtista(ID);
        datosArtista.setVisible(true);
    }

    public static void seleccionUser() throws SQLException {
        seleccionUser = new SeleccionUser();
        seleccionUser.setVisible(true);
    }

    public static void EditarArtista(ArrayList<String> datos_Artista){
        editarArtista = new EditarArtista(datos_Artista);
        editarArtista.setVisible(true);
    }

    public static void SeleccionUserEliminar() throws SQLException {
        seleccionUserEliminar = new SeleccionUserEliminar();
        seleccionUserEliminar.setVisible(true);
    }

    public static void SeleccionUserDiscos() throws SQLException {
        seleccionUserDiscos = new SeleccionUserDiscos();
        seleccionUserDiscos.setVisible(true);
    }
    /// VISTAS DE PROGRAMA ///

    /// EJECUCIONES ///
    public static void agregarArtista(String nombre, String apellido, String localidad) throws SQLException {
        Artista a = new Artista(nombre,apellido,localidad);
    }

    public static void agregarDisco(String nombre, String fecha_publi, int ID_artista) throws SQLException {
        Disco d = new Disco(nombre,fecha_publi,ID_artista);
    }

    public static void mostrarArtistas() throws SQLException {
        Artista.select_artistas();
    }

    public static ArrayList<Integer> listarArtistas() throws SQLException {
        return Artista.listar_artistas_seleccion();
    }

    public static ArrayList<Integer> listarArtistas1() throws SQLException{
        return Artista.listar_artistas_seleccion_eliminar();
    }

    public static ArrayList<Integer> listarArtistas2() throws SQLException{
        return Artista.listar_artistas_seleccion_disco();
    }

    public static void sacarDatosArtista(int ID) throws SQLException {
        EditarArtista(Artista.datos_de_artista(ID));
    }

    public static void modificarArtista(int ID,String nombre, String apellido, String localidad) throws SQLException {
        Artista.cambiarDatosArtista(ID,nombre,apellido,localidad);
    }

    public static void eliminarUsuariosDiscos(int ID) throws SQLException {
        Disco.eliminarDiscos(ID);
        Artista.eliminarArtista(ID);
    }

    public static void vistaMostrarDiscos(ArrayList datos_artista) throws SQLException {
        vistaMostrarArtista(datos_artista);
    }
    /// EJECUCIONES ///
}
