/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Dialogue.DialogueLine;
import Dialogue.DialogueManager;
import Items_Inventario.Item;
import Rooms.Room;
/**
 * Classe que representa um NPC no jogo tem como responsabilidade guardar informacoes sobre o NPC.
 * @author ajone
 */

public class Npc extends Character{ 
    private HashMap<String, Item> items;
    private HashMap<String, DialogueLine> dialogueLines;

    public Npc(String name) {
        super(name,null);
        items = null;
    }
    public void talk(Player player,DialogueManager manager) throws Exception{
        manager.startConversation(this,player);
    }

    public Map<String, DialogueLine> getDialogueLines() {
        return dialogueLines;
    }

    public void setDialogueLines(Map<String, DialogueLine> dialogueLines) {
        this.dialogueLines = (HashMap<String, DialogueLine>) dialogueLines;
    }

    public void setItems(Map<String, Item> items) {
        this.items = (HashMap<String, Item>)items;
    }

    public Map<String, Item> getItems() {
        return new HashMap<>(items);
    }

    public Npc(ArrayList<Item> items, Map<String, DialogueLine> dialogueLines, String name, Room presentRoom){
        super(name,presentRoom);
        this.dialogueLines = (HashMap<String, DialogueLine>)dialogueLines;
        for(Item item : items){
            this.items.put(item.getName(), item);
        }
    }
    public Npc(String name,HashMap<String, Item> items,HashMap<String, DialogueLine> dialogueLines,Room presentRoom){
        super(name,presentRoom);
        this.items = items;
        this.dialogueLines = dialogueLines;
    }

    public void itemGiven(Player player,Item item,DialogueManager manager) throws Exception{
        if (dialogueLines.containsKey("?"+ item.getName()))
            manager.itemGiven(player,this,item);
    }
}