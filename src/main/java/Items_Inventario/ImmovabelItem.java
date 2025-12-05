/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;

/**
 *
 * @author Bibby
 */
public class ImmovabelItem extends Item {
    private String descriptionEmpty;
    private Inventory items;
    private final boolean CAN_HOLD_ITEMS;

    private String descriptionUnlocked;
    private final String CODE;
    private final boolean IS_LOCKABLE;

    //so um item com nada
    public ImmovabelItem(String name, String description) {
        super(name, description);
        items = null;
        CODE = null;
        CAN_HOLD_ITEMS = false;
        descriptionEmpty = null;
        IS_LOCKABLE = false;
        descriptionUnlocked = null;
    }

    //aberto e contém items
    public ImmovabelItem(String name, String description, Inventory items, String descriptionEmpty) {
        super(name, description + "Está contido dentro deste objeto:\n" + items.toString());
        this.items = items;
        CODE = null;
        CAN_HOLD_ITEMS = true;
        this.descriptionEmpty = descriptionEmpty;
        IS_LOCKABLE = false;
        descriptionUnlocked = null;
    }

    //se tiver trancado e código, se só tiver trancado, pôr código para null
    public ImmovabelItem(String name, String description, Inventory items, String CODE, String descriptionUnlocked, String descriptionEmpty) {
        super(name, description);
        this.items = items;
        this.CODE = CODE;
        CAN_HOLD_ITEMS = true;
        this.descriptionEmpty = descriptionEmpty;
        IS_LOCKABLE = true;
        this.descriptionUnlocked = descriptionUnlocked + "Está contido dentro deste objeto:\n" + items.toString();

    }

    public boolean getCAN_HOLD_ITEMS() {
        return CAN_HOLD_ITEMS;
    }

    public boolean isHoldingItems() {
        return !items.isEmpty();
    }

    public void clearItems() {
        items.clear();
        setDescription(descriptionEmpty);
    }

    public Inventory getItems() {
        return items;
    }  

    public boolean getIS_LOCKABLE() {
        return IS_LOCKABLE;
    }

    public boolean isUnlocked() {
        return getDescription().equals(descriptionUnlocked);
    }

    public void unlock() {
        setDescription(descriptionUnlocked);
    }

    public String getCODE() {
        return CODE;
    }
}
