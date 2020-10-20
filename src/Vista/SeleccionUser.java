package Vista;

import Controlador.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import static Controlador.Controller.agregarDisco;

public class SeleccionUser extends JFrame implements ActionListener{

    JPanel contenido;
    JPanel formulario;
    JLabel titulo;
    JTable table;
    JScrollPane scrollPane;
    String[] columnNames = {"ID", "Nombre", "Apellido", "Localidad"};
    Object[][] datos = {};
    public static DefaultTableModel dtm;
    Choice inputID;
    JLabel peticion;
    JButton btEditar;

    ArrayList<Integer> lista_IDs ;

    public SeleccionUser() throws SQLException {
        super("Editar Artistas");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        contenido = new JPanel();
        contenido.setBackground(Color.gray);
            titulo = new JLabel("Editar Artistas");
                titulo.setFont(new Font("titulo", Font.BOLD, 35));
                titulo.setForeground(Color.white);
            /////Lista de artistas////////
            dtm = new DefaultTableModel(datos, columnNames);
            table = new JTable(dtm);
            lista_IDs = Controller.listarArtistas();
            table.setPreferredScrollableViewportSize(new Dimension(500, 100));
            scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            //////Lista de artistas////////
        formulario = new JPanel();
            formulario.setPreferredSize(new Dimension(500,50));
            //////Formulario y boton///////
            peticion = new JLabel("ID del artista a editar:");
                peticion.setFont(new Font("peticion",Font.BOLD,14));
                peticion.setSize(200,40);
                inputID = new Choice();
                    for(int i=0;i<lista_IDs.size();i++){
                        inputID.addItem(String.valueOf(lista_IDs.get(i)));
                    }
            btEditar = new JButton("Editar");
                btEditar.setSize(200,40);
            //////Formulario y boton///////
        formulario.add(peticion);
        formulario.add(inputID);
        formulario.add(btEditar);
        contenido.add(titulo);
        contenido.add(scrollPane);
        contenido.add(formulario, BorderLayout.NORTH);
        btEditar.addActionListener((ActionListener) this);
        this.add(contenido);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource()==btEditar) {
            try {
                Controller.sacarDatosArtista(Integer.parseInt(inputID.getSelectedItem()));
                Controller.seleccionUser.setVisible(false);
                Controller.seleccionUser.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}