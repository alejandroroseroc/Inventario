package paqueteInventario;

public abstract class Drug {
    private String name;
    private int code;
    private double purchasePrice;
    private double sellingPrice;
    private int quantity;

    public Drug(String name, int code, double purchasePrice, double sellingPrice, int quantity) {
        this.name = name;
        this.code = code;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "nombre ='" + name + '\'' +
                ", codigo =" + code +
                ", Precio Costo =" + purchasePrice +
                ", Precio venta =" + sellingPrice +
                ", Unidades Disponibles =" + quantity +
                '}';
    }
}
