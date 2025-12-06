/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import java.util.ArrayList;
import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;


/**
 *
 * @author tiago
 */
public class Library extends Sala{
    public Library(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Biblioteca",
            "A sala tem estantes com livros amarelados empilhados em ordem rigorosa, janelas entreabertas filtram a luz fria.\r\n" +
            "Chão de madeira rangente sob os pés.\r\n" +
            "Um lugar onde cada detalhe poderia revelar algo importante...\r\n" +
            "Talvez encontre algo útil aqui.", 
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
        in.addItem(new Clues("Verdade sobre o livro", ""));
        in.addItem(new UsableItem("Fósforos","","Depósito"));
        super.getInventory().addInventory(in);
    }
    
}
