/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;

import java.util.ArrayList;

import com.mycompany.oop2.UserInputReader;

/**
 *
 * @author Bibby
 */
public class ImmovableItemManager {
    private UserInputReader reader = new UserInputReader();

    public Inventory immovableState(ImmovabelItem item) {
        if (item.isLocked()) {
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

        if (item.isHoldingItems()) {
            // faz uma cópia dos itens ANTES de limpar
            Inventory loot = item.getItems().copy();
            item.clearItems();  // agora sim, esvazia o container
            return loot;        // devolve a cópia com os itens
        } else {
            return new Inventory();  // nada dentro
        }
    }

}
