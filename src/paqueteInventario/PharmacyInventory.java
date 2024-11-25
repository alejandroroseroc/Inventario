package paqueteInventario;


import java.util.Scanner;

public class PharmacyInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();
        InventoryObserver observer1 = new InventoryObserver("Observer1");
        InventoryObserver observer2 = new InventoryObserver("Observer2");

        Inventory.getInstance().addObserver(observer1);
        Inventory.getInstance().addObserver(observer2);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Buscar producto por código");
            System.out.println("3. Registrar venta de producto");
            System.out.println("4. Deshacer última acción");
            System.out.println("5. Salir");
            System.out.print("Ingrese su elección: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del medicamento: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese el código del medicamento: ");
                    int code = scanner.nextInt();
                    System.out.print("Ingrese el precio de compra del medicamento: ");
                    double purchasePrice = scanner.nextDouble();
                    System.out.print("Ingrese el precio de venta del medicamento: ");
                    double sellingPrice = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad de unidades: ");
                    int quantity = scanner.nextInt();

                    inventoryManager.addDrugToInventory(name, code, purchasePrice, sellingPrice, quantity);
                    System.out.println("Producto agregado al inventario.");
                    break;
                case 2:
                    System.out.print("Ingrese el código del medicamento: ");
                    int searchCode = scanner.nextInt();
                    inventoryManager.findDrugByCode(searchCode);
                    break;
                case 3:
                    System.out.print("Ingrese el código del medicamento: ");
                    int saleCode = scanner.nextInt();
                    System.out.print("Ingrese la cantidad vendida: ");
                    int saleQuantity = scanner.nextInt();
                    inventoryManager.registerSale(saleCode, saleQuantity);
                    break;
                case 4:
                    inventoryManager.undoLastAction();
                    System.out.println("Última acción deshecha.");
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el sistema de inventario de la droguería.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }
}


