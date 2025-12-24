/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Endings;

/**
 *
 * @author ajone
 */

import Characters.Player;

public interface Ending {
    public boolean check(Player player);
    public void trigger();
}
