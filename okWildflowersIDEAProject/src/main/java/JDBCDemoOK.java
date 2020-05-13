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
           // String url = "jdbc:postgresql://localhost:5432/okwildflowers";
            String url = "postgres://zpxhyiszlihrzk:d8071070280d011e26ffa689ac4946852dd0a76c1f3887361653b8f55f4055da@ec2-18-235-20-228.compute-1.amazonaws.com:5432/d5lucrbuppa2h7";
            // d5lucrbuppa2h7 database name for HEROKU, local host not longer works with this connected.
            conn = DriverManager.getConnection(url, "postgres", "admin");

            // query the database
            String sql = "select * from wildflower where county='Osage'";
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            // print the result
            if (res != null) {
                while (res.next()) {
                    System.out.println("common name: " + res.getString("common_name"));
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
