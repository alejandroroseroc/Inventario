package paqueteInventario;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Observable {
    private static Inventory instance;
    private final List<Drug> drugs;
    private final List<Observer> observers;

    private Inventory() {
        drugs = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addDrug(Drug drug) {
        drugs.add(drug);
        notifyObservers();
    }

    public void removeDrug(Drug drug) {
        drugs.remove(drug);
        notifyObservers();
    }

    public Drug findDrugByCode(int code) {
        for (Drug drug : drugs) {
            if (drug.getCode() == code) {
                return drug;
            }
        }
        return null;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public Memento save() {
        List<Drug> state = new ArrayList<>(drugs);
        return new Memento(state);
    }

    public void restore(Memento memento) {
        drugs.clear();
        drugs.addAll(memento.getState());
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

