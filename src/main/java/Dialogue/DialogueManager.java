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
        DialogueDisplay display = new DialogueDisplay();
        display.showLine(getCurrentLine());
        if (!getCurrentLine().getOptions().isEmpty()){
        display.showOptions(player ,getCurrentLine().getOptions());
        int userInput = inputReader.readInt();
        inputReader.readInputLine();
        if(getCurrentLine().getOptions().size() >= userInput && userInput > 0){
            if (getCurrentLine().getOptions().get(userInput - 1).getNextLineId().charAt(0) == '!'){
                if (player.getInventory().containsItem(getCurrentLine().getOptions().get(userInput - 1).getNextLineId().substring(1).toLowerCase())){
                setCurrentLine(currentNpc.getDialogueLines().get(getCurrentLine().getOptions().get((userInput - 1)).getNextLineId()));
                conversation(player);
            }
        } else if (currentLine.getOptions().get(userInput - 1).getNextLineId().charAt(0) == '%'){
            player.getInventory().addItem(currentNpc.getInventory().getItem(currentLine.getOptions().get(userInput - 1).getNextLineId().substring(1)));
            System.out.println("O item " + currentNpc.getInventory().getItem(currentLine.getOptions().get(userInput - 1).getNextLineId().substring(1)).getName() + " foi adicionado ao inventário.");
            setCurrentLine(currentNpc.getDialogueLines().get(currentLine.getOptions().get((userInput - 1)).getNextLineId()));
            conversation(player);
        }else {
            setCurrentLine(currentNpc.getDialogueLines().get(currentLine.getOptions().get(userInput - 1).getNextLineId()));
            conversation(player);
        }
        } else {
            System.out.println("Invalid option try again");
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
