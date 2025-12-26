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
public class Ending4 implements Ending{
    @Override
    public boolean check(Player player){
        for(int i = 0; i < player.getItemHistory().size(); i++){
            if(player.getItemHistory().get(i).toLowerCase().equals("carta_rasgada" + "on" + "eleanor")){
                return true;
            }
        }
        return false;
    }
    @Override
    public void trigger(){
        System.out.println("A carta das dívidas expõe a verdade financeira por trás do crime. Eleanor é responsabilizada, o motivo era controlo e dinheiro. O culpado é identificado, e o caso é encerrado. Dias depois Sherlock morre, a pessoa errada foi presa.");
        System.out.println("thanks for playing!");
        System.exit(0);
    }
}
