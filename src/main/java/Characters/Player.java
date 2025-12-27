/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import java.util.ArrayList;

import Items_Inventario.Inventory;
import Rooms.Sala;

/**
 * Classe que representa o jogador no jogo tem como responsabilidade guardar informacoes sobre o jogador.
 * @author Afonso, Lara, Tiago
 */
public class Player extends Character {
    private ArrayList<String> itemHistory = new ArrayList<>();
    
    public Player(String name, Inventory inventory, Sala presentRoom){
        super(name, inventory, presentRoom);
    }
    
    public ArrayList<String> getItemHistory() {
        return new ArrayList<>(itemHistory);
    }
    
    public void addItemHistory(String history){
        itemHistory.add(history);
    }
    public void itemHistoryCheck(){
        for (String item : itemHistory) {
            System.out.println(item);
        }
    }
}
