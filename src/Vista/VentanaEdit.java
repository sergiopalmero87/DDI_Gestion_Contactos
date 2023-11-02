package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaEdit extends JFrame {

    //Varibles globales
    private JButton botonOk, botonCancel;
    private JTextField nombreAlumno, telefonoAlumno;
    private JLabel nombre, telefono;

    //Constructor
    public VentanaEdit(){
        //Titulo
        setTitle("Editar contacto");

        // Tamaño en pixels ancho y alto.
        setSize(400, 400);

        // Esto lo centra en la pantalla.
        setLocationRelativeTo(null);

        // evitamos que el cliente pueda modificar el tamaño
        setResizable(false);

        // Desactivamos el organizador de los componentes antes de llamar a la funcion
        // porque los situamos nosotros.
        setLayout(null);

        // Para no tener todas las cosas en el constructor, creamos funciones con logica.
        inicializarComponentes();

        // Una vez creada la ventana, al final, tenemos que hacer la visible.
        setVisible(true);
    }

    public void inicializarComponentes(){
        nombre = new JLabel("Nombre: ");
        nombre.setFont(new Font("Dialog", Font.BOLD, 14));
        nombre.setBounds(100, 80, 120, 50);
        add(nombre);

        nombreAlumno = new JTextField();
        nombreAlumno.setBounds(180,80,120,50);
        add(nombreAlumno);

        telefono = new JLabel("Telefono: ");
        telefono.setFont(new Font("Dialog", Font.BOLD, 14));
        telefono.setBounds(100, 180, 120, 50);
        add(telefono);

        telefonoAlumno = new JTextField();
        telefonoAlumno.setBounds(180,180,120,50);
        add(telefonoAlumno);

        botonOk = new JButton("OK");
        botonOk.setBounds(125, 310,100, 40);
        add(botonOk);

        botonCancel = new JButton("CANCEL");
        botonCancel.setBounds(225, 310,100, 40);
        add(botonCancel);
    }
}
