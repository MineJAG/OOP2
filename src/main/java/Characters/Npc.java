/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import java.util.Map;
import Rooms.Sala;
import Dialogue.DialogueLine;
import Dialogue.DialogueManager;
import Items_Inventario.*;
/**
 *
 * @author ajone
 */

public class Npc extends Character { 
    private Item QuestItem;
    private static DialogueManager manager = new DialogueManager();
    private Map<String, DialogueLine> dialogueLines;

    public Npc(String name) {
        super(name,null);
        QuestItem = null;
    }

    public Npc(String name, Sala salaN){
        super(name, salaN);
        QuestItem = null;
    }

    public Npc(String name, Sala salaN, Item questItem, String[] neededClues) {
        super(name, salaN);
        this.QuestItem = questItem;
    }

    public Item getQuestItem() {
        return QuestItem;
    }

    public void setQuestItem(Item questItem) {
        QuestItem = questItem;
    }
    public void talk(Player player, DialogueManager manager){
        Npc.manager.startConversation(this,player);
    }

    public Map<String, DialogueLine> getDialogueLines() {
        return dialogueLines;
    }

    public void setDialogueLines(Map<String, DialogueLine> dialogueLines) {
        this.dialogueLines = dialogueLines;
    }

    public Npc(Item QuestItem, Map<String, DialogueLine> dialogueLines, String name) {
        super(name,null);
        this.QuestItem = QuestItem;
        this.dialogueLines = dialogueLines;
    }
    public void itemGiven(Player player){
        if (dialogueLines.containsKey("?"))
            Npc.manager.itemGiven(player,this,QuestItem);
    }
}