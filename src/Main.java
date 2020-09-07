import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public void dbConnect(String db_connect_string,
                          String db_userid,
                          String db_password)
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(db_connect_string,
                    db_userid, db_password);
            System.out.println("connected");
            Statement statement = conn.createStatement();
            String queryString = "select name from sys.tables";
            ResultSet rs = statement.executeQuery(queryString);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println("Query finished.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if(args == null || args.length < 3) {
            System.out.println("Usage: java Main jdbconnection userId password");
            System.out.println("example:  java Main jdbc:sqlserver://localhost:1433;databaseName=dbname SA pwd");
            System.exit(1);
        }
	    Main main = new Main();
        System.out.println("connection: " + args[0]);
        System.out.println("userId: " + args[1]);
        System.out.println("password: " + args[2]);
	    main.dbConnect(args[0], args[1], args[2]);
    }
}
