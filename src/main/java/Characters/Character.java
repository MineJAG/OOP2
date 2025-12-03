/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import Rooms.Sala;

/**
 *
 * @author ajone
 */
public class Character {
    private String name;
    private Sala presentRoom;
    public Character(String name, Sala presentRoom){
        this.name = name;
        this.presentRoom = presentRoom;
    }
    
    public String getName(){
        return name;
    }
    
    public Sala getSalaN(){
        return presentRoom;
    }
    
    public Sala setSalaN(Sala newSala){
        return this.presentRoom = newSala;
    }
            
}
