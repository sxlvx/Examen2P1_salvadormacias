package com.mycompany.examen2p1_salvadormacias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Examen2P1_salvadormacias extends JFrame {

    public static Scanner lea = new Scanner(System.in);
    public static Scanner str = new Scanner(System.in);

    public static void main(String[] args) {
        new Examen2P1_salvadormacias();
    }

    public Examen2P1_salvadormacias() {
        // Configuración de la ventana principal y titulo del menu
        setTitle("Examen 2 - Salvador Macias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        JLabel mensaje = new JLabel("Examen 2 - Salvador Macias");
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        mensaje.setFont(new Font("Arial", Font.PLAIN, 24));
        mensaje.setForeground(Color.BLACK);

        //botones
        JButton librosButton = new JButton("Libros y mas libros");
        JButton gusanitoButton = new JButton("Gusanito hambriento");
        JButton salirButton = new JButton("Salir");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(mensaje);
        panel.add(librosButton);
        panel.add(gusanitoButton);
        panel.add(salirButton);
        add(panel);
        setLocationRelativeTo(null);

        librosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Usted esta entrando al ejercicio Libros y mas libros");
                Libreria libreria = new Libreria();
                libreria.mostrarMenu();

            }
        });//fin libros

        gusanitoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Usted esta entrando al ejercicio Gusanito Hambriento");
                System.out.println("Ingrese N:");
                int N = lea.nextInt();
                System.out.println("Ingrese M:");
                int M = lea.nextInt();
                System.out.println("Ingrese una instruccion: ");
                String instruccion = str.nextLine();
                Gusanito gusanito = new Gusanito(N, M);
                gusanito.agregarInstruccion(instruccion);
                gusanito.mover();
                gusanito.imprimirTablero();

            }
        }
        );//fin gusanito

        salirButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

}//fin clase
