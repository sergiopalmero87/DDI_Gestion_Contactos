package Controlador;

import Vista.VentanaAdd;
import Vista.VentanaEdit;
import Vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        //creamos instancia de clase VentanaPrincipal para que se muestre.
        VentanaPrincipal ventana = new VentanaPrincipal();

        //El controlador necesita la ventana porque es lo que va a manejar
        Controlador controlador = new Controlador(ventana);

        //La ventana necesita al controlador porque es quien la va a manejar.
        ventana.establecerManejador(controlador);

        //Creamos instancia de VentanaAdd para que se muestre
        VentanaAdd ventanaAdd = new VentanaAdd();

        //Creamos instancia de VentanaEdit para que se muestre
        VentanaEdit ventanaEdit = new VentanaEdit();
    }
}
