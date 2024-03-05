/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itv;

import itv.util.GestorIO;
import itv.util.Interval;

/**
 *
 * @author Miguel
 */
public class Box {

    private final int id;
    private final FaseRevisio[] fasesRevisio;
    private Vehicle vehicle;
    final static String[] TITOLS_FASES = {"1. Revisió inicial d'elements de seguretat",
        "2. Revisió del sistema elèctric",
        "3. Revisió d'emissió de fums",
        "4. Revisió de frens i direcció."};
    final int NUM_FASES = 4;

    public Box(int id) {
        this.id = id;
        fasesRevisio = new FaseRevisio[NUM_FASES];
        for (int i = 0; i < fasesRevisio.length; i++) {
            fasesRevisio[i] = new FaseRevisio(TITOLS_FASES[i]);
        }

    }

    public boolean estaLliure() {
        return fasesRevisio[0].teVehicle() != true; //false si hay un coche en la primera fase.
    }

    public boolean esPrimeraFase(int indexFase) {
        return true; // ?????????????
    }

    public void afegir(Vehicle vehicle) {
        this.vehicle = vehicle;
        fasesRevisio[0].assignarVehicle(vehicle);
    }

    public void passarVehiclesDeFase() {

        for (int i = 3; i >= 0; i--) {
            if (i == 3) {
                fasesRevisio[3].desassignarVehicle();
            } else if (i >= 0) {
                Vehicle aMover = fasesRevisio[i].getVehicle();
                fasesRevisio[i + 1].assignarVehicle(aMover);
            }
        }
        fasesRevisio[0].desassignarVehicle();
    }

    public void mostrar() {
        System.out.println(vehicle);
    }

    public void mostrarFaseDeRevisio() {
        for (int i = 0; i < NUM_FASES; i++) {
            fasesRevisio[i].mostrar();
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean hayVehiculosEnFases() {

        for (FaseRevisio faseRevisio : fasesRevisio) {
            if (faseRevisio.getVehicle() != null) {
                return true;
            }
        }
        return false;
    }
}