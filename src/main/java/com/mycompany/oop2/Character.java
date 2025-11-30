/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

/**
 *
 * @author ajone
 */
public class Character {
    String name;
    Sala salaN;
    public Character(String name, Sala salaN){
        this.name = name;
        this.salaN = salaN;
    }
    
    public String getName(){
        return name;
    }
    
    public Sala getSalaN(){
        return salaN;
    }
    
    public Sala setSalaN(Sala newSala){
        return this.salaN = newSala;
    }
            
}
