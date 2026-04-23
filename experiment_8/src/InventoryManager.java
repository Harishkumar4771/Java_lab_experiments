package experiment_8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class InventoryManager {
    InventoryManager inventoryManager = InventoryManager.getInstance();

    // Create new products
    Product newProd1 = new NewProduct("Wireless Keyboard");
    Product newProd2 = new NewProduct("Optical Mouse");

    // Create legacy items and wrap them using the adapter
    LegacyItem oldMonitor = new LegacyItem(1001, "CRT Monitor");
    Product adaptedLegacyProd = new ProductAdapter(oldMonitor);

    LegacyItem oldPrinter = new LegacyItem(1002, "Dot Matrix Printer");
    Product adaptedLegacyProd2 = new ProductAdapter(oldPrinter);

    // Add all products to the inventory manager
        inventoryManager.addProduct(newProd1);
        inventoryManager.addProduct(newProd2);
        inventoryManager.addProduct(adaptedLegacyProd);
        inventoryManager.addProduct(adaptedLegacyProd2);

        System.out.println("--- Inventory Details ---");

    // Iterate through the inventory using the Iterator pattern
    Iterator<Product> iterator = inventoryManager.returnInventory();
        while (iterator.hasNext()) {
        Product currentProduct = iterator.next();
        currentProduct.displayDetails();
    }
}
}
