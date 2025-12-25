/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endings;

import Characters.Player;

/**
 *
 * @author Bibby
 */
public class Ending3 implements Ending{
    @Override
    public boolean check(Player player){
        for(int i = 0; i < player.getItemHistory().size(); i++){
            if(player.getInventory().getInventory().get(i).getName().toLowerCase().equals("carta" + "on" + "victor")){
                return true;
            }
        }
        return false;
    }
    @Override
    public void trigger(){
        System.out.println("Ao ler a carta, Victor perde o controlo. As palavras falam de confiança, amizade e da quantia que a vítima planeava entregar-lhe. A culpa pesa mais do que o medo. Victor admite o crime. O caso fica resolvido.");
    }
}
