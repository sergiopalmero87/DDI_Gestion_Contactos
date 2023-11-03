package Controlador;

import Vista.VentanaAdd;
import Vista.VentanaEdit;
import Vista.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    //Creamos instancia de ventana principal para poder acceder a ella.
    private VentanaPrincipal ventana;
    private VentanaAdd ventanaAdd;
    private VentanaEdit ventanaEdit;

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

        //Si el boton ha sido añadir: Se abre la ventana añadir
        if(e.getSource() == ventana.getBotonAdd()) {
            ventanaAdd = new VentanaAdd();

            //Ponemos a la escucha al boton de OK
            ventanaAdd.getBotonOk().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String telefono = ventanaAdd.getTelefonoAlumno().getText();
                    String nombre = ventanaAdd.getNombreAlumno().getText();
                    if(!nombre.isEmpty() && !telefono.isEmpty()){
                        ventana.addContact(nombre, telefono);
                        ventanaAdd.dispose(); //Cerramos la ventana cuando se hace click
                    }else{
                        JOptionPane.showMessageDialog(ventanaAdd, "Por favor, rellene todos los campos para añadir el contacto.");
                    }
                }
            });

            //Ponemos en escucha al boton de CANCEL
            ventanaAdd.getBotonCancel().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ventanaAdd.cancelAdd();
                }
            });

        }

        //Si el boton ha sido editar -> Se abre la ventana editar
        else if (e.getSource() == ventana.getBotonEdit()){
            int filaSeleccionada = ventana.getTable().getSelectedRow();

            if(filaSeleccionada == -1){
                JOptionPane.showMessageDialog(ventana, "Seleccione el contacto para editar");
            }else{
                //Seleccionamos una fila de la DefaultTableModel y le asignamos variables al contenido.
                String nombreActual = ventana.getTableModel().getValueAt(filaSeleccionada, 0).toString();
                String telefonoActual = ventana.getTableModel().getValueAt(filaSeleccionada, 1).toString();

                //Abrimos la ventanaEdit
                ventanaEdit = new VentanaEdit();

                //Mostramos en los TextField el nombre y el telefono del usuario seleccinado.
                ventanaEdit.getNombreAlumno().setText(nombreActual);
                ventanaEdit.getTelefonoAlumno().setText(telefonoActual);

                //Ponemos en escucha al boton OK.
                ventanaEdit.getBotonOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String telefonoNuevo = ventanaEdit.getTelefonoAlumno().getText();
                        String nombreNuevo = ventanaEdit.getNombreAlumno().getText();

                        if(!nombreNuevo.isEmpty() && !telefonoNuevo.isEmpty()){
                            ventana.getTableModel().setValueAt(nombreNuevo, filaSeleccionada, 0);
                            ventana.getTableModel().setValueAt(telefonoNuevo, filaSeleccionada, 1);
                            ventanaEdit.dispose();
                        }else{
                            JOptionPane.showMessageDialog(ventanaAdd, "Por favor, rellene todos los campos para editar el contacto.");
                        }
                    }
                });

                //Ponemos en escucha al boton de CANCEL.
                ventanaEdit.getBotonCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventanaEdit.cancelEdit();
                    }
                });
            }


            }

        }

    }

