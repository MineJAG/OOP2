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

    public void changeLine(String lineId) {
        setCurrentLine(currentNpc.getDialogueLines().get(lineId));
    }

    public void startConversation(Npc npc, Player player) {
        setCurrentNpc(npc);

        // Your file example starts at "1-line1", not "0-line0"
        setCurrentLine(npc.getDialogueLines().get("1"));

        if (currentLine == null) {
            throw new IllegalStateException("No starting dialogue line with id '1' for NPC.");
        }

        conversation(player);
    }

    public void conversation(Player player) {
        DialogueDisplay display = new DialogueDisplay();
        display.showLine(getCurrentLine());

        // no options → end of conversation
        if (getCurrentLine().getOptions().isEmpty()) {
            return;
        }

        display.showOptions(player, getCurrentLine().getOptions());

        UserInputReader input = new UserInputReader();
        int userInput = input.readInt();

        // validate input
        if (userInput < 1 || userInput > currentLine.getOptions().size()) {
            System.out.println("Invalid option, try again.");
            conversation(player);  // retry same line
            return;
        }

        DialogueOption chosen = currentLine.getOptions().get(userInput - 1);
        String nextId = chosen.getNextLineId();

        // Try to get the next dialogue line
        DialogueLine nextLine = currentNpc.getDialogueLines().get(nextId);

        if (nextLine != null) {
            // Normal branch to another line
            setCurrentLine(nextLine);
            conversation(player);
            return;
        }

        // If there is no dialogue line with that ID, treat it as "give quest item and finish"
        // This matches your original intention with:
        // if(currentNpc.getDialogueLines().get(...nextLineId...) == null) { addItem(...) }
        player.getInventory().addItem(currentNpc.getQuestItem());
        System.out.println("You received an item from " + currentNpc.getName() + "!");
        // conversation ends here
    }

    public void itemGiven(Player player, Npc npc, Item item) {
        player.getInventory().removeItem(item);
        currentNpc = npc;
        currentLine = npc.getDialogueLines().get("?");  // special line after giving item
        conversation(player);
    }
}
