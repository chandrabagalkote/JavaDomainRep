/*
CallableStatement
------------------------
This interface used to execute SQL stored procedures. JDBC provides a stored procedure SQL escape syntax that allows stored procedures to be called in a standard way for all RDBMSs.

CallableStatement cstmt=con.prepareCall("{call procedure_name(?,?)}");

Note: Parameter may be an OUT / IN parameter:
To pass value to IN parameter
cstmt.setInt(1,10);
OUT parameter:
cstmt.registerOutParameter(2,Types.INTEGER);
cstmt.execute();

SQL Procedure definition
---------------------------------
create or replace procedure empsal_proc(empno1 in number,  sal1 out number) AS
BEGIN
SELECT sal INTO sal1 from emp where empno=empno1;
END;
/
*/
// ProcedureTest.java

import java.sql.*;
public class ProcedureTest1
{
public static void main(String rags[]) throws Exception{
DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
Connection con=DriverManager.getConnection("jdbc:odbc:DSNOracle","scott","tiger");
CallableStatement cstmt=con.prepareCall("{call fibno(?)}");
cstmt.setInt(1,Integer.parseInt(rags[0]));
cstmt.registerOutParameter(2,Types.INTEGER);
boolean flag=cstmt.execute();

System.out.println(cstmt.getInt(1));
System.out.println("Procedure executed successfully...");
}
}
