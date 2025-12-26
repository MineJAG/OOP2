/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Clues;
import Items_Inventario.Inventory;

/**
 * Gere a inicialização da sala Sala VIP
 * @author Tiago
 */
public class VIP_room extends Sala{
    public VIP_room() {
        super("Sala VIP", 
        "Sala privada para convidados importantes do Lorde.\r\n" + 
        "É pequena, mas luxuosa e confortável\r\n" +
        "tem sofás confortáveis e elegantes como decoração requintada.\r\n" +
        "Há uma lareira acesa que emite um calor acolhedor...\r\n" +
        "hum.\r\n" +
        "Npcs: \n- Victor\r\n" +
        "Salas: \nE - Sala Principal", 
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
        in.addItem(new Clues("Relógio", "O relógio de bolso do Lorde. Parou exatamente às 22:14, coinside com a hora da morte."));
        super.getInventory().addInventory(in);
    }
}
