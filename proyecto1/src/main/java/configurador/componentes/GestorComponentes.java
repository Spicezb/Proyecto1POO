/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurador.componentes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;


/**
 *
 * @author Paula Rodríguez A
 */
public class GestorComponentes {
    
    private static final String RUTA = "componentes.json";

    public static void guardarComponente(TipoComponente componente) {
        List<TipoComponente> lista = cargarComponentes();
        lista.add(componente);
        try (Writer writer = new FileWriter(RUTA)) {
            new Gson().toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<TipoComponente> cargarComponentes() {
        try (Reader reader = new FileReader(RUTA)) {
            return new Gson().fromJson(reader, new TypeToken<List<TipoComponente>>(){}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
}
