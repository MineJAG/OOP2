/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;

/**
 * Gere a inicialização da sala Casa de Banho
 * @author Tiago
 */
public class Bathroom extends Sala{
    public Bathroom() {
        super("Casa de Banho", 
            "Tem espelhos embaciados e partidos, toalhas largadas no chão e sangue espalhado pela pia.\r\n"+
            "Como se alguém tivesse fugido num ímpeto desesperado...\r\n"+
            "Estranho...\r\n" +
            "Npcs: \n- Empregada\r\n" +
            "Salas: \nW - Sala Principal\n", 
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
        in.addItem(new ImmovabelItem("Sanita", "É uma sanita..."));
        in.addItem(new ImmovabelItem("Pia", "É uma pia... e está cheia de sangue..humm."));
        super.getInventory().addInventory(in);
    }

    
}
