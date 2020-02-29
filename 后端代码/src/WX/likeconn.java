package WX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class likeconn {
	static final String URL="jdbc:mysql://localhost:3306/yhw";
	static final String USER="root";
	static final String password="123";
    static Connection conn;
    static Statement stat;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		conn=null;
		stat=null;
		conn=(Connection)DriverManager.getConnection(URL,USER,password);
		stat=conn.createStatement();
		String sql1="SELECT * FROM COLLECT";
		ResultSet rs=stat.executeQuery(sql1);
		wxtestServlet wx=new wxtestServlet();
		while(rs.next()){
			System.out.println("连接成功");
		}
		 try {
	          if (rs != null) {
	              rs.close();
	          }
	      } catch (SQLException e) {
	    	  System.out.println("MySQL操作错误");
	          e.printStackTrace();
	      } finally {
	          try {
	              if (stat != null) {
	                  stat.close();
	              }
	          } catch (SQLException e) {
	              e.printStackTrace();
	          } finally {
	              try {
	                  if (conn != null) {
	                      conn.close();
	                  }
	              } catch (SQLException e) {
	                  e.printStackTrace();
	              }
	          }
	          }
		 
	}
	public void addlike(Like like) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn=(Connection)DriverManager.getConnection(URL,USER,password);
		
		String sql = "INSERT INTO collect(area,value)"
				+ "VALUES(?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, like.getArea());
		pstmt.setString(2, like.getValue());
		
		pstmt.execute();
	}
}
