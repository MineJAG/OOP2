/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import java.util.ArrayList;
import Items_Inventario.Inventory;
import Characters.Npc;
/**
 *
 * @author tiago
 */
public class Mapa {
    private Bar bar;
    private Bathroom bathroom;
    private Foggy_balcony balcony;
    private Library library;
    private Main_hall hall;
    private Office office;
    private Room room;
    private Storage storage;
    private VIP_room vipRoom;


    public Mapa() {
        // Inicializa os quartos com valores nulos para as conexões
        this.bar = new Bar("Bar", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.bathroom = new Bathroom("Casa de Banho", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.balcony = new Foggy_balcony("Varanda Sombria", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.library = new Library("Biblioteca", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.hall = new Main_hall("Salão Principal", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.office = new Office("Escritório", null, null, null, null, null, new Inventory(), new ArrayList<Npc>() , true);
        this.room = new Room("Quarto", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.storage = new Storage("Armazém", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        this.vipRoom = new VIP_room("Sala VIP", null, null, null, null, null, new Inventory(), new ArrayList<Npc>());
        
        
        //Ligação das salas
        bar.setDirectionE(storage).setDirectionN(library).setDirectionS(hall);
        bathroom.setDirectionW(hall);
        balcony.setDirectionS(room);
        library.setDirectionW(room).setDirectionE(office);
        hall.setDirectionN(bar).setDirectionE(bathroom).setDirectionW(vipRoom);
        office.setDirectionW(library); 
        room.setDirectionN(balcony).setDirectionE(library);
        storage.setDirectionW(bar);
        vipRoom.setDirectionE(hall);       
    }
}
