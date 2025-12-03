/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.*;

/**
 *
 * @author Bibby
 */
public class CommandRunner {
    List<String> words = new ArrayList<>();
    TalkCommand talkCommand = new TalkCommand();
    InspectCommand inspectCommand = new InspectCommand();
    ExitCommand exitCommand = new ExitCommand();
    HelpCommand helpCommand = new HelpCommand();
    DialogueLoaderCommand dialogueLoaderCommand = new DialogueLoaderCommand();
    


    private void separate(String userInput) {
        String x = "";
        for (int i = 0; i < userInput.length(); i++) {
            x+=userInput.charAt(i);
            if (x.equals(" ")|| x.equals(".")|| x.equals(",")|| x.equals("!")|| x.equals("?")) {
                if (x.length() <= 2) {
                    x = "";
                } else {
                    words.add(x);
                    x = "";
                }
            }
        }
    }

    private void verifyCommand(String[] commandNames) {

    }
}
