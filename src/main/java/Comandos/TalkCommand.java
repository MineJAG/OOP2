/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Characters.Npc;
import Characters.Player;
import java.util.List;
import Dialogue.DialogueManager;
/**
 *
 * @author ajone
 */
public class TalkCommand{

    public static String[] getCOMMAND_NAMES() {
        return COMMAND_NAMES;
    }
    DialogueManager manager = new DialogueManager();
    Npc npc;
    public static final String[] COMMAND_NAMES = {"falar","conversar","talk","fala","conversa","comunicar","comunica","dialogar","dialoga","speak","say","chat","comunicate"};

    public void execute(Player player) {
        npc.talk(player, manager);
    }
    public void talkToNpc(List<Npc> npcs, List<String> words, Player player, DialogueManager manager) throws Exception {
        for (int i = 0; i < npcs.size(); i++) {
            for (int o = 0; o < words.size(); o++) {
                if (npcs.get(i).getName().equals(words.get(o))) {
                    if (npcs.get(i).getPresentRoom() == player.getPresentRoom()) {
                        this.setNpc(npcs.get(i));
                        this.setManager(manager);
                        return;
                    } else {
                        throw new Exception("Npc not in this room");
                    }
                }
            }
        }
        throw new Exception("Npc nao encontrado");
    }

    public Npc getNpc() {
        return npc;
    }
    public void setNpc(Npc npc) {
        this.npc = npc;
    }
    public DialogueManager getManager() {
        return manager;
    }
    public void setManager(DialogueManager manager) {
        this.manager = manager;
    }
}
