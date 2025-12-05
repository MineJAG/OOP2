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
        Bar bar = new Bar("Bar", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        Bathroom bathroom = new Bathroom("Casa de Banho", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        Foggy_balcony balcony = new Foggy_balcony("Varanda Sombria", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        Library library = new Library("Biblioteca", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        Main_hall hall = new Main_hall("Salão Principal", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        Office office = new Office("Escritório", null, null, null, null, null, new Inventory(), new ArrayList<Npc>() , true);
        Room room = new Room("Quarto", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        Storage storage = new Storage("Armazém", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        VIP_room vipRoom = new VIP_room("Sala VIP", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        
        
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
        for (int i = 0; i < 10; i++) {
            System.out.print("Escreve um comando: ");
            String linha = scanner.nextLine();
            commandRunner.runCommands(player, linha);
            linha = "";
            
        }
        scanner.close();
       
    }
}
