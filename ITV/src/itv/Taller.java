/*
 * Programa a mitad, falta las fases de revisión. por lo demas todo bien.
 * Miguel Hernández Monllor
 */
package itv;

import itv.util.GestorIO;
import itv.util.Interval;

public class Taller {

    public static void main(String[] args) {

        Taller itv = new Taller();
        itv.inici();

    }

    Box[] boxs;
    CuaInicial cuaInicial;
    final int NUM_BOXS = 6;
    GestorIO lector = new GestorIO();
    Interval interval;

    public Taller() {
    }

    public void inici() {
        Menu menu = new Menu();
        boxs = new Box[NUM_BOXS];
        cuaInicial = new CuaInicial();

        for (int i = 0; i < NUM_BOXS; i++) {
            boxs[i] = new Box(i);
        }

        boolean semaforo = true;
        while (semaforo) {

            System.out.println("--------- MENÚ GESTIÓN DE ITV ---------");
            menu.mostrar();
            System.out.print("Opción: ");

            switch (menu.llegirOpcio()) {
                case 1:
                    System.out.println("\n### Alta y recepción de vehículos ###");
                    cuaInicial.afegir(recollirNouVehicle()); // Añadir un nuevo vehiculo con sus especificaciones a la cola inicial.

                    break;
                case 2:
                    System.out.println("\n### Reclamar vehículo para entrar al box ###");
                    if (cuaInicial.estaBuida() == false) { //SI hay vehiculos en la cola, continuar.
                        interval = new Interval(1, 6);
                        int elegirBox;
                        do {
                            System.out.print("Elige a que BOX se dirigirá el próximo vehiculo (1-6): ");
                            elegirBox = lector.inInt();

                        } while (!interval.inclou(elegirBox));
                        elegirBox -= 1;
                        // Verificar si el box seleccionado está disponible (EN SU 1ª FASE)
                        if (boxs[elegirBox].estaLliure() == true) {

                            boxs[elegirBox].afegir(cuaInicial.traure());
                            System.out.println("El primer vehículo en la cola ha entrado al BOX nº" + (elegirBox + 1));
                            boxs[elegirBox].mostrar();
                            cuaInicial.mostrar();

                        } else {
                            System.out.println("ERROR. La 1ª fase del BOX " + (elegirBox + 1) + " está ocupado por un vehículo.\n");
                        }
                    } else {
                        System.out.println("ERROR - La cola esta vacía, no hay ningún vehículo en ella.\n");
                    }

                    break;
                case 3:
                    System.out.println("\n### Mover todos los vehículos de fase dentro de un box ###");
                    interval = new Interval(1, 6);
                    int elegirBox;
                    do {
                        System.out.print("Elige un BOX para avanzar sus fases (1-6): ");
                        elegirBox = lector.inInt();
                    } while (!interval.inclou(elegirBox));
                    
                    if (boxs[elegirBox-1].hayVehiculosEnFases()) {
                        System.out.println("Los vehículos del Box han pasado de fase\n");
                        boxs[elegirBox - 1].passarVehiclesDeFase();
                    }else {
                        System.out.println("No hay vehículos para pasar de fase en el Box\n");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n### Información del estado de un box concreto ###");
                    int eleccionBox;
                    interval = new Interval(1, 6);
                    do {
                        System.out.print("Elige un Box (1-6): ");
                        eleccionBox = lector.inInt();
                    } while (!interval.inclou(eleccionBox));
                    System.out.println("");
                    System.out.println("------ BOX Nº " + (eleccionBox) + " ------");
                    boxs[eleccionBox - 1].mostrarFaseDeRevisio();

                    break;
                case 5:
                    System.out.println("\n### Información general de to"
                            + "dos los boxes ###");
                    for (int i = 0; i < NUM_BOXS; i++) {
                        System.out.println("------ BOX Nº " + (i + 1) + " ------");
                        boxs[i].mostrarFaseDeRevisio();
                    }
                    break;
                case 6:
                   semaforo = false;
                    break;
                    
                default:
                    System.out.println("Error, elige un número válido.\n");
            }

        }

    }

    public Vehicle recollirNouVehicle() {
        Vehicle nou = new Vehicle(llegirMatricula(), llegirModel(), llegirTipusVehicle());
        return nou;
    }

    public String llegirMatricula() {
        String matricula;
        do {
            System.out.print("Indica la matrícula de tu vehículo (EJ: 1234ABC): ");
            matricula = lector.inString();
            if (!cuaInicial.estaBuida() && cuaInicial.conteMatricula(matricula)) {
                System.out.println("Ya hay un vehículo con la misma matrícula");
                matricula = "";
            }
        } while (!matricula.matches(Vehicle.PATRO_MATRICULA));

        return matricula;
    }

    public String llegirModel() {
        System.out.print("Introduce el módelo de tu coche: ");
        return lector.inString();
    }

    public TipusVehicle llegirTipusVehicle() {
        int index;
        interval = new Interval(1, 5);
        do {
            System.out.print("1.COTXE   ");
            System.out.print("2.FURGONETA   ");
            System.out.print("3.MICROBÚS   ");
            System.out.print("4.CAMIÓ   ");
            System.out.println("5. NINGÚ");
            System.out.print("Indica con un número tu tipo de vehículo: ");
            index = lector.inInt();
        } while (!interval.inclou(index));

        TipusVehicle tipo = Vehicle.tipusSegonsIndex(index);
        return tipo;
    }

    public Box llegirBox() {
        return null; //????????????
    }

    public void mostrarBoxs() {

    }

}
