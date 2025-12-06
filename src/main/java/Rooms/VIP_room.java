/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import java.util.ArrayList;
import Characters.Npc;
import Items_Inventario.Inventory;



/**
 *
 * @author tiago
 */
public class VIP_room extends Sala{
    public VIP_room(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Sala VIP", 
        "Sala privada para convidados importantes do Lorde.\r\n" + 
        "É pequena, mas luxuosa e confortável\r\n" +
        "tem sofás confortáveis e elegantes como decoração requintada.\r\n" +
        "Há uma lareira acesa que emite um calor acolhedor...\r\n" +
        "hum.", 
        directionN, 
        directionS, 
        directionE, 
        directionW, 
        new Inventory(), 
        new ArrayList<Npc>());    
    }
    
}
