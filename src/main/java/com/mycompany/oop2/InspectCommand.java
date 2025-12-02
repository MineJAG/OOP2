/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

/**
 *
 * @author ajone
 */
public class InspectCommand {
    public static final String[] COMMAND_NAMES = {"inspect", "inspeciona", "inspecionar","investigar", "investiga", "search", "investigate", "procurar", "procura", "procure", "analisar", "analyse", "analisa", "analise", "examinar", "examine", "examina", "examine"};

    public InspectCommand() {
    }

    public boolean verifyName(String name) {
        for (String commandName : COMMAND_NAMES) {
            if (commandName.equals(name)) {
                return true;
            }
        }                                                   
        return false;
    }

    //por acabar
    public void nameToInspect() {
        System.out.println("Qual o nome do item que deseja inspecionar?");
        
    }
    public void execute(Player player) {
        Sala room = player.getPresentRoom();
        Inventory inventory = room.getInventory();
        
        System.out.println(room.getDescription());
        System.out.println(inventory.toString());
    }
}
