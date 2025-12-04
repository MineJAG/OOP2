/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import Characters.Character;
import Rooms.Sala;
import java.util.ArrayList;
/**
 *
 * @author ajone
 */
public class Npc extends Character {
    private ArrayList<DialogueLines> dialogs = new ArrayList<DialogueLines>(); 
    public Npc(String name, Sala salaN, ArrayList<DialogueLines> dialogs){
        super(name, salaN);
        this.dialogs = dialogs;
    }

    //public String talk(){
        
    //}
    

}
