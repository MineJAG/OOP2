/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Comandos;

import Characters.Player;

/**
 *
 * @author ajone
 */
public interface Commands {
    public boolean verifyCommand(String userInput);
    public void execute(Player player);
    
}
