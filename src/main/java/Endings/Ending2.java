/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endings;

import Characters.Player;
import Rooms.Foggy_balcony;

/**
 *
 * @author Bibby
 */
public class Ending2 implements Ending{
    @Override
    public boolean check(Player player){
        if (!(player.getPresentRoom() instanceof Foggy_balcony)){
            return false;
        } else {
            if(!player.getInventory().containsItems(new String[]{"faca", "testamento_alterado", "copia_de_um_livro","verdade_sobre_o_livro","luvas","pedaco_de_cortina","cortina_rasgada","relogio_parado"})){
                return true;
            }
            else{
                return false;
                }
            }
        }
    @Override
    public void trigger(){
        System.out.println("Sherlock chega à varanda apenas com suspeitas. Victor percebe a falha imediatamente. Um movimento rápido, um empurrão inesperado. Sherlock morre, e o crime fica oficialmente sem solução.");
    }
}
