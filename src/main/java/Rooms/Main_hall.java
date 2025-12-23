/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;


/**
 *
 * @author tiago
 */
public class Main_hall extends Sala{
    public Main_hall() {
        super("Sala Principal", 
            "Uma sala num estilo barroco e estravagante, tem uns pilhadores artisticos, mesas decoradas, e janelas com artes\r\n" + 
            "o piso de mármore está molhado e a chuva ecoa lá fora.\r\n" +
            "Os convidados parecem assustados.\r\n" +
            "Um rastro de água leva até à porta norte, está entreaberta...hum?", 
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
        in.addItem(new Clues("Pegadas_úmidas", "São pegadas úmidas, levam até ao Depósito. humm..."));
        in.addItem(new UsableItem("Livro", "Um livro em mau estado, talvez haja alguém que saiba de alguma coisa acerca dele...", getName()));
        in.addItem(new ImmovabelItem("Pilar", "É um pilar não me ajuda muito"));
        in.addItem(new ImmovabelItem("Mesa", "Uma mesa bem decorada, uma pena que não está na hora de comer."));
        in.addItem(new Clues("Ursinho","Hum...estranho...Contém os números 2026"));
        super.getInventory().addInventory(in);
    }

}
