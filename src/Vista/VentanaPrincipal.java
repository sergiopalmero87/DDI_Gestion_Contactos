package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {

    // Variable globales
    private JButton botonAdd, botonEdit, botonRemove, botonGuardar, botonCargar;
    private JLabel nombreApp;
    // Para la tabla necesitamos el defaultModel que es donde se meten los datos
    // Luego esos datos se meten en la tabla y la tabla en el ScrollPane por si hay
    // desbordamiento de los datos.
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    // Constructor
    public VentanaPrincipal() {
        // Creamos titulo de la ventana
        setTitle("Gestion de contactos");

        // Icono de la aplicacion.
        setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/contacto.png"));

        setSize(700, 700); // Tamaño en pixels ancho y alto.

        setLocationRelativeTo(null); // Esto lo centra en la pantalla.
        // Lo de arriba lo puedo hacer con setBounds(x, y, ancho y alto);

        // evitamos que el cliente pueda modificar el tamaño
        setResizable(false);

        // Desactivamos el organizador de los componentes antes de llamar a la funcion
        // porque los situamos nosotros.
        setLayout(null);

        // Comportamiento de la X de la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Esto hace que se cierre.

        // Para no tener todas las cosas en el constructor, creamos funciones con
        // logica.
        inicializarComponentes();

        // Una vez creada la ventana, al final, tenemos que hacer la visible.
        setVisible(true);

    }

    // Getters porque los atributos son privados
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

    public JButton getBotonGuardar() {
        return botonGuardar;
    }

    public JButton getBotonCargar() {
        return botonCargar;
    }

    private void inicializarComponentes() {

        // Tabla
        // Array de String con las columnas que hay(en este caso 2: Nombre y Telefono).
        String[] nombreColumnas = { "NOMBRE", "TELEFONO" };
        // El constructor nos pide el nombre de las columnas y el numero inicial de
        // filas.
        // Le damos 0 filas porque se crearan cuando se haga click en añadir.
        tableModel = new DefaultTableModel(nombreColumnas, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 400, 420);
        table.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 14));
        add(scrollPane);

        // Fuente del titulo de mi app.
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("JetBrainsMono-Regular.ttf"));
            nombreApp = new JLabel("CONTACTIFY");
            nombreApp.setHorizontalAlignment(SwingConstants.CENTER);
            nombreApp.setFont(font.deriveFont(Font.BOLD, 40f));
            nombreApp.setBounds(45, 20, 400, 70);
            nombreApp.setForeground(Color.WHITE);
            add(nombreApp);

        } catch (FontFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        // botonAdd
        botonAdd = new JButton("Añadir");
        botonAdd.setBounds(155, 550, 190, 35);
        botonAdd.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 18));
        botonAdd.setForeground(Color.BLACK);
        botonAdd.setBackground(Color.WHITE);
        botonAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonAdd);

        // botonEdit
        botonEdit = new JButton("Editar");
        botonEdit.setBounds(500, 200, 170, 35);
        botonEdit.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 16));
        botonEdit.setForeground(Color.BLACK);
        botonEdit.setBackground(Color.WHITE);
        botonEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonEdit);

        // botonRemove
        botonRemove = new JButton("Eliminar");
        botonRemove.setBounds(500, 250, 170, 35);
        botonRemove.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 16));
        botonRemove.setForeground(Color.BLACK);
        botonRemove.setBackground(Color.WHITE);
        botonRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonRemove);

        // boton guardar.
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(500, 350, 170, 35);
        botonGuardar.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 16));
        botonGuardar.setForeground(Color.BLACK);
        botonGuardar.setBackground(Color.WHITE);
        botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonGuardar);

        // boton cargar.
        botonCargar = new JButton("Cargar");
        botonCargar.setBounds(500, 400, 170, 35);
        botonCargar.setFont(new Font("HelveticaNeue.ttc", Font.PLAIN, 16));
        botonCargar.setForeground(Color.BLACK);
        botonCargar.setBackground(Color.WHITE);
        botonCargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botonCargar);

        // Icono de la aplicacion en la ventana principal
        Image image = new ImageIcon("Imagenes/contacto.png").getImage();
        JLabel logo = new JLabel(new ImageIcon(image.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        logo.setBounds(540, 25, 80, 80);
        add(logo);

        // Damos el color desde la clase Color a la ventana
        getContentPane().setBackground(new Color(50, 95, 121));
        getContentPane().validate();

    }

    // Funcion que se encargue de los listeners
    // Pública porque hay que llamarla desde Main
    // Parametro: el objeto de la clase que implementa la interfaz ActionListeners
    public void establecerManejador(Controlador controlador) {

        // El boton se queda a la escucha y le pasamos como parametro
        // Quien implementa la interfaz ActionListener que es Controlador.
        botonAdd.addActionListener(controlador);

        botonEdit.addActionListener(controlador);

        botonRemove.addActionListener(controlador);

        botonGuardar.addActionListener(controlador);

        botonCargar.addActionListener(controlador);
    }

    // Funcion add contacto, necesita el nombre y el telefono del contacto para
    // funcionar.
    public void addContact(String nombre, String telefono) {
        // Creamos un array de String formado por el nombre y el telefono del nuevo
        // cliente.
        // y luego se lo pasamos al tableModel que es el DefaultTableModel.
        String[] newContact = { nombre, telefono };
        tableModel.addRow(newContact);
    }
}
