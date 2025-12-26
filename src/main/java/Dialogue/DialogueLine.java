package Dialogue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
/**
 * Classe que representa uma linha de dialogo no jogo tem como responsabilidade guardar a linha de dialogo e as opcoes associadas a essa linha.
 * @author ajone
 */
public class DialogueLine {
    private String line;
    private ArrayList<DialogueOption> options;

    public DialogueLine(String line) {
        this.line = line;
        this.options = new ArrayList<>();
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public ArrayList<DialogueOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<DialogueOption> options) {
        this.options = options;
    }

    public void addOption(DialogueOption option) {
        this.options.add(option);
    }
}
