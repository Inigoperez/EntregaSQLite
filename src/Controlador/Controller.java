package Controlador;

import Modelo.Conexiones;
import Vista.NuevoArtista;
import Vista.NuevoDisco;
import Vista.VentanaInicial;
import Modelo.Artista;
import Modelo.Disco;

import java.sql.SQLException;

public class Controller {

    public static NuevoArtista nuevoArtista;
    public static NuevoDisco nuevoDisco;
    public static VentanaInicial menu;

    public static void iniciarApp() throws SQLException {
        Conexiones.accionInicial();
        menu = new VentanaInicial();
        menu.setVisible(true);
    }

    public static void vistaAgregarArtista(){
        nuevoArtista = new NuevoArtista();
        nuevoArtista.setVisible(true);
    }

    public static void vistaAgregarDisco(){
        nuevoDisco = new NuevoDisco();
        nuevoDisco.setVisible(true);
    }

    public static void agregarArtista(String nombre, String apellido, String localidad) throws SQLException {
        Artista a = new Artista(nombre,apellido,localidad);
    }

    public static void agregarDisco(String nombre, String fecha_publi, int ID_artista) throws SQLException {
        Disco d = new Disco(nombre,fecha_publi,ID_artista);
    }
}
