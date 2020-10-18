package Vista;

import Controlador.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static Controlador.Controller.agregarArtista;

public class NuevoArtista extends JFrame implements ActionListener {
    JLabel titulo;
    JLabel nombre;
    JLabel apellido;
    JLabel localidad;
    JTextField inputNombre;
    JTextField inputApellido;
    JTextField inputLocalidad;
    JButton boton_añadir_artistas;

    public NuevoArtista(){
        super("Añadir nuevo artista");
        this.setSize(600,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JPanel contenido = new JPanel();
            contenido.setBackground(Color.gray);
                titulo = new JLabel("Añadir un artista nuevo");
                    titulo.setFont(new Font("titulo", Font.BOLD, 35));
                    titulo.setForeground(Color.white);
                    /////FORMULARIO////////
                nombre = new JLabel("Nombre: ");
                    nombre.setFont(new Font("Nombre", Font.BOLD, 14));
                    nombre.setBounds(150,95,100,30);
                    inputNombre = new JTextField();
                        inputNombre.setBounds(225,100,150,20);
                apellido = new JLabel("Apellido: ");
                    apellido.setFont(new Font("apellido", Font.BOLD, 14));
                    apellido.setBounds(150,145,100,30);
                    inputApellido = new JTextField();
                        inputApellido.setBounds(225,150,150,20);
                localidad = new JLabel("Localidad: ");
                    localidad.setFont(new Font("localidad: ", Font.BOLD, 14));
                    localidad.setBounds(150,195,100,30);
                    inputLocalidad = new JTextField();
                        inputLocalidad.setBounds(225,200,150,20);
                    //////FORMULARIO////////
                    boton_añadir_artistas = new JButton("Añadir artista");
                        boton_añadir_artistas.setBounds(185,270,150,30);
                        boton_añadir_artistas.addActionListener(this);
            contenido.add(titulo);
            add(nombre);
            add(inputNombre);
            add(apellido);
            add(inputApellido);
            add(localidad);
            add(inputLocalidad);
            add(boton_añadir_artistas);
        this.add(contenido);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton_añadir_artistas) {
            try {
                agregarArtista(inputNombre.getText(), inputApellido.getText(), inputLocalidad.getText());
                Controller.nuevoArtista.setVisible(false);
                Controller.nuevoArtista.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
