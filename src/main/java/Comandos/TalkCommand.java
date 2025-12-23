/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Characters.Npc;
import Characters.Player;
import java.util.List;
import Dialogue.DialogueManager;
import java.util.ArrayList;
/**
 *
 * @author ajone
 */
public class TalkCommand implements Command{
    private String name = "Talk command - talk to an Npc syntax talk then the name of the npc";
    public static String[] getCOMMAND_NAMES() {
        return COMMAND_NAMES;
    }

    public static final String[] COMMAND_NAMES = {"falar","conversar","talk","fala","conversa","comunicar","comunica","dialogar","dialoga","speak","say","chat","comunicate"};

    public void execute(Player player, ArrayList<String> words) throws Exception {
        talkToNpc(player.getPresentRoom().getNpcs(), words, player);
    }
    public void talkToNpc(List<Npc> npcs, List<String> words, Player player) throws Exception {
        for (int i = 0; i < npcs.size(); i++) {
            for (int o = 0; o < words.size(); o++) {
                if (npcs.get(i).getName().equals(words.get(o))) {
                    if (npcs.get(i).getPresentRoom() == player.getPresentRoom()) {
                        npcs.get(i).talk(player);
                    } else {
                        throw new Exception("Npc not in this room");
                    }
                }
            }
        }
        throw new Exception("Npc nao encontrado");
    }
    public String getName() {
        return name;
    }
    public String[] names(){
        return COMMAND_NAMES;
    }
    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t";
        result += COMMAND_NAMES[0];
        for(int i = 1; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}
