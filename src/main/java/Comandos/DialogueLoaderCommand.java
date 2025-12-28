/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Characters.Npc;
import Characters.Player;
import Dialogue.DialogueDistributor;
import Dialogue.DialogueLoader;
/**
 * Classe que representa o comando de carregar dialogos no jogo tem como responsabilidade carregar dialogos de um txt a partir de um caminho dado pelo player.
 * @author Afonso
 */
public class DialogueLoaderCommand implements Command{
    private String name = "Dialogue command - Loads dialogue with the syntax load Filename (the .txt is silently added)";
    public static final String[] COMMAND_NAMES = {"load","carregar"};    
    private final List<Npc> npcs;
    private String fileName; 
    private final DialogueLoader loader;
    private final DialogueDistributor distributor;

    public DialogueLoaderCommand(List<Npc> npcs, DialogueLoader loader, DialogueDistributor distributor) {
        this.npcs = npcs;
        this.loader = loader;
        this.distributor = distributor;
    }
    @Override
    public String[] names() {
        return COMMAND_NAMES;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }
    @Override
    public void execute(Player player, ArrayList<String> words) throws Exception {
        setFileName(words);
        try {
            loader.loadText(getFileName() + ".txt");
            System.out.println("Dialogue loaded.");
        } catch (IOException e) {
            System.out.println("Error loading dialogue: " + e.getMessage());
        }
        distributor.setDialogue(loader.getDialogue());
        distributor.DistributeDialogue(npcs);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(ArrayList<String> fileName) {
        this.fileName = fileName.get(1);
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t-";
        result += COMMAND_NAMES[0];
        for(int i = 1; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}