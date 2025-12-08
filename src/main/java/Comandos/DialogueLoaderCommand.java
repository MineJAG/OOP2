/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Comandos.Commands;
import Dialogue.DialogueDistributor;
import Dialogue.DialogueLoader;
import Characters.*;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author ajone
 */
public class DialogueLoaderCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"load","carregar"};    
    private final List<Npc> npcs;
    private String filepath; 

    public DialogueLoaderCommand(List<Npc> npcs) {
        this.npcs = npcs;
    }

    public static String[] getCOMMAND_NAMES() {
        return COMMAND_NAMES;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    @Override
    public void execute(Player player){
        DialogueLoader loader = new DialogueLoader();
        try {
            loader.loadText(filepath);
            System.out.println("Dialogue loaded.");
        } catch (IOException e) {
            System.out.println("Error loading dialogue: " + e.getMessage());
        }
        DialogueDistributor distributor = new DialogueDistributor();
        distributor.setDialogue(loader.getDialogue());
        distributor.DistributeDialogue(npcs);
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(List<String> filepath) {
        this.filepath = filepath.get(1);
    }
    
}