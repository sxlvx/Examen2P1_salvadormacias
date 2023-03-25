package com.mycompany.examen2p1_salvadormacias;

import java.util.ArrayList;
import java.util.Random;

public class Gusanito {

    private ArrayList<String> instrucciones;
    private char[][] tablero;
    private int xGusanito, yGusanito, xManzana, yManzana;

    public Gusanito(int N, int M) {
        if (N < 4 || M < 4 || N > 10 || M > 10) {
            throw new IllegalArgumentException("El rango de N y M debe de  estar entre 4 y 10");
        }
        this.tablero = new char[N][M];
        this.instrucciones = new ArrayList<String>();
        this.xGusanito = new Random().nextInt(N);
        this.yGusanito = new Random().nextInt(M);
        this.xManzana = new Random().nextInt(N);
        this.yManzana = new Random().nextInt(M);
    }

    public void agregarInstruccion(String instruccion) {
        this.instrucciones.add(instruccion);
    }

    public void mover() {
        int n = 0;
        String direccion = "";
        for (String instruccion : instrucciones) {
            n = Integer.parseInt(instruccion.substring(0, instruccion.length() - 2));
            direccion = instruccion.substring(instruccion.length() - 2);
            for (int i = 0; i < n; i++) {
                switch (direccion) {
                    case "UP":
                        if (xGusanito > 0) {
                            xGusanito--;
                            imprimirTablero();
                        }
                        break;
                    case "DN":
                        if (xGusanito < tablero.length - 1) {
                            xGusanito++;
                            imprimirTablero();
                        }
                        break;
                    case "RT":
                        if (yGusanito < tablero[0].length - 1) {
                            yGusanito++;
                            imprimirTablero();
                        }
                        break;
                    case "LT":
                        if (yGusanito > 0) {
                            yGusanito--;
                            imprimirTablero();
                        }
                        break;
                    default:
                        System.out.println("Instrucción no reconocida");
                }
            }
        }
    }

    public void imprimirTablero() {
        tablero[xGusanito][yGusanito] = 'G';
        tablero[xManzana][yManzana] = 'M';
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        tablero[xGusanito][yGusanito] = '\u0000';
    }

}
