/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Clues;
import Items_Inventario.ImmovabelItem;
import Items_Inventario.Inventory;


/**
 *
 * @author tiago
 */
public class Storage extends Sala{
    private boolean isLightOn = false;
    public Storage() {
        super("Depósito", 
            "O quarto está numa escuridão total, não vejo nada...\r\n"+
            "Sinto um cheiro a mofo e pó.\r\n" +
            "Se ao menos tivesse algo...\r\n" +
            "Salas: \nW - Bar\n", 
            null, 
            null, 
            null, 
            null, 
            new Inventory());
            initializeInventory();
    }

    public void lightUp() {
        if (!isLightOn) {
            isLightOn = true;
            setDescription("O depósito... Está cheio de caixas de bebidas e condimentos. Talvez encontre algo importante.");
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
        in.addItem(new ImmovabelItem("Caixa_de_bebida","Uma caixa com bebidas... nada de interessante"));
        super.getInventory().addInventory(in);
    }

}
