# Proyecto de gestión de contactos utilizando Java Swing para 2ºDAM.

## Descripción

Esta es una aplicación básica de gestión de contactos que tiene la opción de añadir, editar y eliminar contactos con su nombre y número de teléfono.


## Características Principales

- **Agregar Contactos:** Añade a la lista un nuevo contacto con su nombre y número de teléfono.

- **Editar Contactos:** Actualiza en la lista la información del contacto seleccionado.

- **Eliminar Contactos:** Elimina de la lista el contacto seleccionado.

- **Instrucciones:** Al pulsar sobre el logo en la ventana principal se mostrarán las instrucciones de la app.

## Capturas de pantalla de las ventanas.

1.  Ventana principal donde se muestra una lista de contactos en una tabla
    de dos columnas y con tres botones para la lógica. La tabla dispone
    de una barra de desplazamiento por si hay desbordamientos de filas.

    ![Ventana principal](/Imagenes/Req_1.png)

2.  Botón **AÑADIR**. 
    Al hacer clic en este botón, se abrirá una nueva ventana que permitirá al usuario ingresar los datos del contacto: 
    nombre y número de teléfono. 
    Después de ingresar los detalles del contacto y hacer clic en "OK", el contacto se agregará a la lista en la ventana principal.

    ![Añadir contacto](/Imagenes/Req_2.png)
    ![Añadir contacto](/Imagenes/Req_2.2.png)
    ![Añadir contacto](/Imagenes/Req_2.3.png)

3.  Botón **EDITAR**.
    Al hacer clic en este botón, se abrirá otra ventana que permitirá al usuario editar los detalles del contacto
    seleccionado previamente para modificarlos. Al hacer clic en “OK” la tabla
    de la ventana principal se actualizará automáticamente con los datos
    modificados. 

    ![Editar contacto](/Imagenes/Req_3.png)
    ![Editar contacto](/Imagenes/Req_3.2.png)
    ![Editar contacto](/Imagenes/Req_3.3.png)

4.  Botón **ELIMINAR**.
    Al hacer clic en este botón, se eliminará el contacto de la lista que se haya seleccionado.

    ![Contacto eliminado](/Imagenes/Req_4.png)

5. **INSTRUCCIONES**.
    Al hacer click en el logo de la ventana principal se muestran las instrucciones báscias, o la forma de utilizar la app.

    ![Instrucciones](/Imagenes/Instrucciones.png)

## Capturas de pantalla de validación de datos. 

1. Controlamos que el usuario ingrese bien los datos antes de permitir que se añada nada a la lista.

    ![Validar añadir](/Imagenes/Val_1.png)
    ![Validar añadir](/Imagenes/Val_2.png)

2. Primero controlamos que el usuario seleccione un contacto de la lista y después los datos antes de permitir editar el contacto.

    ![Validar editar](/Imagenes/Val_3.png)
    ![Validar editar](/Imagenes/Val_4.png)
    ![Validar editar](/Imagenes/Val_5.png)

3. Controlamos también que el usuario seleccione un contacto antes de eliminarlo de la lista.

    ![Validar eliminar](/Imagenes/Val_6.png)

