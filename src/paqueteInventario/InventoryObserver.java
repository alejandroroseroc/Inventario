package paqueteInventario;


public class InventoryObserver implements Observer {
    private String name;

    public InventoryObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Observer " + name + ": Inventario actualizado.");
    }
}