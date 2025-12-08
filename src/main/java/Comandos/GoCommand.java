/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Characters.Player;
import Rooms.Bar;
import Rooms.Sala;
import java.util.*;

/**
 *
 * @author tiago
 */
public class GoCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"go", "ir", "move", "mover", "walk", "andar", "seguir", "proceed", "avançar", "avancar", "continue", "continuar", "head", "dirigir", "dirige", "partir"};
    private static final String[] DIRECTIONSN = {"north", "norte","cima","up"};
    private static final String[] DIRECTIONSS = {"south", "sul", "baixo","down"}; 
    private static final String[] DIRECTIONSE = {"east", "este", "direita","right"}; 
    private static final String[] DIRECTIONSW = {"west", "oeste", "esquerda","left"};

    public static String[] getCOMMAND_NAMES() {
        return COMMAND_NAMES;
    }

    public static String[] getDIRECTIONSN() {
        return DIRECTIONSN;
    }

    public static String[] getDIRECTIONSS() {
        return DIRECTIONSS;
    }

    public static String[] getDIRECTIONSE() {
        return DIRECTIONSE;
    }

    public static String[] getDIRECTIONSW() {
        return DIRECTIONSW;
    }
    private String direction;

    public boolean coorrectDirection(Player player, List<String> words) {
        for (String S : words) {
            for (String dn : DIRECTIONSN) {
                if (S.equalsIgnoreCase(dn)){
                    direction = "north";
                    return true;
                }
            }
            for (String ds : DIRECTIONSS) {
                if (S.equalsIgnoreCase(ds)){
                    direction = "south";
                    return true;
                }
            }
            for (String de : DIRECTIONSE) {
                if (S.equalsIgnoreCase(de)){
                    direction = "east";
                    return true;
                }
            }
            for (String dw : DIRECTIONSW) {
                if (S.equalsIgnoreCase(dw)){
                    direction = "west";
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canGo(Player player) {
        if (player.getPresentRoom().getDirectionN() != null && direction.equalsIgnoreCase("north")) {
            return true;
        }
        if(player.getPresentRoom().getDirectionS() != null &&  direction.equalsIgnoreCase("south")) { 
            return true;
        }
        if (player.getPresentRoom().getDirectionE() != null && direction.equalsIgnoreCase("east")) {
            return true;
        }
        if (player.getPresentRoom().getDirectionW() != null && direction.equalsIgnoreCase("west")) {
            return true;
        }   
        direction = null;
        return false;
    }


    public void execute(Player player) {
        Sala currentRoom = player.getPresentRoom();
        Sala nextRoom = null;

        if (direction.equalsIgnoreCase("north")) {
            nextRoom = currentRoom.getDirectionN();
        } else if (direction.equalsIgnoreCase("south")) {
            nextRoom = currentRoom.getDirectionS();
        } else if (direction.equalsIgnoreCase("east")) {
            nextRoom = currentRoom.getDirectionE();
        } else if (direction.equalsIgnoreCase("west")) {
            nextRoom = currentRoom.getDirectionW();
        }
        player.setPresentRoom(nextRoom);
        System.out.println("O Sherlock move-se para a sala: " + nextRoom.getName() + ".");
        direction = null;
    }

    public static String[] getCommandNames() {
        return COMMAND_NAMES;
    }

    public static String[] getDirectionsn() {
        return DIRECTIONSN;
    }

    public static String[] getDirectionss() {
        return DIRECTIONSS;
    }

    public static String[] getDirectionse() {
        return DIRECTIONSE;
    }

    public static String[] getDirectionsw() {
        return DIRECTIONSW;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
