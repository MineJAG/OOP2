/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Items_Inventario.*;
import Characters.*;
import Rooms.*;
import java.lang.String;
import java.util.*;
/**
 *
 * @author ajone
 */
public class InspectCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"inspect", "inspeciona", "inspecionar","investigar", "investiga", "search", "investigate", "procurar", "procura", "procure", "analisar", "analyse", "analisa", "analise", "examinar", "examine", "examina", "examine"};
    private AddCommand addCommand = new AddCommand();
    private Item item;

    public boolean hasObject(Player player, List<String> object) {
        Sala room = player.getPresentRoom();
        Inventory pInventory = player.getInventory();
        Inventory rInventory = room.getInventory();
        for (String o : object) {
            if (pInventory.getItem(o) != null) {
                item = pInventory.getItem(o);
                return true;
            } else if (rInventory.getItem(o) != null) {
                item = rInventory.getItem(o);
                return true;
            }
        }
        return false;
    }

    public void execute(Player player) {        
        System.out.println("O Sherlock inspeciona o objeto: " + item.getName() + ".");
        System.out.println(item.getDescription());
        addCommand.execute(player, item);
        item = null;
    }
}