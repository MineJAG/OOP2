/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.Inventory;

/**
 *
 * @author tiago
 */
public class Bathroom extends Sala{
    public Bathroom() {
        super("Casa de Banho", 
            "Tem espelhos embaciados e partidos, toalhas largadas no chão e sangue espalhado pela pia.\r\n"+
            "Como se alguém tivesse fugido num ímpeto desesperado...\r\n"+
            "Estranho...", 
            null, 
            null, 
            null, 
            null, 
            new Inventory()); 
            initializeInventory(); 
    }

    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Luvas", "Estão sujas com manchas de sangue seco. São luvas masculinas com um “V” manuscrito no pulso das luvas. Estranho…"));
        super.getInventory().addInventory(in);
    }

    
}
