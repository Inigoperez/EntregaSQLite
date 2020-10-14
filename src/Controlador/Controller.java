package Controlador;

import Modelo.Conexiones;
import Vista.NuevoArtista;
import Vista.VentanaInicial;

import java.sql.SQLException;

public class Controller {

    public static void iniciarApp() throws SQLException {
        Conexiones.accionInicial();
        VentanaInicial menu = new VentanaInicial();
        menu.setVisible(true);
    }

    public static void vistaAgregarArtista(){
        NuevoArtista nuevoArtista = new NuevoArtista();
        nuevoArtista.setVisible(true);
    }

}
