package Vista;

import Controlador.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static Controlador.Controller.agregarArtista;
import static Controlador.Controller.agregarDisco;

public class NuevoDisco extends JFrame implements ActionListener {
    JLabel titulo;
    JLabel nombre;
    JLabel fecha_publi;
    JLabel id_artista;
    JTextField inputNombre;
    JTextField inputFecha_publi;
    JTextField inputId_artista;
    JButton boton_añadir_disco;

    public NuevoDisco(){
        super("Añadir nuevo disco");
        this.setSize(600,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JPanel contenido = new JPanel();
            contenido.setBackground(Color.gray);
                titulo = new JLabel("Añadir un disco nuevo");
                    titulo.setFont(new Font("titulo", Font.BOLD, 35));
                    titulo.setForeground(Color.white);
                    /////FORMULARIO////////
                nombre = new JLabel("Nombre: ");
                    nombre.setFont(new Font("Nombre", Font.BOLD, 14));
                    nombre.setBounds(150,95,150,30);
                    inputNombre = new JTextField();
                        inputNombre.setBounds(300,100,150,20);
                fecha_publi = new JLabel("Fecha publicación: ");
                    fecha_publi.setFont(new Font("FechaPublicacion", Font.BOLD, 14));
                    fecha_publi.setBounds(150,145,150,30);
                    inputFecha_publi = new JTextField();
                        inputFecha_publi.setBounds(300,150,150,20);
                id_artista = new JLabel("Id del artista: ");
                    id_artista.setFont(new Font("Id_artista: ", Font.BOLD, 14));
                    id_artista.setBounds(150,195,150,30);
                    inputId_artista = new JTextField();
                        inputId_artista.setBounds(300,200,150,20);
                    //////FORMULARIO////////
                    boton_añadir_disco = new JButton("Añadir Disco");
                        boton_añadir_disco.setBounds(185,270,150,30);
                        boton_añadir_disco.addActionListener(this);
            contenido.add(titulo);
            add(nombre);
            add(inputNombre);
            add(fecha_publi);
            add(inputFecha_publi);
            add(id_artista);
            add(inputId_artista);
            add(boton_añadir_disco);
        this.add(contenido);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton_añadir_disco) {
            try {
                agregarDisco(inputNombre.getText(), inputFecha_publi.getText(), Integer.parseInt(inputId_artista.getText()));
                Controller.nuevoDisco.setVisible(false);
                Controller.nuevoDisco.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
