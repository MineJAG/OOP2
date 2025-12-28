/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endings;

import Characters.Player;
import Rooms.Foggy_balcony;

/**
 * Classe que representa o ending 2 no jogo. Esta classe verifica se o jogador cumpriu os requisitos para ativar este ending e executa as acções associadas a este ending.
 * @author Bibby
 */
public class Ending2 implements Ending{
    @Override
    public boolean check(Player player){
        if (!(player.getPresentRoom() instanceof Foggy_balcony)){
            return false;
        } else {
            if(!player.getInventory().containsItems(new String[]{"faca", "testamento_alterado", "Copia_do_livro","documento_perdido","luvas","pedaco_de_cortina","cortina_vermelha","relogio"})){
                return true;
            }
            else{
                return false;
                }
            }
        }
    @Override
    public void trigger(){
        System.out.println("Sherlock chega à varanda apenas com suspeitas. Victor percebe a falha imediatamente.\n\r Um movimento rápido, um empurrão inesperado. Sherlock morre, e o crime fica oficialmente sem solução.\n");
        System.out.println("thanks for playing!");
        System.exit(0);
    }
}
