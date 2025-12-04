/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Characters.Player;
import Rooms.Sala;
/**
 *
 * @author tiago
 */
public class GoCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"go", "ir", "move", "mover", "walk", "andar", "seguir", "proceed", "avançar", "avancar", "continue", "continuar", "head", "dirigir", "dirige", "partir"};
    private static final String[] DIRECTIONSN = {"north", "norte"};
    private static final String[] DIRECTIONSS = { "south", "sul"}; 
    private static final String[] DIRECTIONSE = {"east", "leste"}; 
    private static final String[] DIRECTIONSW = {"west", "oeste"};
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    public void execute(Player player) {
        Sala currentRoom = player.getPresentRoom();
        Sala nextRoom = null;
        if(direction != null){
            for(String N : DIRECTIONSN){
                if(N.equalsIgnoreCase(direction)){
                    nextRoom = currentRoom.getDirectionN();
                }
            }
            for(String S : DIRECTIONSS){
                if(S.equalsIgnoreCase(direction)){
                    nextRoom = currentRoom.getDirectionS();
                }
            }
            for(String E : DIRECTIONSE){
                if(E.equalsIgnoreCase(direction)){
                    nextRoom = currentRoom.getDirectionE();
                }
            }
            for(String W : DIRECTIONSW){
                if(W.equalsIgnoreCase(direction)){
                    nextRoom = currentRoom.getDirectionW();
                }
            }
        }
        if(nextRoom != null){
            player.setPresentRoom(nextRoom);
            System.out.println("O Sherlock move-se para " + direction + " e agora está em " + nextRoom.getName() + ".");
        } else {
            System.out.println("Não é possível mover-se para essa direção.");
        }
        direction = null;
    }
}
