/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ajone
 */
public class DialogueOptions {
    private ArrayList<String> Options = new ArrayList<>();
    private ArrayList<DialogueLine> NextLines = new ArrayList<>();

    public DialogueOptions(ArrayList<String> Options, ArrayList<DialogueLine> NextLines) {
        this.Options = Options;
        this.NextLines = NextLines;
    }

    public ArrayList<String> getOptions() {
        return Options;
    }

    public void setOptions(ArrayList<String> Options) {
        this.Options = Options;
    }

    public ArrayList<DialogueLine> getNextLines() {
        return NextLines;
    }

    public void setNextLines(ArrayList<DialogueLine> NextLines) {
        this.NextLines = NextLines;
    }
    public void selectOption(DialogueManager dialogueManager){
        for(int i = 0; i < Options.size(); i++){
                System.out.println(Options.get(i));
            }
            try (Scanner scanner = new Scanner(System.in)) {
            String choice = scanner.nextLine();
            Boolean exists = false;
            for(int j = 0; j < Options.size(); j++){
                if(choice.equals(Options.get(j))){
                    System.out.println("Sherlock: " + Options.get(j));
                    dialogueManager.setCurrentLine(NextLines.get(j));
                    exists = true;
                    if (NextLines.get(j).getOptions() != null){
                        dialogueManager.startDialogue(dialogueManager.getCurrentNpc());
                    }
                }
                if(!exists && j == Options.size() -1){
                    System.out.println("Npc:" + NextLines.get(0).getLine() + " does not exist");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}