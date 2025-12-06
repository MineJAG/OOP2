/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Inventory;
import java.util.ArrayList;
import Characters.Npc;

/**
 *
 * @author tiago
 */
public class Foggy_balcony extends Sala{
    public Foggy_balcony(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Varanda Nebulosa", 
            "A Varanda está coberta pela névoa. Está silencioso...Perturbador..\r\n" + 
            "A névoa densa envolve tudo, tornando difícil de ver além de alguns metros.\r\n" + 
            "O ar é frio e úmido, com um cheiro leve de terra molhada",
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory(), 
            new ArrayList<Npc>());    
    }
    
}
