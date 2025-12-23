/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Comandos;

import java.util.ArrayList;
import java.util.List;
import Characters.Player;

/**
 *
 * @author ajone
 */
public interface Command {
    public String[] names();

    default boolean matches(List<String> words) {
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


