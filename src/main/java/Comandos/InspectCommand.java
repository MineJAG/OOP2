/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Items_Inventario.Inventory;
import Characters.Player;
import Rooms.Sala;
import java.lang.String;
import java.util.*;
/**
 *
 * @author ajone
 */
public class InspectCommand implements Comands {
    public static final String[] COMMAND_NAMES = {"inspect", "inspeciona", "inspecionar","investigar", "investiga", "search", "investigate", "procurar", "procura", "procure", "analisar", "analyse", "analisa", "analise", "examinar", "examine", "examina", "examine"};
    private List<String> phrase = new ArrayList<>();

    public InspectCommand() {
    }

    public boolean verifyCommand(String userInput) {
        String x = "";
        for (int i = 0; i < userInput.length(); i++) {
            x+=userInput.charAt(i);
            if (x.equals(" ")|| x.equals(".")|| x.equals(",")|| x.equals("!")|| x.equals("?")) {
                phrase.add(x);
                x = "";
            }
        }

        if (x!="") {phrase.add(x);}

        for (String word : phrase) {
            for (String commandName : COMMAND_NAMES) {
                if (commandName.equals(word)) {
                    return true;
                }
            }
        }

        phrase.clear();
        return false;
    }

    //acabar
    public void execute(Player player, String userInput) {
        if (!verifyCommand(userInput)) {
            return;
        }
        Sala room = player.getPresentRoom();
        Inventory inventory = room.getInventory();
        for (String word : phrase) {
            for (int i = 0; i < inventory.getSize(); i++) {
                
            }
        }
        System.out.println(room.getDescription());
        System.out.println(inventory.toString());
    }
}
