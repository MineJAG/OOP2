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
public class Office extends Sala{
    public Office() {
        super("Escritório", 
            "O escritório do Lorde...\r\n" +
            "Possui uma secretária com documentos e livros de contabilidade por toda a parte.\r\n" +
            "Uma cadeira de couro gasta está por trás da secretária.\r\n" +
            "E na parede, um quadro de um homem de aparência severa.\r\n" +
            "Há também uma estante com vários livros antigos e um cofre embutido na parede.\r\n" +
            "Talvez exista algo importante aqui...", 
            null, 
            null, 
            null, 
            null, 
            new Inventory());
            initializeInventory();
            NpcSpawner();
    }

    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Cópia de um livro", ""));
        in.addItem(new Clues("Testamento Alterado", ""));
        in.addItem(new UsableItem("Carta", "", getName()));
        in.addItem(new ImmovabelItem("Cofre", "merda", in, "piça", "aberto", "vazio"));
        super.getInventory().addInventory(in);
    }

    @Override
    public void NpcSpawner(){
        npcs.add(new Npc("pedro5",this));
    }
}
