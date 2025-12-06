/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oop2;
import Characters.*;
import Items_Inventario.*;
import Rooms.*;
import Comandos.*;
import java.util.*;

/**
 *
 * @author ajone
 */
public class OOP2 {

    public static void main(String[] args) {
        // Inicializa os quartos com valores nulos para as conexões
        Bar bar = new Bar(null, null, null, null);
        Bathroom bathroom = new Bathroom(null, null, null, null);
        Foggy_balcony balcony = new Foggy_balcony(null, null, null, null);
        Library library = new Library(null, null, null, null);
        Main_hall hall = new Main_hall(null, null, null, null);
        Office office = new Office(null, null, null, null, true);
        Room room = new Room(null, null, null, null);
        Storage storage = new Storage(null, null, null, null);
        VIP_room vipRoom = new VIP_room(null, null, null, null);
        
        
        //Ligação das salas
        bar.setDirectionE(storage);
        bar.setDirectionN(library);
        bar.setDirectionS(hall);
        bathroom.setDirectionW(hall);
        balcony.setDirectionS(room);
        library.setDirectionW(room);
        library.setDirectionE(office);
        hall.setDirectionN(bar);
        hall.setDirectionE(bathroom);
        hall.setDirectionW(vipRoom);
        office.setDirectionW(library); 
        room.setDirectionN(balcony);
        room.setDirectionE(library);
        storage.setDirectionW(bar);
        vipRoom.setDirectionE(hall);
        
        Player player = new Player("Sherlock Holmes", hall);
        Inventory inn = player.getInventory();
        inn.addItem((Item)new Clues("elfo", "elfo1"));
        player.setInventory(inn);
        player.getInventory().addItem(new UsableItem("LALA", "llll1"));
        player.getInventory().addItem(new Clues("Piar", "nover"));
        Scanner scanner = new Scanner(System.in);
        bar.getInventory().addItem(new UsableItem("Cervja", "Cerveja1"));
        bar.getInventory().addItem(new Clues("bananas", "banana1"));
        bar.getInventory().addItem(new ImmovabelItem("Pilhar", "nAO pode nover"));
        bar.getInventory().addItem(new UsableItem("Cereja", "Ceredas"));
        Inventory chis = new Inventory();
        chis.addItem(new Clues("documentos", "documentos1"));
        chis.addItem(new UsableItem("livro", "nao sei"));
        Inventory chis2 = new Inventory();
        chis2.addItem(new Clues("documentos2", "documentos12"));
        chis2.addItem(new UsableItem("livro2", "nao sei2"));
        bar.getInventory().addItem(new ImmovabelItem("Cofre", "Encontra-se trancado.", chis, "ola", "Encontra-se aberto.", "Está vazio."));
        bar.getInventory().addItem(new ImmovabelItem("Gaveta", "Uma gaveta que pode guardar coisas dentro.", chis2, "Está vazia."));
        
        CommandRunner commandRunner = new CommandRunner();
        for (int i = 0; i < 69; i++) {
            System.out.print("Escreve um comando: ");
            String linha = scanner.nextLine();
            commandRunner.runCommands(player, linha);
            linha = "";
            
        }
        scanner.close();
       
    }
}
