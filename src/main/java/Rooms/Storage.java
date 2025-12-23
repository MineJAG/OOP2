/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Characters.Npc;
import Items_Inventario.Clues;
import Items_Inventario.Inventory;

/**
 *
 * @author tiago
 */
public class Storage extends Sala{
    private boolean isLightOn = false;
    public Storage(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Depósito", 
            "O quarto está numa escuridão total, não vejo nada...\r\n"+
            "Sinto um cheiro a mofo e pó.\r\n" +
            "Se ao menos tivesse algo...", 
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory());
            initializeInventory();
            NpcSpawner();
    }

    public void lightUp() {
        if (!isLightOn) {
            isLightOn = true;
            setDescription("Fez-se luz caralho puta fodasse");
        }
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    @Override
    public void initializeInventory(){
        Inventory in = new Inventory();
        in.addItem(new Clues("Faca", "Faca ainda marcada com sangue seco, provavelmente a arma do crime."));
        in.addItem(new Clues("Tecido", "Parece ser um pedaço de cortina, é vermelho."));
        super.getInventory().addInventory(in);
    }

    @Override
    public void NpcSpawner(){
        npcs.add(new Npc("pedro7",this));
    }
}
