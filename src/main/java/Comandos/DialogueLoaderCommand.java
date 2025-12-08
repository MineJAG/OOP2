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

    public DialogueLoaderCommand(List<Npc> npcs) {
        this.npcs = npcs;
    }
}