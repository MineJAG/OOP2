/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.ArrayList;

import Characters.Npc;
import Characters.Player;
import Dialogue.DialogueManager;
import Items_Inventario.UsableItem;
import Rooms.Bar;
import Rooms.ItemUsedRoom;
import Rooms.Storage;
/**
 *
 * @author Bibby
 */
public class UseCommand implements Command {
    private String name = "Use command - choose an item to use ";
    private DialogueManager manager;
    public static final String[] COMMAND_NAMES = {"use", "usar", "utilizar","usa", "utilize","uses","utilizes","utilize"};

    public UseCommand(DialogueManager manager) {
        this.manager = manager;
    }
    public String[] names() {
        return COMMAND_NAMES;
    }

    public void execute(Player player, ArrayList<String> words) throws Exception {
        UsableItem item = null;

        //verifica se o item existe
        for (String o : words) {
            if (player.getInventory().getUsables().getItem(o) != null) {
                item = (UsableItem) player.getInventory().getUsables().getItem(o);
            }
        } if (item == null) {
            throw new Exception("Não existe nenhum item com esse nome no inventário.");
        } 

        for (Npc npc: player.getPresentRoom().getNpcs()) {
            if (npc.getName().toLowerCase().equals(item.getToBeUsed().toLowerCase())) {
                npc.itemGiven(player, item, manager);
                return;
            }
        } if (player.getPresentRoom().getName().equalsIgnoreCase(item.getToBeUsed())) {
            if (player.getPresentRoom() instanceof ItemUsedRoom) {
                System.out.println("O Sherlock usa o item " + item.getName() + " na sala " + player.getPresentRoom().getName() + ".");
                ((ItemUsedRoom) player.getPresentRoom()).useItem();
                return;
            }
        }
        throw new Exception("Não há onde usar este item.");

        
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
