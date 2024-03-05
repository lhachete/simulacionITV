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
public class FaseRevisio {
    private final String nom;
    private Vehicle vehicle;
    
    public FaseRevisio (String nom){
        this.nom = nom;
    }
    
    public boolean teVehicle (){
        return vehicle != null;
    }
    
    public void assignarVehicle (Vehicle vehicle){
        this.vehicle = vehicle;
    }
    
    public void desassignarVehicle(){
        this.vehicle = null;
    }
    
    public void mostrar (){   
        System.out.println("Fase " + nom);
        System.out.println("[ Vehículo asignado ]");
            if (this.teVehicle()) {
                System.out.println(vehicle);
            } else {
                System.out.println("Ninguno.");
                System.out.println("");
            }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void assignarVehicleA(FaseRevisio faseRevisio){
        
    }
    
    
    
}
