/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import java.util.HashMap;
import java.util.Map;

import Dialogue.DialogueLine;
import Dialogue.DialogueManager;
import Items_Inventario.Inventory;
import Items_Inventario.Item;
import Rooms.Sala;
/**
 * Classe que representa um NPC no jogo tem como responsabilidade guardar informacoes sobre o NPC.
 * @author Afonso
 */

public class Npc extends Character{ 
    private Map<String, DialogueLine> dialogueLines;

    public Npc(String name) {
        super(name,null,null);
    }
    public void talk(Player player,DialogueManager manager) throws Exception{
    if (this.dialogueLines == null || this.dialogueLines.isEmpty()) {
        throw new Exception("please load the dialogue");
    }
        manager.startConversation(this,player);
    }

    public Map<String, DialogueLine> getDialogueLines() {
        if (dialogueLines == null) {
            return new HashMap<>();
        }
        return new HashMap<>(dialogueLines);
    }

    public void setDialogueLines(Map<String, DialogueLine> dialogueLines) {
        this.dialogueLines = (HashMap<String, DialogueLine>) dialogueLines;
    }

    public Npc(Inventory inventory, String name, Sala presentRoom){
        super(name,inventory,presentRoom);
        this.dialogueLines = null;
    }
    public Npc(String name,Inventory inventory,Map<String, DialogueLine> dialogueLines,Sala presentRoom){
        super(name,inventory,presentRoom);
        this.dialogueLines = (HashMap<String, DialogueLine>)dialogueLines;
    }

    public void itemGiven(Player player,Item item,DialogueManager manager) throws Exception{
        if (dialogueLines.containsKey("?"+ item.getName().toLowerCase()))
            manager.itemGiven(player,this,item);
    }
}