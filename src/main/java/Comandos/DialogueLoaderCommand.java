/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Dialogue.DialogueDistributor;
import Dialogue.DialogueLoader;
import Characters.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author ajone
 */
public class DialogueLoaderCommand implements Command{
    private String name = "Dialogue command - Loads dialogue with the syntax load Filename (the .txt is silently added)";
    public static final String[] COMMAND_NAMES = {"load","carregar"};    
    private final List<Npc> npcs;
    private String filepath; 

    public DialogueLoaderCommand(List<Npc> npcs) {
        this.npcs = npcs;
    }

    public String[] names() {
        return COMMAND_NAMES;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    public void execute(Player player, ArrayList<String> words) throws Exception {
        DialogueLoader loader = new DialogueLoader();
        setFilepath(words);
        String filepath = getFilepath();
        try {
            loader.loadText(filepath + ".txt");
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

    public void setFilepath(ArrayList<String> filepath) {
        this.filepath = filepath.get(1);
    }
    
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t-";
        for(int i = 0; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}