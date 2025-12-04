/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Items_Inventario.Inventory;
import Items_Inventario.Item;
import Characters.Npc;
import Characters.Player;
import Rooms.Sala;
import java.lang.String;
import java.util.*;
/**
 *
 * @author ajone
 */
public class InspectCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"inspect", "inspeciona", "inspecionar","investigar", "investiga", "search", "investigate", "procurar", "procura", "procure", "analisar", "analyse", "analisa", "analise", "examinar", "examine", "examina", "examine"};
    private List<String> object;

    public List<String> getObject() {
        return object;
    }

    public void setObject(List<String> object) {
        this.object = object;
    }

    public void execute(Player player) {
        Sala room = player.getPresentRoom();
        Inventory pInventory = player.getInventory();
        Inventory rInventory = room.getInventory();
        String description = null;

        for (String o : object) {
            if (pInventory.getItem(o) != null) {
                description = pInventory.getItem(o).getDescription();
            } else if (rInventory.getItem(o) != null) {
                description = rInventory.getItem(o).getDescription();
            } else if (room.getName().equals(o)) {
                description = room.getDescription();
            }
        }
        
        if (description == null) {
            System.out.println("Tem de usar um objeto válido. Tente escrever: comando objeto.");
            return;
        }

        System.out.println("O Sherlock inspeciona o objeto: " + object + ".");
        System.out.println(description);
        object = null;
    }
}