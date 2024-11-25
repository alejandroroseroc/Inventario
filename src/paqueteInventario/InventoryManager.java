package paqueteInventario;


public class InventoryManager {
    private final Inventory inventory = Inventory.getInstance();
    private final Caretaker caretaker = new Caretaker();

    public void addDrugToInventory(String name, int code, double purchasePrice, double sellingPrice, int quantity) {
        caretaker.saveState(inventory);
        Drug drug = new Medication(name, code, purchasePrice, sellingPrice, quantity);
        inventory.addDrug(drug);
    }

    public void findDrugByCode(int code) {
        Drug drug = inventory.findDrugByCode(code);
        if (drug != null) {
            System.out.println(drug);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    

    public void registerSale(int code, int quantity) {
        caretaker.saveState(inventory);
        Drug drug = inventory.findDrugByCode(code);
        if (drug != null && drug.getQuantity() >= quantity) {
            drug.setQuantity(drug.getQuantity() - quantity);
            System.out.println("Venta registrada.");
            
            inventory.notifyObservers();
        } else {
            System.out.println("Producto no encontrado o cantidad insuficiente.");
        }
    }

    public void undoLastAction() {
        caretaker.restoreState(inventory);
    }
}
