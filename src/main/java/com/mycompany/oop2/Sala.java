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
public class Sala {
    private String name, description;
    private Sala directionN, directionS, directionE, directionW;
    private Inventory roomInventory = new Inventory();
    public Sala(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, ArrayList<Inventory> inventory){
        this.name = name;
        this.description = description;
        this.directionN = directionN;
        this.directionS = directionS;
        this.directionE = directionE;
        this.directionW = directionW;
        this.inventory = inventory;
    }   
    
    public ArrayList<Inventory> getInventory() {
        return inventory;
    }

    public String getName(){
        return name;
    }
    
    public String getDescriprion(){
        return description;
    }
    
    public String setDescription(String X){
        return this.description = X;
    }
    
    public Sala getDirectionN(){
        return directionN;
    }
    
    public Sala setDirectionN(Sala N){
        return this.directionN = N;
    }
    
    public Sala getDirectionS(){
        return directionS;
    }
    
    public Sala setDirectionS(Sala S){
        return this.directionS = S;
    }
    
    public Sala getDirectionW(){
        return directionW;
    }
    
    public Sala setDirectionW(Sala W){
        return this.directionW = W;
    }
    
    public Sala getDirectionE(){
        return directionE;
    }
    
    public Sala setDirectionE(Sala E){
        return this.directionE = E;
    }
    
    @Override
    public String toString(){
        return "Sala:" + name +"\n Descricao: " + description +"\n Direcoes: " + directionN +"\n" + directionW + "\n" + directionE +"\n" + directionS;
    }
    
}
