/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import java.util.ArrayList;

import Characters.Player;
import Items_Inventario.AddCommand;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.ImmovableItemManager;
import Items_Inventario.Inventory;
import Items_Inventario.Item;
import Rooms.Sala;
/**
 * Inspeciona os items do jogador e da sala
 * @author Lara
 */
public class InspectCommand implements Command {
    private String name = "Inspect Command - chose what to inspect syntax inpet then what to inspect";
    public static final String[] COMMAND_NAMES = {"inspect", "inspeciona", "inspecionar","investigar", "investiga", "search", "investigate", "procurar", "procura", "procure", "analisar", "analyse", "analisa", "analise", "examinar", "examine", "examina", "examine"};
    private AddCommand addCommand;

    public String[] names() {
        return COMMAND_NAMES;
    }

    public InspectCommand(AddCommand addCommand) {
        this.addCommand = addCommand;
    }

    public void execute(Player player, ArrayList<String> words) throws Exception {
        Sala room = player.getPresentRoom();
        if (room == null) {
            throw new Exception("O Sherlock nao se encontra numa sala.");
        }
        Inventory pInventory = player.getInventory();
        Inventory rInventory = room.getInventory();
        Item item = null;
        for (String o : words) {
            if (pInventory.getItem(o) != null) {
                item = pInventory.getItem(o);
            } else if (rInventory.getItem(o) != null) {
                item = rInventory.getItem(o);
            }
        }

        if (item == null) {
            throw new Exception("Nao existe nenhum item com esse nome no inventario.");
        }

        System.out.println("O Sherlock inspeciona o objeto: " + item.getName() + ".");

        if (item instanceof ImmovabelItem) {
                ImmovableItemManager immovableState = new ImmovableItemManager();
                addCommand.addMany(player, immovableState.immovableState((ImmovabelItem) item)); 
        } else {
            System.out.println(item.getDescription());
            addCommand.addOne(player, item);
            player.getPresentRoom().getInventory().removeItem(item);
        }
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t";
        result += COMMAND_NAMES[0];
        for(int i = 1; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}