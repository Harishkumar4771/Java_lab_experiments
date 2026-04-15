package experiment_7;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class FileHandling {

    static final String FILE_PATH = "Students.csv";
    static final String HEADER = "studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage";

    // ─────────────────────────────────────────────
    // Utility: read all lines (including header)
    // ─────────────────────────────────────────────
    static List<String> readAllLines() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        }
        return lines;
    }

    // ─────────────────────────────────────────────
    // Utility: write all lines back to file
    // ─────────────────────────────────────────────
    static void writeAllLines(List<String> lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (int i = 0; i < lines.size(); i++) {
                bw.write(lines.get(i));
                if (i < lines.size() - 1) bw.newLine();
            }
        }
    }

    // ─────────────────────────────────────────────
    // Utility: pretty-print the CSV
    // ─────────────────────────────────────────────
    static void displayFile(String title) throws IOException {
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────┐");
        System.out.printf ("│  %-71s│%n", title);
        System.out.println("├──────────┬──────────────────┬──────┬──────┬──────┬──────┬──────┬──────┬───────┤");
        System.out.printf ("│%-10s│%-18s│%-6s│%-6s│%-6s│%-6s│%-6s│%-6s│%-7s│%n",
                "studentId","name","branch","marks1","marks2","marks3","marks4","marks5","pct%");
        System.out.println("├──────────┼──────────────────┼──────┼──────┼──────┼──────┼──────┼──────┼───────┤");

        List<String> lines = readAllLines();
        for (int i = 1; i < lines.size(); i++) {   // skip header row
            String[] f = lines.get(i).split(",");
            System.out.printf("│%-10s│%-18s│%-6s│%-6s│%-6s│%-6s│%-6s│%-6s│%-7s│%n",
                    f[0], f[1], f[2], f[3], f[4], f[5], f[6], f[7], f[8]);
        }
        System.out.println("└──────────┴──────────────────┴──────┴──────┴──────┴──────┴──────┴──────┴───────┘");
    }

    // ─────────────────────────────────────────────
    // CREATE: initialise the file with header + 2 seed rows
    // ─────────────────────────────────────────────
    static void createFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            bw.write(HEADER);                                                     bw.newLine();
            bw.write("S001,Aarav Shah,CSE,88,76,92,85,90,0.00");                 bw.newLine();
            bw.write("S002,Priya Nair,ECE,74,68,80,72,78,0.00");
        }
        System.out.println("\n[CREATE] Students.csv created with header and 2 initial rows.");
        displayFile("After CREATE — initial file");
    }

    // ─────────────────────────────────────────────
    // CREATE (append): add 3 more rows, marks4/marks5 = 0
    // ─────────────────────────────────────────────
    static void appendThreeRows() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.newLine();
            bw.write("S003,Rohan Mehta,ME,65,70,60,0,0,0.00");    bw.newLine();
            bw.write("S004,Sneha Kulkarni,IT,80,85,78,0,0,0.00"); bw.newLine();
            bw.write("S005,Arjun Rao,EE,55,62,48,0,0,0.00");
        }
        System.out.println("\n[CREATE] 3 more rows appended (marks4 & marks5 initially 0).");
        displayFile("After appending 3 rows");
    }

    // ─────────────────────────────────────────────
    // READ: display the full file
    // ─────────────────────────────────────────────
    static void readFile() throws IOException {
        System.out.println("\n[READ] Reading all records from Students.csv …");
        displayFile("READ — all records");
    }

    // ─────────────────────────────────────────────
    // UPDATE: fill in marks4 & marks5 for the 3 new rows
    // ─────────────────────────────────────────────
    static void updateMarks() throws IOException {
        // Corrections: marks4, marks5
        Map<String, int[]> corrections = new LinkedHashMap<>();
        corrections.put("S003", new int[]{73, 68});
        corrections.put("S004", new int[]{91, 87});
        corrections.put("S005", new int[]{60, 55});

        List<String> lines = readAllLines();
        for (int i = 1; i < lines.size(); i++) {
            String[] f = lines.get(i).split(",");
            if (corrections.containsKey(f[0])) {
                int[] m = corrections.get(f[0]);
                f[6] = String.valueOf(m[0]);
                f[7] = String.valueOf(m[1]);
                lines.set(i, String.join(",", f));
            }
        }
        writeAllLines(lines);
        System.out.println("\n[UPDATE] marks4 and marks5 updated for S003, S004, S005.");
        displayFile("After UPDATE — marks4 & marks5 filled");
    }

    // ─────────────────────────────────────────────
    // Percentage calculation method
    // percentage = (sum of 5 marks / 500) * 100
    // ─────────────────────────────────────────────
    static double calculatePercentage(int m1, int m2, int m3, int m4, int m5) {
        return ((m1 + m2 + m3 + m4 + m5) / 500.0) * 100.0;
    }

    // ─────────────────────────────────────────────
    // UPDATE: recalculate & persist percentage for every student
    // ─────────────────────────────────────────────
    static void updatePercentages() throws IOException {
        List<String> lines = readAllLines();
        System.out.println("\n[UPDATE] Recalculating percentages …");
        for (int i = 1; i < lines.size(); i++) {
            String[] f = lines.get(i).split(",");
            int m1 = Integer.parseInt(f[3].trim());
            int m2 = Integer.parseInt(f[4].trim());
            int m3 = Integer.parseInt(f[5].trim());
            int m4 = Integer.parseInt(f[6].trim());
            int m5 = Integer.parseInt(f[7].trim());
            double pct = calculatePercentage(m1, m2, m3, m4, m5);
            f[8] = String.format("%.2f", pct);
            lines.set(i, String.join(",", f));
            System.out.printf("   %-20s → (%.0f+%.0f+%.0f+%.0f+%.0f)/500 × 100 = %.2f%%%n",
                    f[1], (double)m1, (double)m2, (double)m3, (double)m4, (double)m5, pct);
        }
        writeAllLines(lines);
        displayFile("After UPDATE — percentages calculated");
    }

    // ─────────────────────────────────────────────
    // DELETE: remove a row by studentId
    // ─────────────────────────────────────────────
    static void deleteRow(String studentId) throws IOException {
        List<String> lines = readAllLines();
        boolean found = false;
        Iterator<String> it = lines.iterator();
        it.next(); // skip header check — never delete header
        while (it.hasNext()) {
            String line = it.next();
            if (line.startsWith(studentId + ",")) {
                it.remove();
                found = true;
                break;
            }
        }
        if (found) {
            writeAllLines(lines);
            System.out.println("\n[DELETE] Row with studentId '" + studentId + "' deleted successfully.");
        } else {
            System.out.println("\n[DELETE] studentId '" + studentId + "' not found — nothing deleted.");
        }
        displayFile("After DELETE (removed " + studentId + ")");
    }

    // ─────────────────────────────────────────────
    // EXCEPTION DEMO: attempt to read a non-existent file
    // ─────────────────────────────────────────────
    static void demonstrateIOException() {
        System.out.println("\n[EXCEPTION DEMO] Attempting to read 'NonExistent.csv' …");
        try (BufferedReader br = new BufferedReader(new FileReader("NonExistent.csv"))) {
            br.readLine();
        } catch (IOException e) {
            System.out.println("   IOException caught!");
            System.out.println("   Type    : " + e.getClass().getName());
            System.out.println("   Message : " + e.getMessage());
            System.out.println("   This is expected — the file does not exist.");
        }
    }

    // ─────────────────────────────────────────────
    // MAIN
    // ─────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("══════════════════════════════════════════════════════════════");
        System.out.println("         STUDENTS CSV — FULL CRUD DEMONSTRATION               ");
        System.out.println("══════════════════════════════════════════════════════════════");

        try {
            // 1. CREATE — initialise file
            createFile();

            // 2. CREATE — append 3 rows with marks4/marks5 = 0
            appendThreeRows();

            // 3. READ — display full file
            readFile();

            // 4. UPDATE — fill missing marks
            updateMarks();

            // 5. UPDATE — calculate & save percentages
            updatePercentages();

            // 6. DELETE — remove student S003
            deleteRow("S003");

            // 7. EXCEPTION DEMO
            demonstrateIOException();

        } catch (IOException e) {
            System.err.println("\n[FATAL IOException] " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("                   CRUD OPERATIONS COMPLETE                   ");
        System.out.println("══════════════════════════════════════════════════════════════");
    }
}
