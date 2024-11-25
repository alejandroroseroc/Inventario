package paqueteInventario;

public class Medication extends Drug {
    public Medication(String name, int code, double purchasePrice, double sellingPrice, int quantity) {
        super(name, code, purchasePrice, sellingPrice, quantity);
    }
}