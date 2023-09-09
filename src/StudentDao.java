import java.sql.*;

public class StudentDao {
    public static boolean insertStudentToDb(Student st) {

        boolean f=false;
        try {
            Connection conn = Cp.connectionP();
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS studentdata(sid INTEGER NOT NULL PRIMARY KEY, sname TEXT NOT NULL, sphone INTEGER,area TEXT NOT NULL)");
            String sql = "INSERT INTO studentdata(sid,sname,sphone,area) VALUES(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,st.getSid());
            pstmt.setString(2, st.getName());
            pstmt.setInt(3,st.getSphone());
            pstmt.setString(4,st.getArea());
            pstmt.executeUpdate();
            f=true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getErrorCode());
        }
        return f;

    }
    public static void displayData()
    {
        try {
            Connection conn = Cp.connectionP();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM studentdata");
            while (resultSet.next())
            {
                int id= resultSet.getInt(1);
                String name= resultSet.getString(2);
                int phone=resultSet.getInt(3);
                String area = resultSet.getString(4);

                System.out.println("id: "+id);
                System.out.println("Student's name: "+name);
                System.out.println("Student's Phone: "+phone);
                System.out.println("Student's area: "+area);
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getErrorCode());
        }

    }
    public static boolean deleteData(int number)
    {
        boolean f = false;
        try {
            Connection conn = Cp.connectionP();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM studentdata WHERE sid=?");
            pstmt.setInt(1, number);
            pstmt.executeUpdate();
            f = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    public static boolean updateData(Student st,int Oldid) {
        boolean f=false;
        try {
            Connection conn = Cp.connectionP();
            Statement statement = conn.createStatement();
            String sql = "UPDATE studentdata SET sid=?,sname=?,sphone=?,area=? WHERE sid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,st.getSid());
            pstmt.setString(2, st.getName());
            pstmt.setInt(3,st.getSphone());
            pstmt.setString(4,st.getArea());
            pstmt.setInt(5,Oldid);
            pstmt.executeUpdate();
            f=true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getErrorCode());
        }
        return f;
    }
}
