/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import Dialogue.DialogueManager;
import Items_Inventario.ImmovabelItem;
import Rooms.Sala;
/**
 *
 * @author ajone
 */
public class Npc extends Character { 
    String QuestItem;

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
   //public String talk(){
    public void talk(){
        DialogueManager.startDialogue(this);
    }    
    //}
}