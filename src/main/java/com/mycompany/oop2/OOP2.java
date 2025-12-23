/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oop2;
import Characters.*;
import Items_Inventario.*;
import Rooms.*;
import Dialogue.*;
import Comandos.*;
import java.util.*;

/**
 *
 * @author ajone
 */
public class OOP2 {

    public static void main(String[] args) {
        Map_game map = new Map_game();

        //teste do git apagar
        // Introdução do jogo (NÃO APAGAR)
        System.out.println("==== INTRODUÇÃO AO JOGO ====");
        System.out.println("Na luxuosa Mansão Blackwood decorre o baile anual.\r\n" + "O Lorde Alistair Blackwood foi encontrado morto no seu quarto.\r\n" +
                            "A mansão ficou imediatamente trancada devido à tempestade e à névoa densa no exterior.\r\n" + "Sherlock está preso dentro da mansão com convidados e possíveis assassinos.\r\n" + 
                            "Cabe a si resolver o mistério e encontrar o assassino antes que ele ataque novamente.\r\n" + "Boa sorte, detetive!\r\n" +"");        
        

        // Criação dos comandos
        AddCommand addCommand = new AddCommand();
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new LookCommand());
        commands.add(new InspectCommand(addCommand));
        commands.add(new CluesCommand());
        commands.add(new UsableItemsCommand());
        commands.add(new ExitCommand());
        commands.add(new GoCommand());
        commands.add(new UseCommand());
        commands.add(new HelpCommand(commands));
        commands.add(new TalkCommand());
        
        // Spawn do player
        Player player = new Player("Sherlock Holmes", map.getSpawn());
        
        // VER MELHOR
        player.getInventory().addItem(new Clues("1","1"));
        Item item = new Clues("bread","its bread what did u expect");
        Npc npc = new Npc(item,null,"Old_Man");
        DialogueLoader loader = new DialogueLoader();
        try {
            loader.loadText("dialogue.txt");
            System.out.println("Dialogue loaded.");
        } catch (Exception e) {
            System.out.println("Error loading dialogue: " + e.getMessage());
            System.out.println("Using default dialogue.");
        }
        DialogueDistributor distributor = new DialogueDistributor();
        List<Npc> npcs = new ArrayList<>();
        npcs.add(npc);
        UserInputReader scanner = new UserInputReader();
        CommandRunner commandRunner = new CommandRunner(npcs, commands);



        // Ciclo infinito de jogo
        while (true) {
            System.out.print("Escreva um comando: ");
            String linha = scanner.readInputLine();
            commandRunner.runCommands(player, linha);
        }
        /*
            if (player.getPresentRoom().getClass().toString().equals(balcony.getClass().toString())) {
                if (player.getInventory().containsItem("Tecido") && player.getInventory().containsItem("Faca")) {
                System.out.println("A sair do jogo. Até à próxima!");
                commandRunner.runCommands(player, "sair");
                }
            }

                */
    }
}
