
import java.sql.*;

public class Jdbc {

		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practise","root","root");
				System.out.println("connected");
				//PreparedStatement ps=con.prepareStatement("select * from employee");
				//PreparedStatement ps=con.prepareStatement("insert into employee values(6,'kowshil',7878.00,8)");
				PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
				//ps=con.prepareStatement("select * from employee");
				//ResultSet rs=ps.executeQuery();
				ps.setInt(1,105);
				ps.setString(2,"kowshil");
				ps.setFloat(3, 300.00f);
				ps.setInt(4, 6);
				ps.executeUpdate();
				ps.close();
				ps=con.prepareStatement("select * from employee");
				ResultSet rs=ps.executeQuery();
			
		//Statement st=con.createStatement();
//		ResultSet rs=st.executeQuery("select * from employee");
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getFloat(3));
		}
				
			
		}catch(SQLException|ClassNotFoundException se)
			{
				System.out.println(se);
			}
		
		}
	}


