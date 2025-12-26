/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import java.util.*;
import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.Inventory;
import Items_Inventario.Item;
import Items_Inventario.UsableItem;

/**
 * Gere a inicialização e ligação das Salas como também inicializa/cria os NPCs 
 * @author Tiago
 */
public class Map_game {
    private Sala spawn;
    private Sala bar, bathroom, balcony, library, hall, office, room, storage, vipRoom;
    private List<Npc> npcs = new ArrayList<>();
    
    public Map_game(){
        createRooms();
        connectRooms();
        spawnNpcs(new Npc(null,"Eleanor", hall));
        Inventory barmanInv = new Inventory();
        barmanInv.addItem(new UsableItem("Chave","Uma chave dourada, está um pouco enferrujada. hum? Talvez possa abrir algo com ela.","Bar"));
        spawnNpcs(new Npc(barmanInv, "Barman", bar));
        spawnNpcs(new Npc("Margaret", library, new UsableItem("Fosforos","Uma fonte de luz fraca mas, capaz de iluminar algo.","Depósito")));
        spawnNpcs(new Npc("Inspector", room, null));
        spawnNpcs(new Npc("Victor", vipRoom, null));
        spawnNpcs(new Npc("Rick", bar, null));
        spawnNpcs(new Npc("Empregada", bathroom, new Clues("Luvas", "Estão sujas com manchas de sangue seco. São luvas masculinas com um “V” manuscrito no pulso das luvas. Estranho…")));
        spawnNpcs(new Npc("Crianca", hall, new Clues("Ursinho","Hum...estranho...Contém os números 2026")));
    }

    // Inicializa as Salas
    private void createRooms() {
        bar = new Bar(true);
        bathroom = new Bathroom();
        balcony = new Foggy_balcony();
        library = new Library();
        hall = new Main_hall();
        office = new Office();
        room = new Room();
        storage = new Storage();
        vipRoom = new VIP_room();
    }
    
    // Ligação das salas
    private void connectRooms() {
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
        spawn = hall;
    }

    //Cria Npcs e coloca-os no array global
    public void spawnNpcs(Npc npc){
        if(npc.getPresentRoom()!=null){
            npc.getPresentRoom().addNpc(npc);
        }
        npcs.add(npc);
    }

    public Sala getSpawn() {
        return spawn;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }
    
}
