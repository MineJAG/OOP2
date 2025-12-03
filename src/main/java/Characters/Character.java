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
public abstract class Character {
    private String name;
    private Sala presentRoom;
    public Character(String name, Sala presentRoom){
        this.name = name;
        this.presentRoom = presentRoom;
    }
    
    public String getName(){
        return name;
    }
    
    public Sala getPresentRoom(){
        return presentRoom;
    }
    
    public Sala setPresentRoom(Sala newSala){
        return this.presentRoom = newSala;
    }
            
}
