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
public class UseCommand implements Commands{
    public static final String[] COMMAND_NAMES = {"use", "usar", "utilizar","usa", "utilize","uses","utilizes","utilize"};
    UsableItem item;

    public void hasObject(Player player, List<String> object) throws Exception {
        item = null;
        for (String o : object) {
            if (player.getInventory().getUsables().getItem(o) != null) {
                item = (UsableItem) player.getInventory().getUsables().getItem(o);
            }
        }

        if (item == null) {
            throw new Exception("Não existe nenhum item com esse nome no inventário.");
        } 

        for (Npc npc: player.getPresentRoom().getNpcs()) {
            if (npc.getName().equalsIgnoreCase(item.getToBeUsed())) {
                return;
            }
        }
        if (!(player.getPresentRoom().getName().equalsIgnoreCase(item.getToBeUsed()))) {
            throw new Exception("Nao posso usar esse item aqui.");
        }
    }


    public void execute(Player player) {
        System.out.println("O Sherlock usa o item: " + item.getName() + ".");
        if (player.getPresentRoom().getName().equalsIgnoreCase(item.getToBeUsed())) {
            if (player.getPresentRoom() instanceof Bar) {
                ((Bar) player.getPresentRoom()).unlockNorth();
            }
            if (player.getPresentRoom() instanceof Storage) {
                ((Storage) player.getPresentRoom()).lightUp();
            }
        }
    }
}
