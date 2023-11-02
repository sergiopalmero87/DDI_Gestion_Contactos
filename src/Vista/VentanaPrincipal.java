package Vista;

import Controlador.Controlador;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    //Variable globales
    private JButton botonAdd, botonEdit, botonRemove;

    //Para la tabla necesitamos el defaultModel que es donde se meten los datos
    //Luego esos datos se meten en la tabla y la tabla en el ScrollPane por si hay desbordamiento de los datos.
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    private JLabel icono;


    //Constructor
    public VentanaPrincipal(){
        // Creamos titulo de la ventana
        setTitle("Gestion de contactos");

        setSize(700, 700); // Tamaño en pixels ancho y alto.

        setLocationRelativeTo(null); // Esto lo centra en la pantalla.
        // Lo de arriba lo puedo hacer con setBounds(x, y, ancho y alto);

        // evitamos que el cliente pueda modificar el tamaño
        setResizable(false);

        // Ponemos imagen en la ventana
        setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/usuario.png"));

        // Comportamiento de la X de la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Esto hace que se cierre.

        // Desactivamos el organizador de los componentes antes de llamar a la funcion
        // porque los situamos nosotros.
        setLayout(null);

        // Para no tener todas las cosas en el constructor, creamos funciones con logica.
        inicializarComponentes();

        // Una vez creada la ventana, al final, tenemos que hacer la visible.
        setVisible(true);

    }

    //Getters porque los atributos son privados
    public JButton getBotonAdd() {
        return botonAdd;
    }

    public JButton getBotonEdit() {
        return botonEdit;
    }

    public JButton getBotonRemove() {
        return botonRemove;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void inicializarComponentes(){

        //Damos el color desde la clase Color a la ventana
        getContentPane().setBackground(Color.LIGHT_GRAY);

        //botonAdd
        botonAdd = new JButton("Añadir");
        botonAdd.setBounds(200, 550, 170, 30);
        botonAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        botonAdd.setForeground(Color.BLACK);
        botonAdd.setBackground(Color.white);
        botonAdd.isFocusable();
        add(botonAdd);

        //botonRemove
        botonRemove = new JButton("Eliminar");
        botonRemove.setBounds(500, 300, 170, 30);
        botonRemove.setFont(new Font("Dialog", Font.BOLD, 14));
        botonRemove.setForeground(Color.BLACK);
        botonRemove.setBackground(Color.white);
        add(botonRemove);

        //botonEdit
        botonEdit = new JButton("Editar");
        botonEdit.setBounds(500, 400, 170, 30);
        botonEdit.setFont(new Font("Dialog", Font.BOLD, 14));
        botonEdit.setForeground(Color.BLACK);
        botonEdit.setBackground(Color.white);
        add(botonEdit);

        icono = new JLabel();
        icono.setIcon(new ImageIcon("Imagenes/usuario.png"));
        icono.setBounds(294,33,192,183);
        add(icono);


    }

    // Funcion que se encargue de los listeners
    // Publica porque hay que llamarla desde Main
    //Parametro: el objeto de la clase que implementa la interfaz ActionListeners
    public void establecerManejador(Controlador controlador) {

        // El boton se queda a la escucha y le pasamos como parametro
        // Quien implementa la interfaz ActionListener que es Controlador.
        botonAdd.addActionListener(new Controlador(this));

        botonEdit.addActionListener(new Controlador(this));

        botonRemove.addActionListener(new Controlador(this));
    }
}
