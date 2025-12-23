/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Characters.Npc;
/**
 *
 * @author ajone
 */
public class DialogueDistributor {
    private Map<String, Map <String, DialogueLine>> dialogue;

    public Map<String, Map<String, DialogueLine>> getDialogue() {
        Map<String, Map<String, DialogueLine>> dial = new HashMap<>(dialogue);
        return dial;
    }

    public void setDialogue(Map<String, Map<String, DialogueLine>> dialogue) {
        this.dialogue = dialogue;
    }
    
    public void DistributeDialogue(List<Npc> npcs) throws  IllegalStateException{
        if(this.dialogue == null) {
            throw new IllegalStateException("No dialogue loaded");
        }
        else {
        for(Npc npc : npcs){
            npc.setDialogueLines(this.dialogue.get(npc.getName()));
            }
        }
    }
}
