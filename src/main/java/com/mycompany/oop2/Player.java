/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

/**
 *
 * @author ajone
 */
public class Player extends Character {
    private Sala presentRoom;
    public Player(String name, Sala salaN, Sala presentRoom){
        super(name, salaN);
        this.presentRoom = presentRoom;
    }

    public Sala getPresentRoom(){
        return presentRoom;
    }

    public Sala setPresentRoom(Sala newPresentRoom){
        return this.presentRoom = newPresentRoom;
    }
    
    
    
}
