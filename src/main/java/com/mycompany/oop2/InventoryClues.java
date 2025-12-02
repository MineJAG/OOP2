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
public class InventoryClues {
    private List<Clues> clues;

    public InventoryClues() {
        clues = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String result = "Clues: \n";
        for (Clues clue : clues) {
            result += "- " + clue.getName() + "\n";
        }
        return result;
    }
}
