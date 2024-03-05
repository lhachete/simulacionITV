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
public class Vehicle {
    
    String matricula;
    String model;
    TipusVehicle tipusVehicle;
    final static String PATRO_MATRICULA = "\\d{4}[A-Z]{3}";
    
    public Vehicle (String matricula, String model, TipusVehicle tipus){
        this.matricula = matricula;
        this.model = model;
        tipusVehicle = tipus;
    }
    
    public boolean teEsta(String matricula){
        boolean aux = this.matricula.equals(matricula);
        return aux;
    }
    
    public String toString(){
        return "Matricula: " + matricula + "\nModelo: " + model + "\nTipo: " + tipusVehicle + "\n";
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public static TipusVehicle tipusSegonsIndex (int index){
        
        switch (index){
            case 1:
                return TipusVehicle.COTXE;
            case 2:
                return TipusVehicle.FURGONETA;
            case 3:
                return TipusVehicle.MICROBÚS;
            case 4:
                return TipusVehicle.CAMIÓ;
            default:
                return TipusVehicle.RES;
        }
        
    }
    
}
