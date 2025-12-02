/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;
import java.util.ArrayList;
/**
 *
 * @author ajone
 */
public class Npc extends Character {
    private ArrayList<String> dialogs = new ArrayList<String>(); 
    public Npc(String name, Sala salaN, ArrayList<String> dialogs){
        super(name, salaN);
        this.dialogs = dialogs;
    }

    //public String talk(){
        
    //}
    

}
