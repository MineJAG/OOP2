/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Clues;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;

/**
 * Gere a inicialização da sala Quarto
 * @author Tiago
 */
public class Room extends Sala{
    public Room() {
        super("Quarto", 
        "O Quarto pessoal de Lady Eleanor e do Lord Blackwood.\r\n" +
        "Percebo uma cama grande ensanguentada, um armário antigo e uma secretária com alguns papéis espalhados.\r\n" +
        "O corpo do lorde permanece jogado na cama, com uma expressão de choque no rosto...Uma pena de facto.\r\n" +
        "Mas quem seria capaz de tal ato hediondo?...hum.\r\n" +
        "Npcs: \n- Inspector\r\n" +
        "Salas: \nN - Varanda Nebulosa\nE - Biblioteca\n",
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
        Inventory gaveta = new Inventory();
        in.addItem(new Clues("Sangue", "A cama e o chão estão completamente sujos de sangue, parece sangue do Lorde. Uma pena..."));
        in.addItem(new Clues("Cortina_vermelha", "A cortina aparenta estar rasgada..humm... Onde é que vi algo parecido?"));
        in.addItem(new UsableItem("Carta_Rasgada", "Segundo a carta: O Lorde estava afundado em dívidas.", "Eleanor")); //npcs
        gaveta.addItem(new UsableItem("Medicamentos", "Uma caixa de medicamentos para dormir...", "Rick ")); //npcs
        in.addItem(new ImmovabelItem("Gaveta", "Uma gaveta", gaveta ,"Está vazia"));
        in.addItem(new ImmovabelItem("Cama", "A cama onde o lorde se encontra morto."));
        super.getInventory().addInventory(in);
    }
}
