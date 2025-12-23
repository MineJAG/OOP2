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
    public Bar(boolean lockedN) {
        super("bar", 
            "Vejo um Balcão de madeira rústico, as luzes estão baixas, tem copos pelo balcão,\r\n" +
            "e um insuportável cheiro a álcool...\r\n" +
            "Acolhedor...\r\n" +
            "hum.", 
            null, 
            null, 
            null, 
            null, 
            new Inventory());
            this.lockedN = lockedN;
            initializeInventory();
            NpcSpawner();
    }
    
    // Método para destrancar
    public void unlockNorth() {
        lockedN = false;
    }
    
    // Getter para saber se pode ir para norte
    @Override
    public boolean canGo(String direction) {
        if (direction.equalsIgnoreCase("north")){
            return !lockedN;
        }
        return true;
    }

    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Cortina Vermelha", "Um retalho de uma cortina vermelha... De onde será? Talvez alguém o reconheça."));
        in.addItem(new UsableItem("Chave", "Uma chave dourada, está um pouco enferrujada. hum? Talvez possa abrir algo com ela.", getName()));
        in.addItem(new UsableItem("Copo", "Um copo com algum tipo de pó dentro.", null));//Npc
        in.addItem(new ImmovabelItem( "Copos sujos", "copos com restos de bebida, não é hora de festejar"));
        super.getInventory().addInventory(in);
    }

    @Override
    public void NpcSpawner(){
        npcs.add(new Npc("pedro",this));
    }
}
