/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;

/**
 *
 * @author ajone
 */
public class UsableItem extends Item{
    private boolean used;

    public UsableItem(String name, String description) {
        super(name, description);
        used = false;
    }

    public boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
