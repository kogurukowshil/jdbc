	import java.sql.*;
	
public class JDBC1 {

	    public static void main(String[] args) throws Exception
	    {
	    Connection con;
	    ResultSet rs;
	    Statement t;
	    PreparedStatement pr;
	    Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practise","root","root");
	    char ch=args[0].charAt(0);
	    switch(ch)
	    {
	        case 'R':
	            t=con.createStatement();
	            rs=t.executeQuery("select * from chemical");
	            while(rs.next())
	            {
	                System.out.println("AtomicWGHT="+rs.getString(2));
	                System.out.println("ChemicalName="+rs.getInt(1));
	                System.out.println("Symbol="+rs.getString(3));
	            }
	            break;
	        case 'D':
	            String name=args[1];
	            t=con.createStatement();
	            t.executeUpdate("delete from chemical where Name='"+name+"'");
	            break;
	        case 'U':
	            name=args[1];
	            int awt=Integer.parseInt(args[1]);
	            String sm=args[3];
	            t=con.createStatement();
	            t.executeUpdate("update Chemical set AutomicWGHT="+awt+",chemical_sym='"+sm+"' where name='"+name+"'");
	            break;
	    }
	    }

	  }

