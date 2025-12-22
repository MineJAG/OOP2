/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;


/**
 *
 * @author tiago
 */
public class Main_hall extends Sala{
    public Main_hall(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Sala Principal", 
            "Uma sala num estilo barroco e estravagante, tem uns pilhadores artisticos, mesas decoradas, e janelas com artes\r\n" + 
            "o piso de mármore está molhado e a chuva ecoa lá fora.\r\n" +
            "Os convidados parecem assustados.\r\n" +
            "Um rastro de água leva até à porta norte, está entreaberta...hum?", 
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory()); 
            initializeInventory();   
            NpcSpawner();
    }
    
    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Pegadas Húmidas", ""));
        in.addItem(new UsableItem("Livro", "", getName()));
        super.getInventory().addInventory(in);
    }

    @Override
    public void NpcSpawner(){
        npcs.add(new Npc("pedro4",this));
    }
}
