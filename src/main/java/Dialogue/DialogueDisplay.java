/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;

import java.util.List;

/**
 *
 * @author ajone
 */
public class DialogueDisplay {
    
    public void showLine(DialogueLine line){
        System.out.println(line.getLine());
    }

    public void showOptions(List<DialogueOption> options){
        for(int i = 0; i < options.size(); i++){
            System.out.println((i + 1) + ". " + options.get(i).getOption());
        }
    }
}
