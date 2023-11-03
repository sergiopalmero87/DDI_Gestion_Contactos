package Vista;

import Controlador.Controlador;

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

        //Array de String con las columnas que hay(en este caso 2: Nombre y Telefono).
        String[] nombreColumnas = {"NOMBRE", "TELEFONO"};
        //El constructor nos pide el nombre de las columnas y el numero inicial de filas.
        //Le damos 0 filas porque se crearan cuando se haga click en añadir.
        tableModel = new DefaultTableModel(nombreColumnas, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 400, 400);
        add(scrollPane);

        //botonAdd
        botonAdd = new JButton("Añadir");
        botonAdd.setBounds(155, 550, 170, 30);
        botonAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        botonAdd.setForeground(Color.BLACK);
        botonAdd.setBackground(Color.white);
        botonAdd.isFocusable();
        add(botonAdd);

        //botonEdit
        botonEdit = new JButton("Editar");
        botonEdit.setBounds(500, 255, 170, 30);
        botonEdit.setFont(new Font("Dialog", Font.BOLD, 14));
        botonEdit.setForeground(Color.BLACK);
        botonEdit.setBackground(Color.white);
        add(botonEdit);

        //botonRemove
        botonRemove = new JButton("Eliminar");
        botonRemove.setBounds(500, 315, 170, 30);
        botonRemove.setFont(new Font("Dialog", Font.BOLD, 14));
        botonRemove.setForeground(Color.BLACK);
        botonRemove.setBackground(Color.white);
        add(botonRemove);

        icono = new JLabel();
        icono.setIcon(new ImageIcon("Imagenes/usuario.png"));
        icono.setBounds(294,33,192,183);
        add(icono);

        //Damos el color desde la clase Color a la ventana
        getContentPane().setBackground(Color.lightGray);
    }

    // Funcion que se encargue de los listeners
    // Pública porque hay que llamarla desde Main
    //Parametro: el objeto de la clase que implementa la interfaz ActionListeners
    public void establecerManejador(Controlador controlador) {

        // El boton se queda a la escucha y le pasamos como parametro
        // Quien implementa la interfaz ActionListener que es Controlador.
        botonAdd.addActionListener(controlador);

        botonEdit.addActionListener(controlador);

        botonRemove.addActionListener(controlador);
    }

    //Funcion add contacto, necesita el nombre y el telefono del contacto para funcionar.
    public void addContact(String nombre, String telefono){
        //Creamos un array de String formado por el nombre y el telefono del nuevo cliente.
        //y luego se lo pasamos al tableModel que es el DefaultTableModel.
        String[] newContact = {nombre, telefono};
        tableModel.addRow(newContact);
    }

    public void editContact(String nombreNuevo, String telefonoNuevo){
        String[] newContact = {nombreNuevo, telefonoNuevo};
        tableModel.addRow(newContact);
    }
}
