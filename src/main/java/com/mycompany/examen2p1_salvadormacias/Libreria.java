package com.mycompany.examen2p1_salvadormacias;

import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {

    private ArrayList<String> titulos;
    private ArrayList<String> autores;
    public static Scanner lea = new Scanner(System.in);

    public Libreria() {
        titulos = new ArrayList<String>();
        autores = new ArrayList<String>();
    }

    public void agregarLibro() {

        System.out.print("Titulo: ");
        String titulo = lea.nextLine();
        System.out.print("Autor: ");
        String autor = lea.nextLine();
        titulos.add(titulo);
        autores.add(autor);
        System.out.println("El libro se ha agregado correctamente.");
    }

    public void eliminarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el indice del libro que desea eliminar: ");
        int indice = scanner.nextInt();
        if (indice >= 0 | indice < titulos.size()) {
            titulos.remove(indice);
            autores.remove(indice);
            System.out.println("El libro se elimino exitosamente.");
        } else {
            System.out.println("Índice ingresado no es valido .");
        }
    }

    public void listarLibros() {
        int i = 0;
        while (i < titulos.size()) {
            System.out.println("Libro " + (i + 1));
            System.out.println("Título: " + titulos.get(i));
            System.out.println("Autor: " + autores.get(i));
            i++;
        }
        if (titulos.size() == 0) {
            System.out.println("Se requiere almenos un libro para ejecutar esta opcion ");
        }

    }

    public void buscarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        int indice = titulos.indexOf(titulo);
        if (indice >= 0) {
            System.out.println("El libro está en inventario.");
        } else {
            System.out.println("Lo sentimos, el libro no está en inventario.");
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (salir != true) {
            System.out.println("---Libreria---\n1.Agregar libro\n2.Eliminar libro\n3.Listar\n4.Buscar por titulo\n5.Regresar al menu");
            System.out.print("opcion: ");
            int opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    listarLibros();
                    break;
                case 4:
                    buscarLibro();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del menú.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println("-------------------------------------------------");
        }
    }
}
