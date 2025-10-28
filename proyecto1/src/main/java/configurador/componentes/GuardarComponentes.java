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


public class GuardarComponentes {

    public static Componente crearComponente(TipoComponente tipoConfig) {
        
        
        int vida = tipoConfig.getVida();
        int danio = tipoConfig.getDanio();
        int nivel = tipoConfig.getNivelAparicion();
        int golpes = tipoConfig.getGolpesPorTiempo();
        int rango = tipoConfig.getRango();
        String imagen = tipoConfig.getImagen();
        String subtipo = tipoConfig.getSubtipo();
        String nombre = tipoConfig.getNombre(); 
        int id = 2;
        int velocidad = tipoConfig.getVelocidad();

        
        if ("Defensa".equals(tipoConfig.getTipo())) {
            
            
            switch (subtipo) {
                case "Bloque":
                    return new ArmaBloque(id++, nivel, nombre, imagen, vida);
                case "Contacto":
                    return new ArmaContacto(id++, danio, golpes, rango, nivel, nombre, imagen, vida);
                case "Mediano Alcance":
                    return new ArmaMedianoAlcance(id++, danio, golpes, rango, nivel, nombre, imagen, vida);
                case "Aerea":
                    return new ArmaAerea(id++, danio, golpes, rango, nivel, nombre, imagen, vida);
                case "Impacto":
                    return new ArmaImpacto(id++, danio, golpes, rango, nivel, nombre, imagen, vida);
                case "Ataque múltiple":
                    return new ArmaAtaqueMultiple(id++, danio, golpes, rango, nivel, nombre, imagen, vida);
                default:
                    throw new IllegalArgumentException("Subtipo de Defensa desconocido: " + subtipo);
            }
        } 
        else if ("Zombie".equals(tipoConfig.getTipo())) {
            
            
            switch (subtipo) {
                case "Aereo":
                    return new ZombieAereo(id++, danio, velocidad, golpes, nivel, nombre, imagen, vida);
                case "Choque":
                    return new ZombieChoque(id++, danio, velocidad, golpes, nivel, nombre, imagen, vida);
                case "Contacto": 
                    return new ZombieDeContacto(id++, danio, velocidad, golpes, nivel, nombre, imagen, vida);
                case "Medio":
                    return new ZombieMedio(id++, danio, velocidad, golpes, nivel, nombre, imagen, vida);
                default:
                    throw new IllegalArgumentException("Subtipo de Zombie desconocido: " + subtipo);
            }
        }
        
        throw new IllegalArgumentException("Tipo de componente principal desconocido: " + tipoConfig.getTipo());
    }


}