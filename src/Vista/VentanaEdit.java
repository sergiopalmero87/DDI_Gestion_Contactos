package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaEdit extends JDialog {

    //Varibles globales
    private JButton botonOk, botonCancel;
    private JTextField nombreAlumno, telefonoAlumno;
    private JLabel nombre, telefono, nombreInfo, telefonoInfo;

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

    public JButton getBotonOk() {
        return botonOk;
    }

    public void setBotonOk(JButton botonOk) {
        this.botonOk = botonOk;
    }

    public JButton getBotonCancel() {
        return botonCancel;
    }

    public void setBotonCancel(JButton botonCancel) {
        this.botonCancel = botonCancel;
    }

    public JTextField getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(JTextField nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public JTextField getTelefonoAlumno() {
        return telefonoAlumno;
    }

    public void setTelefonoAlumno(JTextField telefonoAlumno) {
        this.telefonoAlumno = telefonoAlumno;
    }

    public JLabel getNombre() {
        return nombre;
    }

    public void setNombre(JLabel nombre) {
        this.nombre = nombre;
    }

    public JLabel getTelefono() {
        return telefono;
    }

    public void setTelefono(JLabel telefono) {
        this.telefono = telefono;
    }

    public void inicializarComponentes(){
        nombre = new JLabel("Nombre: ");
        nombre.setFont(new Font("Dialog", Font.BOLD, 14));
        nombre.setBounds(100, 80, 120, 50);
        nombre.setForeground(Color.WHITE);
        add(nombre);

        nombreAlumno = new JTextField();
        nombreAlumno.setBounds(180,85,120,40);
        add(nombreAlumno);

        nombreInfo = new JLabel("Solo letras.");
        nombreInfo.setBounds(190, 120, 120, 20);
        nombreInfo.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 12));
        nombreInfo.setForeground(Color.WHITE);
        add(nombreInfo);

        telefono = new JLabel("Telefono: ");
        telefono.setFont(new Font("Dialog", Font.BOLD, 14));
        telefono.setBounds(100, 180, 120, 50);
        telefono.setForeground(Color.WHITE);
        add(telefono);

        telefonoAlumno = new JTextField();
        telefonoAlumno.setBounds(180,185,120,40);
        add(telefonoAlumno);

        telefonoInfo = new JLabel("Solo numeros. (9)");
        telefonoInfo.setBounds(190, 220, 120, 20);
        telefonoInfo.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 12));
        telefonoInfo.setForeground(Color.WHITE);
        add(telefonoInfo);

        botonOk = new JButton("OK");
        botonOk.setBounds(95, 310,100, 40);
        botonOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonOk);

        botonCancel = new JButton("CANCEL");
        botonCancel.setBounds(225, 310,100, 40);
        botonCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonCancel);

        getContentPane().setBackground(new Color(63, 108, 125));
    }

    public void cancelEdit(){
        JOptionPane.showMessageDialog(this, "Cancelado");
        nombreAlumno.setText("");
        telefonoAlumno.setText("");
    }
}
