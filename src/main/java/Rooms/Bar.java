/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Clues;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;
import Characters.Npc;

/**
 *
 * @author tiago
 */
public class Bar extends Sala {
    private boolean lockedN;
    public Bar(Sala directionN, Sala directionS, Sala directionE, Sala directionW, boolean lockedN) {
        super("bar", 
            "Vejo um Balcão de madeira rústico, as luzes estão baixas, tem copos pelo balcão,\r\n" +
            "e um insuportável cheiro a álcool...\r\n" +
            "Acolhedor...\r\n" +
            "hum.", 
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory());
            this.lockedN = lockedN;
            initializeInventory();
            NpcSpawner();
    }
    public boolean isLocked() {
        return lockedN;
    }

    public void setLocked(boolean lockedN) {
        this.lockedN = lockedN;
    }

    // Método para destrancar
    public void unlockNorth() {
        lockedN = false;
    }
    
    // Getter para saber se pode ir para norte
    public boolean canGoNorth() {
        return !lockedN;
    }

    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Pedaço de Cortina Vermelha", ""));
        in.addItem(new UsableItem("Chave dourada", "", "Bar"));
        in.addItem(new ImmovabelItem("Pilar", "nAO pode nover"));
        super.getInventory().addInventory(in);
    }

    @Override
    public void NpcSpawner(){
        npcs.add(new Npc("pedro",this));
    }
}
