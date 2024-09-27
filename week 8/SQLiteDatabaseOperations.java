import java.sql.*;
import java.util.Scanner;
public class SQLiteDatabaseOperations {

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
        // 1. Create the 'student' table
        createTable();
        // 2. Insert sample student records    
        insertStudent(1, "Alice");
        insertStudent(2, "Bob");
        insertStudent(3, "Charlie");

        // 3. Retrieve and display all student records
        selectAllStudents();

        // 4. Update a student's name (e.g., change Bob to "Robert")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the roll number of the student you want to update: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the new name: ");
        String newName = sc.next();
        updateStudent(rollNo, newName);

        // 5. Delete a student record 
        System.out.println("Enter the roll number of the student you want to delete: ");
        int rollNoToDelete = sc.nextInt();
        deleteStudent(rollNoToDelete);

        // 6. Retrieve and display all student records again to see changes
        selectAllStudents();
    }
}
