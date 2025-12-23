/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;

import java.util.ArrayList;
import Characters.*;
import Items_Inventario.Clues;
import Items_Inventario.UsableItem;

/**
 *
 * @author tiago
 */
public class Map_game {
    private Sala spawn;
    private Sala bar, bathroom, balcony, library, hall, office, room, storage, vipRoom;
    private ArrayList<Npc> npcs = new ArrayList<>();
    
    public Map_game(){
        createRooms();
        connectRooms();
        spawnNpcs(new Npc("Lady_Eleanor", hall, null));
        spawnNpcs(new Npc("Oliver_Barman", bar, new UsableItem("Chave", "Uma chave dourada, está um pouco enferrujada. hum? Talvez possa abrir algo com ela.", "Bar")));
        spawnNpcs(new Npc("MARGARET_PROFESSORA", library, new UsableItem("Fosforos","Uma fonte de luz fraca mas, capaz de iluminar algo.","Depósito")));
        spawnNpcs(new Npc("INSPECTOR_GRAHAM", room, null));
        spawnNpcs(new Npc("VICTOR_MORDOMO", vipRoom, null));
        spawnNpcs(new Npc("RICK_DOUTOR", bar, null));
        spawnNpcs(new Npc("EMPREGADA", bathroom, new Clues("Luvas", "Estão sujas com manchas de sangue seco. São luvas masculinas com um “V” manuscrito no pulso das luvas. Estranho…")));
        spawnNpcs(new Npc("CRIANÇA", hall, new Clues("Ursinho","Hum...estranho...Contém os números 2026")));
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

    public void spawnNpcs(Npc npc){
        npcs.add(npc);
    }

    public Sala getSpawn() {
        return spawn;
    }
    
}
