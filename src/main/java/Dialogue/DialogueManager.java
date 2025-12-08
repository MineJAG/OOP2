/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;

import Characters.Npc;
import com.mycompany.oop2.UserInputReader;
import Items_Inventario.Item;
import Characters.Player;
/**
 *
 * @author ajone
 */
public class DialogueManager {
    private DialogueLine currentLine;
    private Npc currentNpc;
    public DialogueLine getCurrentLine() {
        return currentLine;
    }
    public void setCurrentLine(DialogueLine currentLine) {
        this.currentLine = currentLine;
    }

        public Npc getCurrentNpc() {
        return currentNpc;
    }
    public void setCurrentNpc(Npc currentNpc) {
        this.currentNpc = currentNpc;
    }

    public void changeLine(String line){
        setCurrentLine(currentNpc.getDialogueLines().get(line));
    }

    public void startConversation (Npc npc,Player player){
        setCurrentNpc(npc);
        setCurrentLine(npc.getDialogueLines().get("0"));
        conversation(player);
    }

    public void conversation(Player player){
        DialogueDisplay display = new DialogueDisplay();
        display.showLine(getCurrentLine());
        if (!getCurrentLine().getOptions().isEmpty()){
        display.showOptions(player ,getCurrentLine().getOptions());
        UserInputReader input = new UserInputReader();
        int userInput = input.readInt();
        if(currentLine.getOptions().size() >= userInput){
            if (player.getInventory().containsItem(currentLine.getOptions().get(userInput - 1).getNextLineId().substring(1))){
            setCurrentLine(currentNpc.getDialogueLines().get(currentLine.getOptions().get((userInput - 1)).getNextLineId()));
            conversation(player);
            }
            System.out.println("Invalid option try again");
            conversation(player);
            }
            if(currentNpc.getDialogueLines().get(currentLine.getOptions().get(userInput - 1).getNextLineId()) == null){
                player.getInventory().addItem(currentNpc.getQuestItem());
            }
        }
    }

    public void itemGiven(Player player,Npc npc,Item item){
        player.getInventory().removeItem(item);
        currentLine = npc.getDialogueLines().get("?");
        currentNpc = npc;
        conversation(player);
    }
}
