/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itv;

import itv.util.GestorIO;
import itv.util.Interval;
import java.util.Arrays;

/**
 *
 * @author Miguel
 */
public class CuaInicial {

    private Vehicle[] vehicles;
    private int contador = 1;

    public CuaInicial() {
        vehicles = new Vehicle[1];
    }

    public void afegir(Vehicle vehicle) { //se añadira un nuevo vehiculo al array incrementando también este. Además de informar al usuario en que posición esta.
        System.out.println("\nVehículo registrado satisfactoriamente.️");
        System.out.println("El vehiculo esta en la posición " + contador + " de la cola.");
        vehicles[contador - 1] = vehicle;
        System.out.println(vehicles[contador-1]);
     // vehicles[contador-1].toString();
        contador++;
        vehicles = Arrays.copyOf(vehicles, contador);
        
    }

    public Vehicle traure() { //Devolvemos el primer vehiculo de la cola, y movemos todos los vehiculos una posicion atras, disminuyendo el tamaño del nuevo array tambien.
        Vehicle primero = vehicles[0];
        vehicles[0] = null;
        for (int i = 1; i < vehicles.length; i++) {
            vehicles[i - 1] = vehicles[i];
        }
        contador--;
        vehicles = Arrays.copyOf(vehicles, contador);
        return primero; 
    } 

    public boolean estaBuida() {
        if (contador-1 == 0) {
            // System.out.print("ERROR - La cola esta vacía, ");
            return true;
        } else {
            //System.out.println("Vehículos en la cola: " + (contador - 1) + "\n");
            return false;
        }
    }

    public void mostrar() {
        System.out.println("Vehículos actuales en la cola: " + (contador - 1) + "\n");
    }

    public boolean conteMatricula(String matricula) {
        for (int i = 0; i < vehicles.length; i++) {
            if (matricula.equals(vehicles[i].getMatricula())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    

}
