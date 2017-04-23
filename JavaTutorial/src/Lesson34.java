import java.sql.*;


public class Lesson34 {
    public static void main(String[] args) {
        Connection connection = null;
        String user = "learn-java";
        String password = "learn-java";
        String dbUrl = "jdbc:mysql://localhost:3306/learn_java";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, password);

            Statement cursor = connection.createStatement();
            String queryset = "SELECT * FROM clients";

            ResultSet rows = cursor.executeQuery(queryset);

            while(rows.next()) {
                System.out.print(rows.getString("firstname") + " ");
                System.out.println(rows.getString("email"));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    } // END OF main
} // END OF Lesson34 CLASS
