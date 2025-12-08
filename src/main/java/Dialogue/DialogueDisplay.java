/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;

import java.util.List;
import Characters.Player;
/**
 *
 * @author ajone
 */
public class DialogueDisplay {
    
    public void showLine(DialogueLine line){
        if(line != null){
        System.out.println(line.getLine());
        }
    }

    public void showOptions(Player player, List<DialogueOption> options){
        for(int i = 0; i < options.size(); i++){
            switch (options.get(i).getNextLineId().charAt(0)) {
                case '!':
                    System.out.println((i) + ". " + options.get(i).getOption());
                    break;
                case '?':
                    System.out.println((i) + ". " + options.get(i).getOption());
                    break;
                default:
                    System.out.println((i) + ". " + options.get(i).getOption());
            }
        }
    }
}
