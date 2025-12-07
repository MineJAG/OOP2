package Dialogue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.Map;
import java.util.ArrayList;

import Characters.Npc;
/**
 *
 * @author ajone
 */
public class DialogueLoader {
        private Map<String, Map <String, DialogueLine>> StoredDialogue;

    public Map<String, Map<String, DialogueLine>> getDialogue() {
            return StoredDialogue;
        }
        public void setDialogue(Map<String, Map<String, DialogueLine>> dialogue) {
            this.StoredDialogue = dialogue;
        }
    public void loadText(String fileName) throws IOException {
        FileReader fR = new FileReader(fileName);
        BufferedReader bR = new BufferedReader(fR);
        String line;
        Map<String, Map <String, DialogueLine>> dialogue = new java.util.HashMap<>();
        String currentNpc = null;
        while ((line = bR.readLine()) != null) {
            if(line.charAt(0) == '#'){
                continue;
            }
            String[] part = splitLine(line, '-');
            if(part[0].toLowerCase().equals("c")){
                currentNpc = part[1];
                dialogue.put(currentNpc, new java.util.HashMap<>());
            }
            if (hasChar(part[0].toLowerCase(),'o')){
                String[] subPart = splitLine(part[0], 'o');
                String DialogueId = subPart[0];
                String OptionId = subPart[1];
                String optionText = part[1];
                dialogue.get(currentNpc).get(DialogueId).addOption(new DialogueOption(optionText, OptionId));
            }
            else{
                String DialogueId = part[0];
                String dialogueText = part[1];
                dialogue.get(currentNpc).put(DialogueId, new DialogueLine(dialogueText));
            }
    }
        setDialogue(dialogue);
        bR.close();
    }
    public String[] splitLine(String line, char r){
        int i = line.indexOf(r);
        String[] parts = new String[2];
        parts[0] = line.substring(0, i);
        parts[1] = line.substring(i + 1);
        return parts;
    }

    public boolean hasChar(String line, char r){
        return line.contains("r");
    }

    public void main (String[] args) throws IOException {
        DialogueLoader loader = new DialogueLoader();
        loader.loadText("dialogue.txt");
        Npc npc = new Npc("Old Man");
        ArrayList<Npc> npcs = new ArrayList<>();
        npcs.add(npc);
        DialogueDistributor distributor = new DialogueDistributor();
        distributor.setDialogue(loader.getDialogue());
        distributor.DistributeDialogue(npcs);
        System.out.println(npc.getDialogueLines());
    }
}