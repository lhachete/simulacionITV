/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itv;
import itv.util.GestorIO;
import itv.util.Interval;

import itv.util.Interval;

/**
 *
 * @author Miguel
 */
public class Menu {
    
    private final String [] TITOLS = {"1. Alta i recepció de vehicles",
                              "2. Reclamar vehicle per a entrar al box",
                              "3. Moure tots els vehicles de fase dins d’un box",
                              "4. Informació de l'estat d'un box concret",
                              "5. Informació general de tots els boxes",
                              "6. Eixir del programa"};
    private final Interval OPCIONS = new Interval(1, 6);
    
    
    public void mostrar(){
        for (int i = 0; i < TITOLS.length; i++) {
            System.out.println(TITOLS[i]);
        }
    }
    
    public int llegirOpcio(){
        GestorIO lector = new GestorIO();
        return lector.inInt();
    }
    
}
