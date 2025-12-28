/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;

/**
 * Items usáveis.
 * @author Lara
 */
public class UsableItem extends Item{
    private String toBeUsed;

    public UsableItem(String name, String description, String toBeUsed) {
        super(name, description);
        this.toBeUsed = toBeUsed;
    }

    public String getToBeUsed() {
        return toBeUsed;
    }
}
