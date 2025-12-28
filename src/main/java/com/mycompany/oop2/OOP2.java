/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oop2;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import Characters.Player;
import Comandos.CluesCommand;
import Comandos.Command;
import Comandos.CommandRunner;
import Comandos.DialogueLoaderCommand;
import Comandos.ExitCommand;
import Comandos.GoCommand;
import Comandos.HelpCommand;
import Comandos.InspectCommand;
import Comandos.LookCommand;
import Comandos.TalkCommand;
import Comandos.UsableItemsCommand;
import Comandos.UseCommand;
import Dialogue.DialogueDistributor;
import Dialogue.DialogueLoader;
import Dialogue.DialogueManager;
import Endings.Ending;
import Endings.Ending1;
import Endings.Ending2;
import Endings.Ending3;
import Endings.Ending4;
import Items_Inventario.AddCommand;
import Items_Inventario.Inventory;
import Rooms.Map_game;

/**
 * 
 * @author Afonso, Lara, Tiago
 */
public class OOP2 {

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"UTF-8"));
            System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err),true,"UTF-8"));
        } catch (Exception e) {
            System.out.println("Erro no PrintStream: " + e.getMessage());
        }
        
        Map_game map = new Map_game();

        // Introdução do jogo (NÃO APAGAR)
        System.out.println("==== INTRODUÇÃO AO JOGO ====");
        System.out.println("Na luxuosa Mansão Blackwood decorre o baile anual.\r\n"
                + "O Lorde Alistair Blackwood foi encontrado morto no seu quarto.\r\n" +
                "A mansão ficou imediatamente trancada devido à tempestade e à névoa densa no exterior.\r\n"
                + "Sherlock está preso dentro da mansão com convidados e possíveis assassinos.\r\n" +
                "Cabe a si resolver o mistério e encontrar o assassino antes que ele ataque novamente.\r\n"
                + "Boa sorte, detetive!\r\n" + "");

        // Criação dos comandos
        AddCommand addCommand = new AddCommand();
        // Spawn do player
        Player player = new Player("Sherlock Holmes", new Inventory(),map.getSpawn());
        UserInputReader scanner = new UserInputReader();
        DialogueManager manager = new DialogueManager(scanner);
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new LookCommand());
        commands.add(new InspectCommand(addCommand));
        commands.add(new CluesCommand());
        commands.add(new UsableItemsCommand());
        commands.add(new ExitCommand());
        commands.add(new GoCommand());
        commands.add(new UseCommand(manager));
        commands.add(new HelpCommand(commands));
        commands.add(new TalkCommand(manager));

        CommandRunner commandRunner = new CommandRunner(commands);
        DialogueLoader loader = new DialogueLoader();
        DialogueDistributor distributor = new DialogueDistributor();
        commands.add(new DialogueLoaderCommand(map.getNpcs(), loader, distributor));

        ArrayList <Ending> endings = new ArrayList<>();
        endings.add(new Ending1());
        endings.add(new Ending2());
        endings.add(new Ending3());
        endings.add(new Ending4());
        // Ciclo infinito de jogo
        while (true) {
            for (Ending ending : endings) {
                if (ending.check(player)) {
                    ending.trigger();
                    break;
                }
            }
        player.itemHistoryCheck();
            System.out.print("Escreva um comando: ");
            String linha = scanner.readInputLine();
            commandRunner.runCommands(player, linha);
        }
        /*
         * if (player.getPresentRoom().getClass().toString().equals(balcony.getClass().
         * toString())) {
         * if (player.getInventory().containsItem("Tecido") &&
         * player.getInventory().containsItem("Faca")) {
         * System.out.println("A sair do jogo. Até à próxima!");
         * commandRunner.runCommands(player, "sair");
         * }
         * }
         * 
         */
    }
}
