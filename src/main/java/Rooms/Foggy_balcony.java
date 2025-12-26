/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Inventory;

/**
 * Gere a inicialização da sala Varanda
 * @author Tiago
 */
public class Foggy_balcony extends Sala{
    public Foggy_balcony() {
        super("Varanda Nebulosa", 
            "A Varanda está coberta pela névoa. Está silencioso...Perturbador..\r\n" + 
            "A névoa densa envolve tudo, tornando difícil de ver além de alguns metros.\r\n" + 
            "O ar é frio e úmido, com um cheiro leve de terra molhada\r\n" +
            "Salas: \nS - Quarto\n",
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
        super.getInventory().addInventory(in);
    }

}
