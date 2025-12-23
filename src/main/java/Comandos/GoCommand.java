/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Characters.Player;
import Rooms.Sala;
import java.util.*;

/**
 *
 * @author tiago
 */
public class GoCommand implements Command{
    private String name = "Go Command - choose where to go syntax go then direction";
    public static final String[] COMMAND_NAMES = {"go", "ir", "move", "mover", "walk", "andar", "seguir", "proceed", "avançar", "avancar", "continue", "continuar", "head", "dirigir", "dirige", "partir"};
    private static final String[] DIRECTIONSN = {"north", "norte","cima","up"};
    private static final String[] DIRECTIONSS = {"south", "sul", "baixo","down"}; 
    private static final String[] DIRECTIONSE = {"east", "este", "direita","right"}; 
    private static final String[] DIRECTIONSW = {"west", "oeste", "esquerda","left"};

    public String[] names() {
        return COMMAND_NAMES;
    }
    
    public void execute(Player player, ArrayList<String> words) throws Exception {
        if (player.getPresentRoom() == null){
            throw new Exception("O Sherlock não se encontra numa sala.");
        }

        String direction = null;
        //Verifica se o input do player = direçao equivalente
        for (String word : words){
            for (String d : DIRECTIONSN){
                if (word.equalsIgnoreCase(d)){
                    direction = "north";
                }
            }

            for (String d : DIRECTIONSS){
                if (word.equalsIgnoreCase(d)){
                    direction = "south";
                }
            }

            for (String d : DIRECTIONSE){
                if (word.equalsIgnoreCase(d)){
                    direction = "east";
                }
            }

            for (String d : DIRECTIONSW){
                if (word.equalsIgnoreCase(d)){
                    direction = "west";
                }
            }
        }

        if (direction == null){
            throw new Exception("Direção inválida");
        }

        Sala currentRoom = player.getPresentRoom();
        Sala nextRoom = null;

        switch (direction) {
            case "north":
                nextRoom = currentRoom.getDirectionN();
                break;
            case "south":
                nextRoom = currentRoom.getDirectionS();
                break;
            case "east":
                nextRoom = currentRoom.getDirectionE();
                break;
            case "west":
                nextRoom = currentRoom.getDirectionW();
                break;
        }

        if(nextRoom == null){
            throw new Exception("Não há nada aqui.");
        }

        player.setPresentRoom(nextRoom);
        System.out.println("O Sherlock move-se para a sala: " + nextRoom.getName() + ".");   
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t-";
        for(int i = 0; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        result += "\n Directions: \n\t-North \n\t-";
        for(int i = 0; i < DIRECTIONSN.length; i++) {
            result += ", " + DIRECTIONSN[i];
        }
        result += "\n\t-South \n\t-";
        for(int i = 0; i < DIRECTIONSS.length; i++) {
            result += ", " + DIRECTIONSS[i];
        }
        result += "\n\t-East \n\t-";
        for(int i = 0; i < DIRECTIONSE.length; i++) {
            result += ", " + DIRECTIONSE[i];
        }
        result += "\n\t-West \n\t-";
        for(int i = 0; i < DIRECTIONSW.length; i++) {
            result += ", " + DIRECTIONSW[i];
        }
        return result;
    }
}
