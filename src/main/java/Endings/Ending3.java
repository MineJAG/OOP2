/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endings;

import Characters.Player;

/**
 * Classe que representa o ending 3 no jogo. Esta classe verifica se o jogador cumpriu os requisitos para ativar este ending e executa as acções associadas a este ending.
 * @author Afonso
 */
public class Ending3 implements Ending{
    @Override
    public boolean check(Player player){
        for(int i = 0; i < player.getItemHistory().size(); i++){
            if(player.getItemHistory().get(i).toLowerCase().equals("carta" + "on" + "victor")){
                return true;
            }
        }
        return false;
    }
    @Override
    public void trigger(){
        System.out.println("Ao ler a carta, Victor perde o controlo. As palavras falam de confiança, amizade e da quantia que a vítima planeava entregar-lhe. A culpa pesa mais do que o medo. Victor admite o crime. O caso fica resolvido.");
        System.out.println("thanks for playing!");
        System.exit(0);
    }
}
