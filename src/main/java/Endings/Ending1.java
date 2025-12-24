/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endings;

import Characters.Player;
import Rooms.Foggy_balcony;

/**
 *
 * @author ajone
 */
public class Ending1 implements Ending{
    @Override
    public boolean check(Player player){
        if (!(player.getPresentRoom() instanceof Foggy_balcony)){
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void trigger(){
        System.out.println("Obrigado por jogar!");
    }
}
