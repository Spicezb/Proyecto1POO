/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurador.componentes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paula Rodríguez A
 */
public class GestorComponentes {
    private static final String NOMBRE_ARCHIVO = "componentes.ser";

    /**
     * Carga todos los componentes guardados del archivo serializado.
     * Si el archivo no existe o está vacío, devuelve una lista vacía.
     */
    public static ArrayList<TipoComponente> cargarComponentes() {
        
        ArrayList<TipoComponente> listaComponentes = new ArrayList<>();
        File archivo = new File(NOMBRE_ARCHIVO);

        
        if (archivo.exists() && archivo.length() > 0) {
            try (FileInputStream fileIn = new FileInputStream(archivo);
                 ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                
                listaComponentes = (ArrayList<TipoComponente>) objectIn.readObject();

            } catch (IOException e) {
                
                System.err.println("Error de I/O al cargar componentes: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                
                System.err.println("Error de clase: No se encuentra TipoComponente: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassCastException e) {
                 System.err.println("Error de casting: El archivo no contiene una List<TipoComponente>.");
                 e.printStackTrace();
            }
        }
        return listaComponentes;
    }

   
    public static void guardarComponente(TipoComponente nuevoComponente) {
        
        ArrayList<TipoComponente> listaActual = cargarComponentes();
        
        boolean actualizado = false;
        
        for (int i = 0; i < listaActual.size(); i++) {
            TipoComponente c = listaActual.get(i);
            if (c.getNombre().equals(nuevoComponente.getNombre())) {
                listaActual.set(i, nuevoComponente); // Reemplazar
                actualizado = true;
                break;
            }
        }
        
        if (!actualizado) {
            listaActual.add(nuevoComponente);
        }

        try (FileOutputStream fileOut = new FileOutputStream(NOMBRE_ARCHIVO);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(listaActual);
            
        } catch (IOException e) {
            System.err.println("Error de I/O al guardar componentes: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

}
