package Vista;

import Controlador.Controller;
import Modelo.Artista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MostrarArtistas extends JFrame{

    JLabel titulo;
    JTable table;
    JScrollPane scrollPane;
    String[] columnNames = {"ID","Nombre","Apellido","Localidad",};
    Object[][] datos = {};
    public static DefaultTableModel dtm;

    public MostrarArtistas() throws SQLException {
        super("Mostrar lista artistas");
        this.setSize(600,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel contenido = new JPanel();
            contenido.setBackground(Color.gray);
            titulo = new JLabel("Artistas registrados");
            titulo.setFont(new Font("titulo", Font.BOLD, 35));
            titulo.setForeground(Color.white);
            /////Lista de artistas////////
                dtm = new DefaultTableModel(datos,columnNames);
                table = new JTable(dtm);
                Controller.mostrarArtistas();
                table.setPreferredScrollableViewportSize(new Dimension(500, 200));
                scrollPane = new JScrollPane(table);
                getContentPane().add(scrollPane, BorderLayout.CENTER);
            //////Lista de artistas////////
        contenido.add(titulo);
        contenido.add(scrollPane);
        this.add(contenido);
    }
}
