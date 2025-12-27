package Items_Inventario;

/**
 * Itens imóveis, estes poderão ter coisas dentro ou estar trancados.
 * @author Lara
 */

public class ImmovabelItem extends Item {

    private final boolean CAN_HOLD_ITEMS;
    private final Inventory items;

    private final boolean IS_LOCKABLE;
    private final String CODE;
    private boolean unlocked;

    private final String descriptionLocked;
    private final String descriptionUnlocked;
    private final String descriptionEmpty;

    public ImmovabelItem(String name, String description) {
        super(name, description);

        this.items = new Inventory(); 
        this.CAN_HOLD_ITEMS = false;

        this.IS_LOCKABLE = false;
        this.CODE = null;
        this.unlocked = true; 

        this.descriptionLocked = description;
        this.descriptionUnlocked = description;
        this.descriptionEmpty = description;

        updateDescription();
    }

    public ImmovabelItem(String name, String description, Inventory items, String descriptionEmpty) {
        super(name, description);

        this.items = (items != null) ? items : new Inventory();
        this.CAN_HOLD_ITEMS = true;

        this.IS_LOCKABLE = false;
        this.CODE = null;
        this.unlocked = true;

        this.descriptionLocked = description;    
        this.descriptionUnlocked = description;
        this.descriptionEmpty = descriptionEmpty;

        updateDescription();
    }

    public ImmovabelItem(String name,String descriptionLocked,Inventory items,String CODE,String descriptionUnlocked,String descriptionEmpty) {
        super(name, descriptionLocked);

        this.items = (items != null) ? items : new Inventory();
        this.CAN_HOLD_ITEMS = true;

        this.IS_LOCKABLE = true;
        this.CODE = CODE;
        this.unlocked = false; 

        this.descriptionLocked = descriptionLocked;
        this.descriptionUnlocked = descriptionUnlocked;
        this.descriptionEmpty = descriptionEmpty;

        updateDescription();
    }

    private void updateDescription() {
        if (IS_LOCKABLE && !unlocked) {
            super.setDescription(descriptionLocked);
        } else {
            if (CAN_HOLD_ITEMS && items.isEmpty()) {
                super.setDescription(descriptionEmpty);
            } else {
                if (CAN_HOLD_ITEMS && !items.isEmpty()) {
                    super.setDescription(descriptionUnlocked + "\nEstá contido dentro deste objeto:\n"+ items.toString());
                } else {
                    super.setDescription(descriptionUnlocked);
                }
            }
        }
    }

    public boolean isHoldingItems() {
        return CAN_HOLD_ITEMS && !items.isEmpty();
    }

    public void clearItems() {
        if (!CAN_HOLD_ITEMS) return;
        items.clear();
        updateDescription();
    }

    public Inventory getItems() {
        return items;
    }

    public void unlock() {
        if (!IS_LOCKABLE) return;
        if (unlocked) return;

        this.unlocked = true;
        updateDescription();
    }

    public String getCODE() {
        return CODE;
    }

    public boolean isLocked() {
        return IS_LOCKABLE && !unlocked;
    }
}
