package paqueteInventario;

abstract class DrugFatory {
	public abstract Drug createDrug(String name, int code, double purchasePrice, double sellingPrice, int quantity);
}
