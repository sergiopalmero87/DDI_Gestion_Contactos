package Controlador;

import Vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    //Creamos instancia de ventana principal para poder acceder a ella.
    private VentanaPrincipal ventana;

    //Constructor.
    //El constructor necesita un parametro.
    //El parametro es el objeto ventana de la clase VentanaPrincipal instanciado en la clase Main.
    public Controlador(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Para saber a que boton hacemos click, utilizamos e y con el codigo fuente sabemos quien ha sido haciendo una comparacion.
        //Para ello necesitamos getter de los botones porque son privados.
        //Si el boton ha sido añadir:
        if(e.getSource() == ventana.getBotonAdd()) {

        }
        //Si el boton ha sido editar:
        else if (e.getSource() == ventana.getBotonEdit()){

        }
    }
}
