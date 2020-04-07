import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemoOK {

    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        try {
            // load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // establish connection
            String url = "jdbc:postgresql://localhost:5432/okWildflowers";
            conn = DriverManager.getConnection(url, "postgres", "postgres");

            // query the database
            String sql = "select county from wildflowers where county='Cimarron'";
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            // print the result
            if (res != null) {
                while (res.next()) {
                    System.out.println("county: " + res.getString("county"));
                }
            }

            // clean up
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

