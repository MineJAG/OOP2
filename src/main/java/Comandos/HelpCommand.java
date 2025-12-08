/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

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
        for(int i = 0; i<cluesCommand.get)
        System.out.println(" dialogueLoader ");
        System.out.println(" exit ");
        System.out.println(" go ");
        System.out.println(" inspect ");
        System.out.println(" look ");
        System.out.println(" talk ");
        System.out.println(" use ");
        System.out.println(" usableItems ");
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
