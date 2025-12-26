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
import Rooms.Room;
/**
 * Classe que representa um NPC no jogo tem como responsabilidade guardar informacoes sobre o NPC.
 * @author ajone
 */

public class Npc extends Character{ 
    private Inventory inventory;
    private Map<String, DialogueLine> dialogueLines;

    public Npc(String name) {
        super(name,null);
        inventory = null;
    }
    public void talk(Player player,DialogueManager manager) throws Exception{
        manager.startConversation(this,player);
    }

    public Map<String, DialogueLine> getDialogueLines() {
        return new HashMap<>(dialogueLines);
    }

    public void setDialogueLines(Map<String, DialogueLine> dialogueLines) {
        this.dialogueLines = (HashMap<String, DialogueLine>) dialogueLines;
    }

    public Npc(Inventory inventory, String name, Room presentRoom){
        super(name,presentRoom);
        this.dialogueLines = null;
        this.inventory = inventory;
    }
    public Npc(String name,Inventory inventory,Map<String, DialogueLine> dialogueLines,Room presentRoom){
        super(name,presentRoom);
        this.inventory = inventory;
        this.dialogueLines = (HashMap<String, DialogueLine>)dialogueLines;
    }

    public void itemGiven(Player player,Item item,DialogueManager manager) throws Exception{
        if (dialogueLines.containsKey("?"+ item.getName()))
            manager.itemGiven(player,this,item);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}