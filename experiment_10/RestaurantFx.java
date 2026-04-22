package experiment_10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import experiment_9.SQLCon;

public class RestaurantFx extends Application {
    private TextArea displayArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FoodieDB Manager - [Experiment 10]");

        // Create Menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Operations");

        MenuItem insertItem = new MenuItem("Insert 10 Records");
        MenuItem selectItem = new MenuItem("Select (Price <= 100)");
        MenuItem selectCafeJava = new MenuItem("Select 'Cafe Java' Items");
        MenuItem updateItem = new MenuItem("Update Prices (100 -> 200)");
        MenuItem deleteItem = new MenuItem("Delete 'P' Items");

        menu.getItems().addAll(insertItem, selectItem, selectCafeJava, updateItem, deleteItem);
        menuBar.getMenus().add(menu);

        // Event Handlers
        insertItem.setOnAction(e -> handleInsert());
        selectItem.setOnAction(e -> handleSelect("SELECT * FROM MenuItem WHERE Price <= 100"));
        selectCafeJava.setOnAction(e -> handleSelect("SELECT m.* FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE r.Name = 'Cafe Java'"));
        updateItem.setOnAction(e -> handleUpdate("UPDATE MenuItem SET Price = 200 WHERE Price <= 100"));
        deleteItem.setOnAction(e -> handleUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'"));

        // UI Layout
        displayArea.setEditable(false);
        VBox vBox = new VBox(menuBar, new Label("Results:"), displayArea);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleInsert() {
        try (Connection conn = SQLCon.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM MenuItem");
            stmt.executeUpdate("DELETE FROM Restaurant");

            // Insert Restaurants
            PreparedStatement psRes = conn.prepareStatement("INSERT INTO Restaurant VALUES (?, ?, ?)");
            for (int i = 1; i <= 10; i++) {
                psRes.setInt(1, i);
                psRes.setString(2, (i == 1) ? "Cafe Java" : "Bistro " + i);
                psRes.setString(3, "Location " + i);
                psRes.addBatch();
            }
            psRes.executeBatch();

            // Insert Menu Items
            PreparedStatement psMenu = conn.prepareStatement("INSERT INTO MenuItem VALUES (?, ?, ?, ?)");
            String[] names = {"Pizza", "Pasta", "Burger", "Soda", "Paneer", "Tea", "Coffee", "Fries", "Pickle", "Salad"};
            double[] prices = {250, 90, 150, 40, 180, 20, 30, 110, 15, 80};
            for (int i = 0; i < 10; i++) {
                psMenu.setInt(1, i + 1);
                psMenu.setString(2, names[i]);
                psMenu.setDouble(3, prices[i]);
                psMenu.setInt(4, (i % 10) + 1);
                psMenu.addBatch();
            }
            psMenu.executeBatch();
            displayArea.setText("Successfully inserted 10 records into both tables.");
        } catch (SQLException ex) {
            displayArea.setText("Error: " + ex.getMessage());
        }
    }

    private void handleSelect(String query) {
        try (Connection conn = SQLCon.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= cols; i++) {
                sb.append(String.format("%-15s", rsmd.getColumnName(i)));
            }
            sb.append("\n").append("-".repeat(cols * 15)).append("\n");

            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    sb.append(String.format("%-15s", rs.getString(i)));
                }
                sb.append("\n");
            }
            displayArea.setText(sb.toString());
        } catch (SQLException ex) {
            displayArea.setText("Error: " + ex.getMessage());
        }
    }

    private void handleUpdate(String sql) {
        try (Connection conn = SQLCon.getConnection()) {
            Statement stmt = conn.createStatement();
            int affected = stmt.executeUpdate(sql);
            displayArea.setText("Operation Successful.\nRows affected: " + affected);
        } catch (SQLException ex) {
            displayArea.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}