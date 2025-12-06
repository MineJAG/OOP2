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
public class Storage extends Sala{
    private boolean isLightOn = false;
    public Storage(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Depósito", 
            "O quarto está numa escuridão total, não vejo nada...\r\n"+
            "Sinto um cheiro a mofo e pó.\r\n" +
            "Se ao menos tivesse algo...", 
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory(), 
            new ArrayList<Npc>());
    }

    public void lightUp() {
        if (!isLightOn) {
            isLightOn = true;
        }
    }
}
