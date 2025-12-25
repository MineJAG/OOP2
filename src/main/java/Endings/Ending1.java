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
            if(player.getInventory().containsItems(new String[]{"faca", "testamento_alterado", "copia_de_um_livro","verdade_sobre_o_livro","luvas","pedaco_de_cortina","cortina_rasgada","relogio_parado"})){
                return true;
            }
            else{
                return false;
                }
            }
        }
    @Override
    public void trigger(){
        System.out.println("Na varanda, Sherlock apresenta todas as provas. Não há espaço para desculpas. Victor é confrontado com factos irrefutáveis e perde qualquer hipótese de negação. A polícia é chamada. O caso termina com o culpado preso.");
    }
}
