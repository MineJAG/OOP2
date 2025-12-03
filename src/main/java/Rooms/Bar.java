/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;

import Items_Inventario.Inventory;
import Items_Inventario.Item;

import java.util.ArrayList;
import java.util.*;

import Characters.Npc;
import Items_Inventario.*;

/**
 *
 * @author tiago
 */
public class Bar extends Sala{
    private String name, description;
    private Sala directionN, directionS, directionE, directionW = null;
    private Inventory roomInventory = new Inventory();
    public Bar(String name, String description, Inventory roomInventory) {
        super(name,description, null, null, null, null,roomInventory, null);
        
        
        
    } 
 



    
    
}
