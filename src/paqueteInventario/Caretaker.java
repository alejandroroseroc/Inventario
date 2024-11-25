package paqueteInventario;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> mementoStack = new Stack<>();

    public void saveState(Inventory inventory) {
        mementoStack.push(inventory.save());
    }

    public void restoreState(Inventory inventory) {
        if (!mementoStack.isEmpty()) {
            inventory.restore(mementoStack.pop());
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }
}
