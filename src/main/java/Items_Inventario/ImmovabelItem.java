package Items_Inventario;

/**
 * Itens imóveis, estes poderão ter coisas dentro ou estar trancados.
 * @author Lara
 */

public class ImmovabelItem extends Item {

    private final boolean CAN_HOLD_ITEMS;
    private final Inventory ITEMS;

    private final boolean IS_LOCKABLE;
    private final String CODE;
    private boolean unlocked;

    private final String descriptionLocked;
    private final String descriptionUnlocked;
    private final String descriptionEmpty;

    public ImmovabelItem(String name, String description) {
        super(name, description);

        this.ITEMS = new Inventory(); 
        this.CAN_HOLD_ITEMS = false;

        this.IS_LOCKABLE = false;
        this.CODE = null;
        this.unlocked = true; 

        this.descriptionLocked = description;
        this.descriptionUnlocked = description;
        this.descriptionEmpty = description;

        updateDescription();
    }

    public ImmovabelItem(String name, String description, Inventory ITEMS, String descriptionEmpty) {
        super(name, description);

        this.ITEMS = (ITEMS != null) ? ITEMS : new Inventory();
        this.CAN_HOLD_ITEMS = true;

        this.IS_LOCKABLE = false;
        this.CODE = null;
        this.unlocked = true;

        this.descriptionLocked = description;    
        this.descriptionUnlocked = description;
        this.descriptionEmpty = descriptionEmpty;

        updateDescription();
    }

    public ImmovabelItem(String name,String descriptionLocked,Inventory ITEMS,String CODE,String descriptionUnlocked,String descriptionEmpty) {
        super(name, descriptionLocked);

        this.ITEMS = (ITEMS != null) ? ITEMS : new Inventory();
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
            if (CAN_HOLD_ITEMS && ITEMS.isEmpty()) {
                super.setDescription(descriptionEmpty);
            } else {
                if (CAN_HOLD_ITEMS && !ITEMS.isEmpty()) {
                    super.setDescription(descriptionUnlocked + "\nEstá contido dentro deste objeto:\n"+ ITEMS.toString());
                } else {
                    super.setDescription(descriptionUnlocked);
                }
            }
        }
    }

    public boolean isHoldingITEMS() {
        return CAN_HOLD_ITEMS && !ITEMS.isEmpty();
    }

    public void clearITEMS() {
        if (!CAN_HOLD_ITEMS) return;
        ITEMS.clear();
        updateDescription();
    }

    public Inventory getITEMS() {
        return ITEMS;
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
