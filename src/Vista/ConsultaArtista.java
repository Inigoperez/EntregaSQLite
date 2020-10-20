package Vista;

import Controlador.Controller;
import Modelo.Artista;
import Modelo.Disco;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaArtista extends JFrame {

    JLabel titulo;
    JTable tableArtistas;
    JTable tableDiscos;
    JScrollPane scrollPaneArtista;
    JScrollPane scrollPaneDiscos;
    String[] columnNamesArtistas = {"ID", "Nombre", "Apellido", "Localidad"};
    String[] columnNamesDiscos = {"ID", "Nombre", "lanzamiento"};
    Object[][] datosArtistas = {};
    Object[][] datosDiscos = {};
    public static DefaultTableModel dtmArtistas;
    public static DefaultTableModel dtmDiscos;

    public ConsultaArtista(ArrayList<String> datos_artista) throws SQLException {
        super("Mostrar información de artista");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel contenido = new JPanel();
        contenido.setBackground(Color.gray);
        titulo = new JLabel("Discos del artista");
            titulo.setFont(new Font("titulo", Font.BOLD, 35));
            titulo.setForeground(Color.white);
        /////Lista de artista////////
        dtmArtistas = new DefaultTableModel(datosArtistas, columnNamesArtistas);
        tableArtistas = new JTable(dtmArtistas);
            Object[] newRowArtista = {datos_artista.get(0),datos_artista.get(1),datos_artista.get(2),datos_artista.get(3)};
            ConsultaArtista.dtmArtistas.addRow(newRowArtista);
            tableArtistas.setPreferredScrollableViewportSize(new Dimension(500, 50));
        scrollPaneArtista = new JScrollPane(tableArtistas);
            getContentPane().add(scrollPaneArtista, BorderLayout.CENTER);
        //////Lista de artistas////////
        //////Lista de discos//////////
        dtmDiscos = new DefaultTableModel(datosDiscos, columnNamesDiscos);
        tableDiscos = new JTable(dtmDiscos);
        Disco.select_discos(Integer.parseInt(datos_artista.get(0)));
        tableArtistas.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tableDiscos.setPreferredScrollableViewportSize(new Dimension(500,100));
        scrollPaneDiscos = new JScrollPane(tableDiscos);
        getContentPane().add(scrollPaneDiscos, BorderLayout.CENTER);
        /////Lista de discos//////////
        contenido.add(titulo);
        contenido.add(scrollPaneArtista);
        contenido.add(scrollPaneDiscos);
        this.add(contenido);
    }


}