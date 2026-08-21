import java.sql.*;

public class StudentCRUD {

    // CREATE
    public static void createStudent(String name, String email, int age)
            throws SQLException {

        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";

        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setInt(3, age);

        stmt.executeUpdate();

        System.out.println("Student created successfully.");

        stmt.close();
        conn.close();
    }

    // READ
    public static void getStudents() throws SQLException {

        String sql = "SELECT * FROM students";

        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            System.out.println(
                "ID: " + rs.getInt("id") +
                ", Name: " + rs.getString("name") +
                ", Email: " + rs.getString("email") +
                ", Age: " + rs.getInt("age")
            );
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    // UPDATE
    public static void updateStudent(
            int id, String name, String email, int age)
            throws SQLException {

        String sql = "UPDATE students " +
                     "SET name = ?, email = ?, age = ? " +
                     "WHERE id = ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setInt(3, age);
        stmt.setInt(4, id);

        stmt.executeUpdate();

        System.out.println("Student updated successfully.");

        stmt.close();
        conn.close();
    }

    // DELETE
    public static void deleteStudent(int id) throws SQLException {

        String sql = "DELETE FROM students WHERE id = ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        System.out.println("Student deleted successfully.");

        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {

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

        // READ
        System.out.println("\nAfter Update:");
        getStudents();

        // DELETE
        deleteStudent(2);

        // READ
        System.out.println("\nAfter Delete:");
        getStudents();
    }
}