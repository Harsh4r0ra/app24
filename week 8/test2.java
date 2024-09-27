import java.sql.*;
import java.util.Scanner;

public class test2 {

    // SQLite Database URL (will create 'test.db' in the current directory)
    private static final String DB_URL = "jdbc:sqlite:test.db";

    // Establishes connection to SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTable() {
        String createStudentTable = """
                CREATE TABLE IF NOT EXISTS student (
                    roll_no INTEGER PRIMARY KEY,
                    name TEXT NOT NULL
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createStudentTable);
            System.out.println("Student table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertStudent(int rollNo, String name) {
        String sql = "INSERT INTO student(roll_no, name) VALUES(?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rollNo);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Student inserted: Roll No: " + rollNo + ", Name: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Retrieves and prints all students from the 'student' table
    public static void selectAllStudents() {
        String sql = "SELECT * FROM student";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nStudent List:");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("roll_no") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Updates an existing student's name based on their roll number
    public static void updateStudent(int rollNo, String newName) {
        String sql = "UPDATE student SET name = ? WHERE roll_no = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, rollNo);
            pstmt.executeUpdate();
            System.out.println("Student Roll No: " + rollNo + " updated with new Name: " + newName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Deletes a student record from the 'student' table using their roll number
    public static void deleteStudent(int rollNo) {
        String sql = "DELETE FROM student WHERE roll_no = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rollNo);
            pstmt.executeUpdate();
            System.out.println("Student with Roll No: " + rollNo + " deleted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Main method to demonstrate all operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createTable();
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Add Student
                    System.out.print("Enter Roll Number: ");
                    int rollNoToAdd = sc.nextInt();
                    System.out.print("Enter Student Name: ");
                    String nameToAdd = sc.next();
                    insertStudent(rollNoToAdd, nameToAdd);
                    break;

                case 2: // Update Student
                    System.out.print("Enter Roll Number of the student to update: ");
                    int rollNoToUpdate = sc.nextInt();
                    System.out.print("Enter new Name: ");
                    String newName = sc.next();
                    updateStudent(rollNoToUpdate, newName);
                    break;

                case 3: // Delete Student
                    System.out.print("Enter Roll Number of the student to delete: ");
                    int rollNoToDelete = sc.nextInt();
                    deleteStudent(rollNoToDelete);
                    break;

                case 4: // View All Students
                    selectAllStudents();
                    break;

                case 5: // Exit
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        sc.close(); // Close the scanner
    }
}
