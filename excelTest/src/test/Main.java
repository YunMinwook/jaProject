package test;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//db테이블 이름 구하기
public class Main {
  public static void main(String[] args) throws Exception {
    Connection conn = getConnection();
    Statement st = conn.createStatement();

//    st.executeUpdate("create table survey (id int,myURL CHAR);");
   
    getTables(conn);
   
//    st.close();
    conn.close();
  }

  public static void getTables(Connection conn) throws Exception {
    String TABLE_NAME = "TABLE_NAME";
//    String TABLE_SCHEMA = "TABLE_SCHEM";
    String[] TABLE_TYPES = {"TABLE"};
    DatabaseMetaData dbmd = conn.getMetaData();

    ResultSet tables = dbmd.getTables(null, null, null, TABLE_TYPES);
    while (tables.next()) {
      System.out.println(tables.getString(TABLE_NAME));
//          System.out.println(tables.getString(TABLE_SCHEMA));
    }
  }

  private static Connection getConnection() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/jspbookdb";
	String user = "root";
	String password = "1234";

	return DriverManager.getConnection(url, user, password);
  }
}