import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Cp
{
    static Connection conn;
    public static Connection connectionP()
    {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java2\\StudentApp\\student.db");
        }
        catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return conn;
    }
}
