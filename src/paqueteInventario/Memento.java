package paqueteInventario;

import java.util.List;

public class Memento {
    private final List<Drug> state;

    public Memento(List<Drug> state) {
        this.state = state;
    }

    public List<Drug> getState() {
        return state;
    }
}
