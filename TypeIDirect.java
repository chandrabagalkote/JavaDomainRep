import java.sql.*;

public class TypeIDirect{
public static void main(String args[]) throws Exception{
//step 1
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//step 2 -msaccess
Connection con=DriverManager.getConnection("jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=C:\\Employee.mdb");
//step 3
Statement stmt=con.createStatement();
//step 4
ResultSet rs=stmt.executeQuery("select * from empdetails");

while(rs.next()){
System.out.print(rs.getInt(1)+ " ");
System.out.print(rs.getString(2)+ " ");
System.out.println(rs.getInt(3)+" ");
System.out.println(rs.getString(4)+ " ");
}// while()
rs.close();
stmt.close();
con.close();
   }// main()
}// class