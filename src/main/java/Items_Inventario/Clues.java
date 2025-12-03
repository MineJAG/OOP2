/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;

/**
 *
 * @author ajone
 */
public class Clues extends Item{
    String name;
    String description;
    
    public Clues(String name, String description) {
        super(name, description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
