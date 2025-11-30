/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

/**
 *
 * @author ajone
 */
public class UsableItem extends Item{
    String name;
    String description;
    boolean used;

    public UsableItem(String name, String description) {
        super(name, description);
        used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }



}
