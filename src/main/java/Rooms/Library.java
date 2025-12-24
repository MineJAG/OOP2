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
 *
 * @author tiago
 */
public class Library extends Sala{
    public Library() {
        super("Biblioteca",
            "A sala tem estantes com livros amarelados empilhados em ordem rigorosa, janelas entreabertas filtram a luz fria.\r\n" +
            "Chão de madeira rangente sob os pés.\r\n" +
            "Um lugar onde cada detalhe poderia revelar algo importante...\r\n" +
            "Talvez encontre algo útil aqui.", 
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
        in.addItem(new Clues("Documento_perdido", "No documento diz: Este livro é uma maravilha tenciono publica-lo em meu nome. Mas... Victor não pode descobrir sobre isto.\r\n" + "Assinado: Alistair Blackwood"));
        in.addItem(new UsableItem("Fosforos","Uma fonte de luz fraca mas, capaz de iluminar algo.","Depósito"));//apanhado por npc
        in.addItem(new ImmovabelItem("Estante", "Uma estante com livros. \r\n"+"O Lorde realmente adorava ler."));
        super.getInventory().addInventory(in);
    }
    
}
