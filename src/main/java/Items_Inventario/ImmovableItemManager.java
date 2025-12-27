/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;

import com.mycompany.oop2.UserInputReader;

/**
 * Gere os items imóveis.
 * @author Lara
 */
public class ImmovableItemManager {
    private UserInputReader reader = new UserInputReader();

    public Inventory immovableState(ImmovabelItem item) {
        if (item.isLocked() && item.getCODE() != null) {
            System.out.println(item.getDescription() + "\nInsira o código para abrir o item: ");
            String code = reader.readInputLine();
            if (code.equals(item.getCODE())) {
                item.unlock();
            } else {
                System.out.println("Código incorreto.");
                return new Inventory(); 
            }
        }

        System.out.println(item.getDescription());

        if (item.isHoldingITEMS()) {
            Inventory loot = item.getITEMS().copy();
            item.clearITEMS(); 
            return loot;    
        } else {
            return new Inventory(); 
        }
    }
}
