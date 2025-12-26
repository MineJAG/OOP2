/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import java.util.*;
import Characters.Npc;
import Items_Inventario.Inventory;


/**
 * Gere a estrututa base de todas as Salas
 * @author Tiago
 */
public abstract class Sala {
    private String name, description;
    private Sala directionN, directionS, directionE, directionW;
    private Inventory roomInventory = new Inventory();
    private List<Npc> npcs = new ArrayList<Npc>();

    public Sala(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, Inventory roomInventory) {
        this.name = name;
        this.description = description;
        this.directionN = directionN;
        this.directionS = directionS;
        this.directionE = directionE;
        this.directionW = directionW;
        this.roomInventory = roomInventory;
    }   

    public void addNpc(Npc npc){
        npcs.add(npc);
    }
    
    public List<Npc> getNpcs(){
        return npcs;
    }
    
    public Inventory getInventory() {
        return roomInventory;
    }

    public String getName(){
        return name;
    }
    
    public String getDescription(){
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

    public boolean canGo(String direction){
        return true;
    }
    
    public abstract void initializeInventory();

}
