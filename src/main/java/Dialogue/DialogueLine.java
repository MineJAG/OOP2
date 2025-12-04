package Dialogue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ajone
 */
public class DialogueLine {
    private final String line;
    private final DialogueOptions options;
    
    public DialogueLine(String line, DialogueOptions options){
        this.line = line;
        this.options = options;
    }
    
    public DialogueOptions getOptions(){
        return options;
    }

    public String getLine(){
        return line;
    }
}
