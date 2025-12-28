/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.*;
import Characters.*;

/**
 * Corre os comandos.
 * @author Lara
 */
public class CommandRunner {
    ArrayList<Command> commands;


    
    public CommandRunner(ArrayList<Command> commands) {
        this.commands = commands;
        //this.dialogueLoaderCommand = new DialogueLoaderCommand(npcs);
    }

    private ArrayList<String> separate(String userInput) {
        String x = "";
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
                if (!x.isEmpty()) {
                    words.add(x);
                    x = "";
                }
            } else {
                x += c;
            }
        }
        if (!x.isEmpty()) {
            words.add(x);
        }
        return words;
    }

    public void runCommands(Player player, String userInput) {
        ArrayList<String> words = separate(userInput);

        try {
            if (words.isEmpty()) {
                throw new Exception("Tem de escrever um comando.");
            }
            for (Command c : commands) {
                if (c.matches(words)) {
                    c.execute(player, words);
                    return;
                }
            }
            throw new Exception("Comando desconhecido.");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        words.clear();
    }
}
