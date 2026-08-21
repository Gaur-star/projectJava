import java.sql.*;

public class StudentCRUD {

    // CREATE
    public static void createStudent(String name, String email, int age) {
        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student created successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void getStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Email: " + rs.getString("email") +
                    ", Age: " + rs.getInt("age")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateStudent(
            int id, String name, String email, int age) {

        String sql = """
                UPDATE students
                SET name = ?, email = ?, age = ?
                WHERE id = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // CREATE
        createStudent("Rahul", "rahul@gmail.com", 22);
        createStudent("Priya", "priya@gmail.com", 21);

        // READ
        System.out.println("\nStudents:");
        getStudents();

        // UPDATE
        updateStudent(
            1,
            "Rahul Sharma",
            "rahulsharma@gmail.com",
            23
        );

        // READ again
        System.out.println("\nAfter Update:");
        getStudents();

        // DELETE
        deleteStudent(2);

        // READ again
        System.out.println("\nAfter Delete:");
        getStudents();
    }
}