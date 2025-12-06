/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;

import java.util.ArrayList;

import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;

/**
 *
 * @author tiago
 */
public class Room extends Sala{
    public Room(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Quarto", 
        "O Quarto pessoal de Lady Eleanor e do Lord Blackwood.\r\n" +
        "Percebo uma cama grande ensanguentada, um armário antigo e uma secretária com alguns papéis espalhados.\r\n" +
        "O corpo do lorde permanece jogado na cama, com uma expressão de choque no rosto...Uma pena de facto.\r\n" +
        "Mas quem seria capaz de tal ato hediondo?...hum.",
        directionN, 
        directionS, 
        directionE, 
        directionW, 
        new Inventory(), 
        new ArrayList<Npc>());    
        initializeInventory();
    }

    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Sangue", ""));
        in.addItem(new Clues("Cortina vermelha", ""));
        in.addItem(new UsableItem("Caixa de medicamentos", "", getName()));
        in.addItem(new ImmovabelItem("Gaveta", "é uma gaveta", in,"tem merda"));
        super.getInventory().addInventory(in);
    }
}
