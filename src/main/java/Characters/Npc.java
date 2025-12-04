/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;
import Rooms.Sala;
import java.util.ArrayList;
/**
 *
 * @author ajone
 */
public class Npc extends Character {
    private ArrayList<DialogueLine> dialogs = new ArrayList<>(); 
    public Npc(String name, Sala salaN){
        super(name, salaN);
    }
    
    public ArrayList<DialogueLine> getDialogs() {
        return dialogs;
    }

    public void setDialogs(ArrayList<DialogueLine> dialogs) {
        this.dialogs = dialogs;
    }
   //public String talk(){
        
    //}


}
