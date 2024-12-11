/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vueltaatras;

/**
 *
 * @author Sergio
 */
public class Reinas {

    public static boolean colocarReinas(int reina, int[] tablero) {

        int col = 0;
        boolean objetivo = false;

        while (col < tablero.length && !objetivo) {
            if (buenSitio(reina, col, tablero)) {
                tablero[reina] = col;
                if (reina == 7) {
                    objetivo = true;
                } else {
                    objetivo = colocarReinas(reina + 1, tablero);
                    if(!objetivo){
                        tablero[reina] = -1;
                    }
                }
            }
            col++;
        }

        return objetivo;
    }

    private static boolean buenSitio(int r, int col, int[] tabl) {
// ¿Es amenaza colocar la reina “r” en la columna “col”?
        int reiAnt = 0;
        boolean continuar = true;
        while (reiAnt < r && continuar) {
            if (tabl[reiAnt] == col) {
                continuar = false;
            } else if (Math.abs(reiAnt - r) == Math.abs(tabl[reiAnt] - col)) {
                continuar = false;
            }
            reiAnt++;
        }
        return continuar;

    }
}
