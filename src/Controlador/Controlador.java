package Controlador;

import Vista.VentanaAdd;
import Vista.VentanaEdit;
import Vista.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener {

    // Creamos instancia de ventana principal para poder acceder a ella.
    private VentanaPrincipal ventana;
    private VentanaAdd ventanaAdd;
    private VentanaEdit ventanaEdit;

    // Constructor.
    // El constructor necesita un parametro.
    // El parametro es el objeto ventana de la clase VentanaPrincipal instanciado en
    // la clase Main.
    public Controlador(VentanaPrincipal ventana) {
        this.ventana = ventana;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Para saber a que boton hacemos click, utilizamos e y con el codigo fuente
        // sabemos quien ha sido haciendo una comparacion.
        // Para ello necesitamos getter de los botones porque son privados.

        // Si el boton ha sido añadir: Se abre la ventana añadir
        if (e.getSource() == ventana.getBotonAdd()) {
            ventanaAdd = new VentanaAdd();

            // Ponemos a la escucha al boton de OK
            ventanaAdd.getBotonOk().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Asignamos variables al contenido que hay dentro del campo de texto.
                    String nombre = ventanaAdd.getNombreAlumno().getText();
                    String telefono = ventanaAdd.getTelefonoAlumno().getText();

                    // Si los campos estan rellenos se añade el contacto y si no
                    // lanzamos mensaje.
                    // Utilizamos expresiones regulares dentro del if que nos sirven para validar.
                    if (!nombre.isEmpty() && nombre.matches("[a-zA-Z]+") && !telefono.isEmpty()
                            && telefono.matches("[0-9]+") && telefono.length() <= 9) {
                        ventana.addContact(nombre, telefono);
                        ventanaAdd.dispose(); // Cerramos la ventana cuando se hace click
                    } else {
                        JOptionPane.showMessageDialog(ventanaAdd,
                                "Por favor, rellene correctamente todos los campos para añadir el contacto.");
                    }
                }
            });

            // Ponemos en escucha al boton de CANCEL
            ventanaAdd.getBotonCancel().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ventanaAdd.cancelAdd();
                    ventanaAdd.dispose();
                }
            });

        }

        // Si el boton ha sido editar ->
        else if (e.getSource() == ventana.getBotonEdit()) {

            // Asignamos la fila que seleccionamos de la Table a una variable para poder
            // usarla luego.
            int filaSeleccionada = ventana.getTable().getSelectedRow();

            // Si la fila seleccionada es -1 (porque es un array) mandamos el mensaje.
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(ventana, "Seleccione el contacto para editar");

                // Si seleccionamos una fila de la DefaultTableModel le asignamos variables al
                // contenido.
                // Hay que convertirlo a String porque filaSelecionado es un Int.
            } else {
                String nombreActual = ventana.getTableModel().getValueAt(filaSeleccionada, 0).toString();
                String telefonoActual = ventana.getTableModel().getValueAt(filaSeleccionada, 1).toString();

                // Abrimos la ventanaEdit
                ventanaEdit = new VentanaEdit();

                // Mostramos en los TextField el nombre y el telefono del usuario seleccinado.
                ventanaEdit.getNombreAlumno().setText(nombreActual);
                ventanaEdit.getTelefonoAlumno().setText(telefonoActual);

                // Ponemos en escucha al boton OK.
                ventanaEdit.getBotonOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Cuando se escriban los nuevos datos los almacenamos en nuevas variables
                        String telefonoNuevo = ventanaEdit.getTelefonoAlumno().getText();
                        String nombreNuevo = ventanaEdit.getNombreAlumno().getText();

                        // Si los campos estan rellenos se actualiza el contenido de la Table
                        // y si no se lanza el mensaje.
                        if (!nombreNuevo.isEmpty() && nombreNuevo.matches("[a-zA-z]+") && !telefonoNuevo.isEmpty()
                                && telefonoNuevo.matches("[0-9]+") && telefonoNuevo.length() <= 9) {
                            ventana.getTableModel().setValueAt(nombreNuevo, filaSeleccionada, 0);
                            ventana.getTableModel().setValueAt(telefonoNuevo, filaSeleccionada, 1);
                            ventanaEdit.dispose();
                        } else {
                            JOptionPane.showMessageDialog(ventanaAdd,
                                    "Por favor, rellene correctamente todos los campos para editar el contacto.");
                        }
                    }
                });

                // Ponemos en escucha al boton de CANCEL.
                ventanaEdit.getBotonCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventanaEdit.cancelEdit();
                        ventanaEdit.dispose();
                    }
                });
            }

        }
        // Si el boton ha sido eliminar ->
        else if (e.getSource() == ventana.getBotonRemove()) {

            // Seleccionamos la fila de la tabla que queremos eliminar y la almacenamos en
            // una variable
            int filaSeleccionada = ventana.getTable().getSelectedRow();

            // Si no se selecciona ninguna fila lanzamos el mensaje
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(ventana, "Seleccione el contacto para eliminar");

                // Elimina la fila seleccionada del DefaultTableModel con el metodo removeRow de
                // la clase DefalutTableModel
            } else {
                ventana.getTableModel().removeRow(filaSeleccionada);
            }
        }

        else if(e.getSource() == ventana.getBotonGuardar()){
            JOptionPane.showMessageDialog(ventana, "¡Guardado!");

        }

        else if (e.getSource() == ventana.getBotonCargar()){
            JOptionPane.showMessageDialog(ventana, "Cargando...");
            
        }

    }

}
