package Vista;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import Controlador.Controller;

public class VentanaInicial extends JFrame implements ActionListener{

    JButton boton_nuevo_artista;
    JButton boton_nuevo_disco;
    JButton boton_mostrar_artistas;
    JButton boton_consulta_datos_artista;
    JButton boton_modificar_datos_artista;
    JButton boton_eliminar_artista_discos;


    public VentanaInicial(){
        super("Menu");
        setLayout(null);
        this.setSize(750,450);
        Boton_nuevo_artista();
        Boton_nuevo_disco();
        Boton_mostrar_artistas();
        Boton_consulta_datos_artista();
        Boton_modificar_datos_artista();
        Boton_eliminar_artista_discos();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void Boton_nuevo_artista(){
        boton_nuevo_artista=new JButton("Agregar artista nuevo");
        boton_nuevo_artista.setBounds(10,50,250,30);
        add(boton_nuevo_artista);
        boton_nuevo_artista.addActionListener(this);
    }
    private void Boton_nuevo_disco(){
        boton_nuevo_disco=new JButton("Agregar disco nuevo");
        boton_nuevo_disco.setBounds(10,100,250,30);
        add(boton_nuevo_disco);
        boton_nuevo_disco.addActionListener(this);
    }
    private void Boton_mostrar_artistas(){
        boton_mostrar_artistas=new JButton("Mostrar lista de artistas");
        boton_mostrar_artistas.setBounds(10,150,250,30);
        add(boton_mostrar_artistas);
        boton_mostrar_artistas.addActionListener(this);
    }
    private void Boton_consulta_datos_artista(){
        boton_consulta_datos_artista=new JButton("Consultar artista");
        boton_consulta_datos_artista.setBounds(10,200,250,30);
        add(boton_consulta_datos_artista);
        boton_consulta_datos_artista.addActionListener(this);
    }
    private void Boton_modificar_datos_artista(){
        boton_modificar_datos_artista=new JButton("Modificar datos de artista");
        boton_modificar_datos_artista.setBounds(10,250,250,30);
        add(boton_modificar_datos_artista);
        boton_modificar_datos_artista.addActionListener(this);
    }
    private void Boton_eliminar_artista_discos(){
        boton_eliminar_artista_discos=new JButton("Eliminar un artista");
        boton_eliminar_artista_discos.setBounds(10,300,250,30);
        add(boton_eliminar_artista_discos);
        boton_eliminar_artista_discos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton_nuevo_artista) {
            Controller.vistaAgregarArtista();
        }
        if (e.getSource()==boton_nuevo_disco) {
            Controller.vistaAgregarDisco();
        }

    }
}
