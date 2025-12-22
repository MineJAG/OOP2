/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Comandos;

import java.util.List;
import Characters.Player;

/**
 *
 * @author ajone
 */
public interface Command {
    boolean matches(List<String> words);
    void execute(Player player, List<String> words) throws Exception;
}

