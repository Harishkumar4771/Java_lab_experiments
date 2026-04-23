package experiment_8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ProductAdapter implements Product{
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        // Delegates the call to the LegacyItem's print method
        legacyItem.print();
    }
}
