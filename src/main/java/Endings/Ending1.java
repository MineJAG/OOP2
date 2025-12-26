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
            if(player.getInventory().containsItems(new String[]{"faca", "testamento_alterado", "Copia_do_livro","documento_perdido","luvas","pedaco_de_cortina","cortina_vermelha","relogio"})){
                return true;
            }
            else{
                return false;
                }
            }
        }
    @Override
    public void trigger(){
        System.out.println("Na varanda, Sherlock apresenta todas as provas. Não há espaço para desculpas.\n\r Victor é confrontado com factos irrefutáveis e perde qualquer hipótese de negação. A polícia é chamada.\n\r O caso termina com o culpado preso.\n");
        System.out.println("thanks for playing!");
        System.exit(0);
    }
}
