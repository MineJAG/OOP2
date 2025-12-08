/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.Player;
import Dialogue.DialogueLoader;
import jdk.jshell.Diag;

/**
 *
 * @author ajone
 */
public class HelpCommand implements Commands {
    CluesCommand cluesCommand;
    DialogueLoaderCommand dialogueLoaderCommand;
    ExitCommand exitCommand;
    GoCommand goCommand;
    InspectCommand inspectCommand;
    LookCommand lookCommand;
    TalkCommand talkCommand;
    UsableItemsCommand usableItemsCommand;
    UseCommand useCommand;
    public static final String[] COMMAND_NAMES = {"help","ajuda"}; 

    public CluesCommand getCluesCommand() {
        return cluesCommand;
    }

    public void setCluesCommand(CluesCommand cluesCommand) {
        this.cluesCommand = cluesCommand;
    }

    public DialogueLoaderCommand getDialogueLoaderCommand() {
        return dialogueLoaderCommand;
    }

    public void setDialogueLoaderCommand(DialogueLoaderCommand dialogueLoaderCommand) {
        this.dialogueLoaderCommand = dialogueLoaderCommand;
    }

    public ExitCommand getExitCommand() {
        return exitCommand;
    }

    public void setExitCommand(ExitCommand exitCommand) {
        this.exitCommand = exitCommand;
    }

    public GoCommand getGoCommand() {
        return goCommand;
    }

    public void setGoCommand(GoCommand goCommand) {
        this.goCommand = goCommand;
    }

    public InspectCommand getInspectCommand() {
        return inspectCommand;
    }

    public void setInspectCommand(InspectCommand inspectCommand) {
        this.inspectCommand = inspectCommand;
    }

    public LookCommand getLookCommand() {
        return lookCommand;
    }

    public void setLookCommand(LookCommand lookCommand) {
        this.lookCommand = lookCommand;
    }

    public TalkCommand getTalkCommand() {
        return talkCommand;
    }

    public void setTalkCommand(TalkCommand talkCommand) {
        this.talkCommand = talkCommand;
    }

    public void execute(Player player) {
        System.out.println("Comandos: \n clues ");
        for(int i = 0; i<CluesCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+CluesCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" dialogueLoader ");
        for(int i = 0; i<DialogueLoaderCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+DialogueLoaderCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" exit ");
        for(int i = 0; i<ExitCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+ExitCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" help ");
        for(int i = 0; i<HelpCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+HelpCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" go ");
        for(int i = 0; i<GoCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+GoCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" inspect ");
        for(int i = 0; i<InspectCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+InspectCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" look ");
        for(int i = 0; i<LookCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+LookCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" talk ");
        for(int i = 0; i<TalkCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+TalkCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" use ");
        for(int i = 0; i<UseCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+UseCommand.getCOMMAND_NAMES()[i]);
        }
        System.out.println(" usableItems ");
        for(int i = 0; i<UsableItemsCommand.getCOMMAND_NAMES().length;i++){
            System.out.println(" -"+UsableItemsCommand.getCOMMAND_NAMES()[i]);
        }
    }

    public static String[] getCOMMAND_NAMES() {
        return COMMAND_NAMES;
    }

    public void setCommands(CluesCommand cluesCommand, DialogueLoaderCommand dialogueLoaderCommand, ExitCommand exitCommand, GoCommand goCommand, InspectCommand inspectCommand, LookCommand lookCommand, TalkCommand talkCommand, UseCommand useCommand, UsableItemsCommand usableItemsCommand) {
        this.cluesCommand = cluesCommand;
        this.dialogueLoaderCommand = dialogueLoaderCommand;
        this.exitCommand = exitCommand;
        this.goCommand = goCommand;
        this.inspectCommand = inspectCommand;
        this.lookCommand = lookCommand;
        this.talkCommand = talkCommand;
        this.useCommand = useCommand;
        this.usableItemsCommand = usableItemsCommand;
    }

    public UsableItemsCommand getUsableItemsCommand() {
        return usableItemsCommand;
    }

    public void setUsableItemsCommand(UsableItemsCommand usableItemsCommand) {
        this.usableItemsCommand = usableItemsCommand;
    }

    public UseCommand getUseCommand() {
        return useCommand;
    }

    public void setUseCommand(UseCommand useCommand) {
        this.useCommand = useCommand;
    }
}
