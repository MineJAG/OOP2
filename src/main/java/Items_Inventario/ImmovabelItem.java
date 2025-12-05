package Items_Inventario;

public class ImmovabelItem extends Item {

    // --- capacidade de conter items ---
    private final boolean CAN_HOLD_ITEMS;
    private final Inventory items;   // NUNCA é null

    // --- lock / código ---
    private final boolean IS_LOCKABLE;
    private final String CODE;       // pode ser null se não tiver código
    private boolean unlocked;        // estado atual

    // --- descrições base (sem lista de items colada) ---
    private final String descriptionLocked;
    private final String descriptionUnlocked;
    private final String descriptionEmpty;

    // =========================
    //      CONSTRUTORES
    // =========================

    // 1) Só um item, não guarda nada, não é trancável
    public ImmovabelItem(String name, String description) {
        super(name, description);

        this.items = new Inventory();      // inventário vazio, nunca null
        this.CAN_HOLD_ITEMS = false;

        this.IS_LOCKABLE = false;
        this.CODE = null;
        this.unlocked = true;             // irrelevante, não é lockable

        this.descriptionLocked = description;
        this.descriptionUnlocked = description;
        this.descriptionEmpty = description;

        updateDescription();
    }

    // 2) Aberto e contém itens, não é trancável
    public ImmovabelItem(String name, String description, Inventory items, String descriptionEmpty) {
        super(name, description);

        this.items = (items != null) ? items : new Inventory();
        this.CAN_HOLD_ITEMS = true;

        this.IS_LOCKABLE = false;
        this.CODE = null;
        this.unlocked = true;

        this.descriptionLocked = description;       // não usados, mas coerentes
        this.descriptionUnlocked = description;
        this.descriptionEmpty = descriptionEmpty;

        updateDescription();
    }

    // 3) Pode ser trancado (com ou sem código) e conter items
    //    Se CODE == null, significa: tranca sem código, outro sistema qualquer.
    public ImmovabelItem(String name,String descriptionLocked,Inventory items,String CODE,String descriptionUnlocked,String descriptionEmpty) {
        super(name, descriptionLocked);

        this.items = (items != null) ? items : new Inventory();
        this.CAN_HOLD_ITEMS = true;

        this.IS_LOCKABLE = true;
        this.CODE = CODE;
        this.unlocked = false;                  // começa trancado

        this.descriptionLocked = descriptionLocked;
        this.descriptionUnlocked = descriptionUnlocked;
        this.descriptionEmpty = descriptionEmpty;

        updateDescription();
    }

    // =========================
    //   LÓGICA INTERNA (privada)
    // =========================

    /**
     * Atualiza a description (de Item) com base no estado:
     * - locked/unlocked
     * - vazio/com itens
     * E depois acrescenta a lista de itens, se existirem.
     */
    private void updateDescription() {
        if (IS_LOCKABLE && !unlocked) {
            // está trancado
            super.setDescription(descriptionLocked);
        } else {
            // não está trancado (ou nem é lockable)
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

    // =========================
    //        API PÚBLICA
    // =========================

    // --- container ---

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

    // --- lock ---

    /**
     * No teu código original, unlock() não recebia código.
     * Assumo que validas o código fora, e só chamas unlock() se estiver correto.
     */
    public void unlock() {
        if (!IS_LOCKABLE) return;
        if (unlocked) return;

        this.unlocked = true;
        updateDescription();
    }

    public String getCODE() {
        return CODE;
    }

    // (se quiseres, podes também expor isLocked())
    public boolean isLocked() {
        return IS_LOCKABLE && !unlocked;
    }
}
