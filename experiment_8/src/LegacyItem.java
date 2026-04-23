package experiment_8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class LegacyItem {
    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("Legacy Item ID: " + itemId + " | Description: " + description);
    }
}
