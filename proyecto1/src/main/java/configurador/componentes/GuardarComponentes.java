/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurador.componentes;

/**
 *
 * @author Paula Rodríguez A
 */

import com.mycompany.proyecto1.ArmaAerea;
import com.mycompany.proyecto1.ArmaAtaqueMultiple;
import com.mycompany.proyecto1.ArmaBloque;
import com.mycompany.proyecto1.ArmaContacto;
import com.mycompany.proyecto1.ArmaImpacto;
import com.mycompany.proyecto1.ArmaMedianoAlcance;

import com.mycompany.proyecto1.ZombieAereo;
import com.mycompany.proyecto1.ZombieChoque;
import com.mycompany.proyecto1.ZombieDeContacto;
import com.mycompany.proyecto1.ZombieMedio;

import com.mycompany.proyecto1.Componente;

/**
 * Clase estática encargada de mapear los objetos de configuración (TipoComponente)
 * a los objetos funcionales del juego (subclases de Componente).
 */
public class GuardarComponentes {
/*
    public static Componente crearComponente(TipoComponente tipoConfig) {
        
        // 1. Extraer todos los datos del objeto de configuración
        int vida = tipoConfig.getVida();
        int danio = tipoConfig.getDanio();
        int nivel = tipoConfig.getNivelAparicion();
        int golpes = tipoConfig.getGolpesPorTiempo();
        int rango = tipoConfig.getRango();
        String imagen = tipoConfig.getImagen();
        String subtipo = tipoConfig.getSubtipo();
        String nombre = tipoConfig.getNombre(); // El nombre también es importante

        // =====================================================================
        // 2. Lógica para DEFENSAS
        // =====================================================================
        
        if ("Defensa".equals(tipoConfig.getTipo())) {
            
            // Nota: Se asume que el constructor de Defensas es: 
            // (vida, danio, nivelAparicion, golpesPorTiempo, rango, imagen)
            switch (subtipo) {
                case "Bloque":
                    return new ArmaBloque(vida, danio, nivel, golpes, rango, imagen);
                case "Contacto":
                    return new ArmaContacto(vida, danio, nivel, golpes, rango, imagen);
                case "MedianoAlcance":
                    return new ArmaMedianoAlcance(vida, danio, nivel, golpes, rango, imagen);
                case "Aerea":
                    return new ArmaAerea(vida, danio, nivel, golpes, rango, imagen);
                case "Impacto":
                    return new ArmaImpacto(vida, danio, nivel, golpes, rango, imagen);
                case "AtaqueMultiple":
                    return new ArmaAtaqueMultiple(vida, danio, nivel, golpes, rango, imagen);
                default:
                    throw new IllegalArgumentException("Subtipo de Defensa desconocido: " + subtipo);
            }
        } 
        
        // =====================================================================
        // 3. Lógica para ZOMBIES (Nueva implementación)
        // =====================================================================
        else if ("Zombie".equals(tipoConfig.getTipo())) {
            
            // Nota: Se asume que el constructor de Zombies también usa la misma firma
            // (vida, danio, nivelAparicion, golpesPorTiempo, rango, imagen)
            switch (subtipo) {
                case "Aereo":
                    return new ZombieAereo(vida, danio, nivel, golpes, rango, imagen);
                case "Choque":
                    return new ZombieChoque(vida, danio, nivel, golpes, rango, imagen);
                case "Contacto": // Usamos el nombre de subtipo "Contacto" para el zombie
                    return new ZombieDeContacto(vida, danio, nivel, golpes, rango, imagen);
                case "Medio":
                    return new ZombieMedio(vida, danio, nivel, golpes, rango, imagen);
                default:
                    throw new IllegalArgumentException("Subtipo de Zombie desconocido: " + subtipo);
            }
        }
        
        // 4. Error si el tipo principal no es reconocido
        throw new IllegalArgumentException("Tipo de componente principal desconocido: " + tipoConfig.getTipo());
    }

*/
}