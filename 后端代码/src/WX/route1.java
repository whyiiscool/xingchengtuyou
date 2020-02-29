package WX;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Authenticator.Result;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class route1
 */
@WebServlet("/route1")
public class route1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL="jdbc:mysql://localhost:3306/yhw";
	static final String USER="root";
	static final String password="123";
    static Connection conn;
    static Statement stat;
    static PrintWriter out ;
    String way;
    String sqlway;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public route1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GB2312");
		request.setCharacterEncoding("GB2312");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		conn=(Connection)DriverManager.getConnection(URL,USER,password);		
    		Statement statement = conn.createStatement();
    		
    		way = request.getParameter("wayShow");   
    		sqlway=way.replace("\n", " ");
    		
    		String sql = "select * from route where way = '"+sqlway+"'";
    		ResultSet resultSet = statement.executeQuery(sql);
    		ArrayList<Like> l=new ArrayList<Like>();
    		JSONArray jslike=new JSONArray();
    		JSONObject objlike=new JSONObject();
    		
    		

    		String day;
    		String text;
    		String sqlday;
            String sqlnum;
            String sqltext;
            while (resultSet.next()) {
            	sqlnum= resultSet.getString("num");
            	day = resultSet.getString("day");
            	sqlday=day.replace(" 无","  天");
            	text = resultSet.getString("text");
            	sqltext = text.replace(" ","\r\n");
            	
//            	l.add(user);
            	
            	objlike.put("day", sqlday);
            	objlike.put("num", sqlnum);
            	objlike.put("text", sqltext);
            	objlike.put("way", way);
            	
            	jslike.add(objlike);
            	

            	}
        	
        	out=response.getWriter();
            out.append(jslike.toString());
        	out.flush();
        	System.out.println(jslike);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("查询错误");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
