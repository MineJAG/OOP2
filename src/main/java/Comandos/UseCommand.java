/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.*;
import Items_Inventario.*;
import Rooms.*;

import java.util.*;

/**
 *
 * @author Bibby
 */
public class UseCommand implements Command {
    public static final String[] COMMAND_NAMES = {"use", "usar", "utilizar","usa", "utilize","uses","utilizes","utilize"};

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
            if (npc.getName().equalsIgnoreCase(item.getToBeUsed())) {

                //!!cena dos npcs

                return;
            }
        } if (player.getPresentRoom().getName().equalsIgnoreCase(item.getToBeUsed())) {
            System.out.println("O Sherlock usa o item " + item.getName() + " na sala " + player.getPresentRoom().getName() + ".");
            if (player.getPresentRoom().getName().equalsIgnoreCase(item.getToBeUsed())) {
                if (player.getPresentRoom() instanceof Bar) {
                    ((Bar) player.getPresentRoom()).unlockNorth();
                }
                if (player.getPresentRoom() instanceof Storage) {
                    ((Storage) player.getPresentRoom()).lightUp();
                }
            }
            return;
        }
        throw new Exception("Não há onde usar este item.");

        
    }
}
