/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;

import com.mycompany.oop2.UserInputReader;

import Characters.Npc;
import Characters.Player;
import Items_Inventario.Item;
/**
 * Classe que representa o gestor de dialogos no jogo tem como responsabilidade gerir o fluxo de dialogos entre o jogador e os NPCs.
 * @author Afonso
 */
public class DialogueManager{
    private DialogueLine currentLine;
    private Npc currentNpc;
    private UserInputReader inputReader;
    private DialogueDisplay display = new DialogueDisplay();


    public DialogueManager(UserInputReader inputReader) {
        this.inputReader = inputReader;
    }
    
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
        setCurrentLine(npc.getDialogueLines().get("1"));
        conversation(player);
    }

    public void conversation(Player player){
public void conversation(Player player){
    display.showLine(getCurrentLine());
    
    if (!getCurrentLine().getOptions().isEmpty()){
        display.showOptions(player, getCurrentLine().getOptions());
        
        // Fix 1: Handle non-integer input properly
        int userInput;
        try {
            userInput = inputReader.readInt();
            inputReader.readLine(); // Clear the buffer to prevent extra line reading
        } catch (Exception e) {
            inputReader.readLine(); // Clear the invalid input
            System.out.println("Invalid option, please enter a number.");
            conversation(player);
            return;
        }
        // Fix 2: Check if input is within valid range
        if (userInput > 0 && userInput <= getCurrentLine().getOptions().size()){
            String nextLineId = getCurrentLine().getOptions().get(userInput - 1).getNextLineId();
            // Handle special dialogue options
            if (nextLineId.charAt(0) == '!'){
                // Check if player has required item
                String requiredItem = nextLineId.substring(1).toLowerCase();
                if (player.getInventory().containsItem(requiredItem)){
                    setCurrentLine(currentNpc.getDialogueLines().get(nextLineId));
                    conversation(player);
                } else {
                    // Fix 3: Handle case when player doesn't have item
                    System.out.println("You don't have the required item.");
                    conversation(player);
                }
            } else if (nextLineId.charAt(0) == '%'){
                // Give item to player
                String itemId = nextLineId.substring(1);
                player.getInventory().addItem(currentNpc.getInventory().getItem(itemId));
                System.out.println("O item " + currentNpc.getInventory().getItem(itemId).getName() + " foi adicionado ao inventário.");
                setCurrentLine(currentNpc.getDialogueLines().get(nextLineId));
                conversation(player);
            } else {
                // Normal dialogue progression
                setCurrentLine(currentNpc.getDialogueLines().get(nextLineId));
                conversation(player);
            }
        } else {
            System.out.println("Invalid option, try again.");
            conversation(player);
        }
    }
}

    public void itemGiven(Player player,Npc npc,Item item) throws Exception{
        player.getInventory().removeItem(item);
        if(npc.getDialogueLines().containsKey("?" + item.getName().toLowerCase())){
        currentLine = npc.getDialogueLines().get("?" + item.getName().toLowerCase());
        currentNpc = npc;
        conversation(player);
        } else {
            throw new Exception("Linhe refering to" + item.getName() + " not found");
        }
    }
}
