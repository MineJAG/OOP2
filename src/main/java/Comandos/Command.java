/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Comandos;

import java.util.ArrayList;
import java.util.List;
import Characters.Player;

/**
 * Define o comportamento comum de todos os comandos do jogo.
 * @author ajone
 */
public interface Command {
    public String[] names();

    default boolean matches(ArrayList<String> words) {
        for (String c : names()) {
            for (String w : words) {
                if (w.equalsIgnoreCase(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void execute(Player player, ArrayList<String> words) throws Exception;
    public String getName();
    public String toString();
}


