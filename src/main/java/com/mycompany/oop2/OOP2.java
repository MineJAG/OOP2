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
        // Inicializa as Salas com valores nulos para as conexões
        Bar bar = new Bar(null, null, null, null, true);
        Bathroom bathroom = new Bathroom(null, null, null, null);
        Foggy_balcony balcony = new Foggy_balcony(null, null, null, null);
        Library library = new Library(null, null, null, null);
        Main_hall hall = new Main_hall(null, null, null, null);
        Office office = new Office(null, null, null, null);
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
        library.setDirectionS(bar); 
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
        player.getInventory().addItem(new UsableItem("LALA", "llll1","Depósito"));
        player.getInventory().addItem(new Clues("Piar", "nover"));
        Scanner scanner = new Scanner(System.in);
        bar.getInventory().addItem(new UsableItem("Cervja", "Cerveja1","Bar"));
        bar.getInventory().addItem(new Clues("bananas", "banana1"));
        bar.getInventory().addItem(new ImmovabelItem("Pilar", "nAO pode nover"));
        bar.getInventory().addItem(new UsableItem("Cereja", "Ceredas","isk"));
        Inventory chis = new Inventory();
        chis.addItem(new Clues("documentos", "documentos1"));
        chis.addItem(new UsableItem("livro", "nao sei","isk"));
        Inventory chis2 = new Inventory();
        chis2.addItem(new Clues("documentos2", "documentos12"));
        chis2.addItem(new UsableItem("livro2", "nao sei2","isk"));
        bar.getInventory().addItem(new ImmovabelItem("Cofre", "Encontra-se trancado.", chis, "ola", "Encontra-se aberto.", "Está vazio."));
        bar.getInventory().addItem(new ImmovabelItem("Gaveta", "Uma gaveta que pode guardar coisas dentro.", chis2, "Está vazia."));
        

        //Introdução do jogo (NÃO APAGAR)
        System.out.println("==== INTRODUÇÃO AO JOGO ====");
        System.out.println("Na luxuosa Mansão Blackwood decorre o baile anual.\r\n" + "O Lorde Alistair Blackwood foi encontrado morto no seu quarto.\r\n" +
                            "A mansão ficou imediatamente trancada devido à tempestade e à névoa densa no exterior.\r\n" + "Sherlock está preso dentro da mansão com convidados e possíveis assassinos.\r\n" + 
                            "Cabe a si resolver o mistério e encontrar o assassino antes que ele ataque novamente.\r\n" + "Boa sorte, detetive!\r\n" +"");

        //Ciclo infinito de jogo
        CommandRunner commandRunner = new CommandRunner();
        while (true) {
            System.out.print("Escreva um comando: ");
            String linha = scanner.nextLine().trim();
            commandRunner.runCommands(player, linha);
        }
    }
}
