/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurador.componentes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;


/**
 *
 * @author Paula Rodríguez A
 */
public class GestorComponentes {
    
    private static final String RUTA = "componentes.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private static final java.lang.reflect.Type LIST_TYPE = new TypeToken<List<TipoComponente>>(){}.getType();
    
    public static void guardarComponente(TipoComponente componente) {
        
        List<TipoComponente> lista = cargarComponentes();
        lista.add(componente);
        try (Writer writer = new FileWriter(RUTA)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<TipoComponente> cargarComponentes() {
        File file = new File(RUTA);
        if (!file.exists()) {
            return new ArrayList<>(); // Si el archivo no existe, devuelve una lista vacía
        }
        try (Reader reader = new FileReader(RUTA)) {
            List<TipoComponente> lista = gson.fromJson(reader, LIST_TYPE);
            return lista != null ? lista : new ArrayList<>(); // Devuelve lista o lista vacía si falla la lectura
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
}
