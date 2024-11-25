package paqueteInventario;

public class MedicationFactory extends DrugFatory{
	@Override
    public Drug createDrug(String name, int code, double purchasePrice, double sellingPrice, int quantity) {
        return new Medication(name, code, purchasePrice, sellingPrice, quantity);
    }

}
