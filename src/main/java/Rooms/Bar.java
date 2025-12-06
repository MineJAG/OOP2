/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Clues;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;
import Items_Inventario.UsableItem;

import java.util.ArrayList;
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
            new Inventory(), 
            new ArrayList<Npc>());
            this.lockedN = lockedN;
            initializeInventory();
    }
    public boolean isLocked() {
        return lockedN;
    }

    public void setLocked(boolean lockedN) {
        this.lockedN = lockedN;
    }

    public void checkLocked() {
        if (lockedN) {
            System.out.println("A biblioteca está trancada. Precisa de encontrar uma forma de a abrir.");
        } else {
            System.out.println("A biblioteca está agora desbloqueada. Pode entrar e explorar os seus segredos.");
        }
    }

    // Método para destrancar
    public void unlockNorth() {
        lockedN = false;
        System.out.println("A biblioteca Norte está agora desbloqueada!");
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
}
