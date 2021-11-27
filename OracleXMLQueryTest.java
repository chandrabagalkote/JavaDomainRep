/*
Oracle XML SQL Utility (XSU)
-----------------------------------------
1) Retriving XML documents from DB
2) Inserting XML document into DB
SET CLASSPATH=%CLASSPATH%;d:\Oracle\Ora81\jlib\xmlparserv2.jar;d:\Oracle\Ora81\jlib\oraclexmlsql.jar
oracle.xml.sql.query.OracleXMLQuery - prepare XML document
oracle.xml.sql.dml.OracleXMLSave - insert new records of XML document into DB
*/

// OracleXMLQueryTest.java
import java.io.*;
import java.sql.*;
import oracle.xml.sql.query.*;

public class OracleXMLQueryTest{
public static void main(String rags[]) throws Exception{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:oci8:@ssi","scott","tiger");

OracleXMLQuery query=new OracleXMLQuery(con, "select * from emp");

String xmlString=query.getXMLString();
new PrintStream(new FileOutputStream("emp2.xml")).println(xmlString);
con.close();
}//main()
}// class