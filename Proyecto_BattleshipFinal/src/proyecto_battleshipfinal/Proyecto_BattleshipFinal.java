/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_battleshipfinal;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author casti
 */
public class Proyecto_BattleshipFinal {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        //Matrices que manipulamos
        String[][] JugadorA = new String[6][5];
        String[][] JugadorB = new String[6][5];

        //Matrices que mostaremos 
        String[][] JugadorA2 = new String[6][5];
        String[][] JugadorB2 = new String[6][5];

        playBattleship(JugadorA, JugadorB, JugadorA2, JugadorB2);

    }

    public static String[][] llenado(String[][] matriz) {

        String[][] temp = new String[6][5];

        int cont = 0;
        while (cont <= 8) {

            cont++;

            int fila = 1 + ran.nextInt(5);
            int columna = 1 + ran.nextInt(4);

            for (int i = 0; i < temp.length; i++) {

                for (int j = 0; j < temp[i].length; j++) {

                    temp[fila][columna] = "⛵";
                    if (temp[i][j] != "⛵") {
                        temp[i][j] = " ";
                    }

                }

            }

        }
        return temp;
    }

    public static String[][] llenadovacio(String[][] matriz) { //para solo mostrar la matriz vacia (modo silencioso)

        String[][] temp = new String[6][5];

        for (int i = 0; i < temp.length; i++) {

            for (int j = 0; j < temp[i].length; j++) {

                temp[i][j] = " ";

            }

        }

        return temp;
    }

    public static void print(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                System.out.print("[" + matriz[i][j] + "]" + " ");

            }
            System.out.println();
        }

    }

    public static void playBattleship(String[][] JugadorA, String[][] JugadorB, String[][] Jugador2A, String[][] Jugador2B) {

        int pointsA = 0, pointsB = 0;
        JugadorA = llenado(JugadorA);
        JugadorB = llenado(JugadorB);

        //matrices para mostrar
        Jugador2A = llenadovacio(Jugador2A);
        Jugador2B = llenadovacio(Jugador2B);

        while (pointsA < 3 && pointsB < 3) {

            //Accion JugadorA
            System.out.println("\n == Coordenada a atacar / Jugador A ==");

            System.out.println("--- Tablero Enemigo ---");

            print(Jugador2B);

            System.out.print("Ingrese una fila Jugador A: ");
            int fila = sc.nextInt() - 1;
            System.out.print("Ingrese una columna Jugador A: ");
            int columna = sc.nextInt() - 1;

            while (fila >= 6 || fila < 0 || columna >= 5 || columna < 0) {
                System.out.println("Cordenadas invalidas!");
                System.out.print("Ingrese una fila Jugador A: ");
                fila = sc.nextInt() - 1;
                System.out.print("Ingrese una columna Jugador A: ");
                columna = sc.nextInt() - 1;

            }

            if (shootJA(fila, columna, JugadorB, Jugador2B)) {
                System.out.println("Tiro acertado cayó un barco!");
                pointsA++;
            } else {
                System.out.println("Bomba al agua!");
            }

            //Accion JugadorB
            System.out.println("\n  == Coordenada a atacar / Jugador B ==");

            System.out.println("--- Tablero Enemigo ---");

            print(Jugador2A);

            System.out.print("Ingrese una fila Jugador B: ");
            fila = sc.nextInt() - 1;
            System.out.print("Ingrese una columna Jugador B: ");
            columna = sc.nextInt() - 1;

            while (fila >= 6 || fila < 0 || columna >= 5 || columna < 0) {
                System.out.println("Cordenadas invalidas!");
                System.out.print("Ingrese una fila Jugador B: ");
                fila = sc.nextInt() - 1;
                System.out.print("Ingrese una columna Jugador B: ");
                columna = sc.nextInt() - 1;

            }

            if (shootJB(fila, columna, JugadorA, Jugador2A)) {
                System.out.println("Tiro acertado cayó un barco!");
                pointsB++;
            } else {
                System.out.println("Bomba al agua!");
            }

        }

        if (pointsA > pointsB) {
            System.out.println("Jugador A gana.");
        } else if (pointsA < pointsB) {
            System.out.println("Jugador B gana.");
        } else {
            System.out.println("¡Es un empate!");
        }

    }

    public static boolean shootJA(int fila, int columna, String[][] JugadorB, String[][] Jugador2B) {

        boolean tiro = false;

        for (int i = 0; i < JugadorB.length; i++) {

            for (int j = 0; j < JugadorB[i].length; j++) {

                if (JugadorB[fila][columna] == "⛵") {
                    Jugador2B[fila][columna] = "X";
                    JugadorB[fila][columna] = "X"; //probar
                    tiro = true;
                } else {
                    Jugador2B[fila][columna] = "X";
                    JugadorB[fila][columna] = "X";
                }

            }

        }

        return tiro;
    }

    public static boolean shootJB(int fila, int columna, String[][] JugadorA, String[][] Jugador2A) {

        boolean tiro = false;

        for (int i = 0; i < JugadorA.length; i++) {

            for (int j = 0; j < JugadorA[i].length; j++) {

                if (JugadorA[fila][columna] == "⛵") {
                    Jugador2A[fila][columna] = "X";
                    JugadorA[fila][columna] = "X";
                    tiro = true;
                } else {
                    Jugador2A[fila][columna] = "X";
                    JugadorA[fila][columna] = "X";//probar
                }

            }

        }

        return tiro;
    }

}
