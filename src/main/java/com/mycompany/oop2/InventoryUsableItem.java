/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bibby
 */
public class InventoryUsableItem extends Inventory implements Comands{
    private List<UsableItem> usables;

    public InventoryUsableItem() {
        usables = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String result = "Usables: \n";
        for (UsableItem usable : usables) {
            result += "- " + usable.getName() + "\n";
        }
        return result;
    }
}
