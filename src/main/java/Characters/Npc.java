/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import java.util.Map;
import Rooms.Sala;
import Dialogue.DialogueLine;
/**
 *
 * @author ajone
 */
public class Npc extends Character { 
    private String QuestItem;
    private Map<String, DialogueLine> dialogueLines;

    public Npc(String name, Sala salaN){
        super(name, salaN);
        QuestItem = null;
    }

    public Npc(String name, Sala salaN, String questItem) {
        super(name, salaN);
        this.QuestItem = questItem;
    }

    public String getQuestItem() {
        return QuestItem;
    }

    public void setQuestItem(String questItem) {
        QuestItem = questItem;
    }
    /*//public String talk(){
    public void talk(){
        DialogueManager.Conversation(this);
    }   
    //}*/

    public Map<String, DialogueLine> getDialogueLines() {
        return dialogueLines;
    }

    public void setDialogueLines(Map<String, DialogueLine> dialogueLines) {
        this.dialogueLines = dialogueLines;
    }
    
}