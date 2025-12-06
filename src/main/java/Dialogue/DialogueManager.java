/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;
import java.util.Map;
import Characters.Npc;
/**
 *
 * @author ajone
 */
public class DialogueManager {
    private DialogueLine currentLine;
    private Map<String, DialogueLine> currentNpcMap;
    public DialogueLine getCurrentLine() {
        return currentLine;
    }
    public void setCurrentLine(DialogueLine currentLine) {
        this.currentLine = currentLine;
    }
    public Map<String, DialogueLine> getCurrentNpcMap() {
        return currentNpcMap;
    }
    public void setCurrentNpcMap(Map<String, DialogueLine> currentNpcMap) {
        this.currentNpcMap = currentNpcMap;
    }

    public void Conversation(Npc npc){

    }

    public void changeLine(String line){
        setCurrentLine(getCurrentNpcMap().get(line));
    }
}
