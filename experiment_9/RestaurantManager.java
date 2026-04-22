package experiment_9;

import java.sql.*;

public class RestaurantManager {

    public static void main(String[] args) {
        try (Connection conn = SQLCon.getConnection()) {
            System.out.println("Connected to FoodieDB.");

            // 1. Insert 10 records in each table
            performInsertions(conn);

            // 2. Select MenuItems where price <= 100
            System.out.println("\n--- Items with Price <= 100 ---");
            printTable(conn, "SELECT * FROM MenuItem WHERE Price <= 100");

            // 3. Select items available in "Cafe Java"
            System.out.println("\n--- Items in 'Cafe Java' ---");
            String joinQuery = "SELECT m.* FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE r.Name = 'Cafe Java'";
            printTable(conn, joinQuery);

            // 4. Update price <= 100 to 200
            System.out.println("\n--- Updating prices <= 100 to 200 ---");
            executeChange(conn, "UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            printTable(conn, "SELECT * FROM MenuItem");

            // 5. Delete records where name starts with 'P'
            System.out.println("\n--- Deleting items starting with 'P' ---");
            executeChange(conn, "DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            printTable(conn, "SELECT * FROM MenuItem");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void performInsertions(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM MenuItem");
        stmt.executeUpdate("DELETE FROM Restaurant");

        // Insert 10 Restaurants
        PreparedStatement psRes = conn.prepareStatement("INSERT INTO Restaurant VALUES (?, ?, ?)");
        for (int i = 1; i <= 10; i++) {
            psRes.setInt(1, i);
            psRes.setString(2, (i == 1) ? "Cafe Java" : "Bistro " + i);
            psRes.setString(3, "Address " + i);
            psRes.addBatch();
        }
        psRes.executeBatch();

        // Insert 10 MenuItems
        PreparedStatement psMenu = conn.prepareStatement("INSERT INTO MenuItem VALUES (?, ?, ?, ?)");
        String[] names = {"Pizza", "Pasta", "Burger", "Soda", "Paneer", "Tea", "Coffee", "Fries", "Pickle", "Salad"};
        double[] prices = {250.0, 95.0, 150.0, 40.0, 180.0, 20.0, 30.0, 110.0, 15.0, 85.0};

        for (int i = 0; i < 10; i++) {
            psMenu.setInt(1, i + 1);
            psMenu.setString(2, names[i]);
            psMenu.setDouble(3, prices[i]);
            psMenu.setInt(4, (i % 10) + 1);
            psMenu.addBatch();
        }
        psMenu.executeBatch();
        System.out.println("Data insertion complete.");
    }

    private static void printTable(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();

        for (int i = 1; i <= cols; i++) {
            System.out.print(String.format("%-15s", rsmd.getColumnName(i)));
        }
        System.out.println("\n" + "=".repeat(cols * 15));

        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.print(String.format("%-15s", rs.getString(i)));
            }
            System.out.println();
        }
    }

    private static void executeChange(Connection conn, String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println("Rows affected: " + count);
    }
}