/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import java.util.ArrayList;

/**
 *
 * @author ajone
 */
public class DialogueManager {
    private ArrayList<ArrayList<DialogueLine>> Dialogue = new ArrayList<>();
    private DialogueLine currentLine = new DialogueLine("Dialogo Não Carregado", null);
    private Npc currentNpc = null;

    public ArrayList<ArrayList<DialogueLine>> getDialogue() {
        return Dialogue;
    }

    public void setDialogue(ArrayList<ArrayList<DialogueLine>> Dialogue) {
        this.Dialogue = Dialogue;
    }

    public void addDialogue(ArrayList<DialogueLine> dialogueLines){
        this.Dialogue.add(dialogueLines);
    }
    
    public void removeDialogue(int index){
        this.Dialogue.remove(index);
    }

    public void giveDialogue(ArrayList<Npc> npcs){
        for(int i = 0; i < npcs.size(); i++){
            if (npcs.get(i).getName().equals(Dialogue.get(i).get(0).getLine())){
                npcs.get(i).setDialogs(Dialogue.get(i));
            }
            i++;
        }
    }
    

    public DialogueLine getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(DialogueLine currentLine) {
        this.currentLine = currentLine;
    }
    
    public void startDialogue(Npc npc){
        currentNpc = npc;
        System.out.println(npc.getName() + " : " + currentLine.getLine());
        currentLine.getOptions().selectOption(this);
    }

    public Npc getCurrentNpc() {
        return currentNpc;
    }
}
