package Vista;

import Controlador.Controller;
import Modelo.Artista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ConsultaArtista extends JFrame {

    JLabel titulo;
    JTable tableArtistas;
    JTable tableDiscos;
    JScrollPane scrollPaneArtista;
    JScrollPane scrollPaneDiscos;
    String[] columnNamesArtistas = {"ID", "Nombre", "Apellido", "Localidad",};
    String[] columnNamesDiscos = {"ID", "Nombre", "lanzamiento", "Id_artista",};
    Object[][] datosArtistas = {};
    Object[][] datosDiscos = {};
    public static DefaultTableModel dtmArtistas;
    public static DefaultTableModel dtmDiscos;

    public ConsultaArtista() throws SQLException {
        super("Mostrar información de artista");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel contenido = new JPanel();
        contenido.setBackground(Color.gray);
        titulo = new JLabel("Información de artista");
        titulo.setFont(new Font("titulo", Font.BOLD, 35));
        titulo.setForeground(Color.white);
        /////Lista de artista////////
        dtmArtistas = new DefaultTableModel(datosArtistas, columnNamesArtistas);
        tableArtistas = new JTable(dtmArtistas);
        tableArtistas.setPreferredScrollableViewportSize(new Dimension(500, 200));
        scrollPaneArtista = new JScrollPane(tableArtistas);
        getContentPane().add(scrollPaneArtista, BorderLayout.CENTER);
        //////Lista de artistas////////
        //////Lista de discos//////////
        dtmDiscos = new DefaultTableModel(datosDiscos, columnNamesDiscos);
        tableDiscos = new JTable(dtmDiscos);
        Artista.inner_artista_discos();
        tableArtistas.setPreferredScrollableViewportSize(new Dimension(500, 200));
        scrollPaneDiscos = new JScrollPane(tableDiscos);
        getContentPane().add(scrollPaneDiscos, BorderLayout.CENTER);
        /////Lista de discos//////////
        contenido.add(titulo);
        contenido.add(scrollPaneArtista);
        contenido.add(scrollPaneDiscos);
        this.add(contenido);
    }


}