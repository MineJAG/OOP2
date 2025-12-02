/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.oop2;

/**
 *
 * @author ajone
 */
public interface Comands {
    public boolean verifyName(String name); //verificar se é para usar mesmo esse comando
    public void execute(Player player);
    
}
