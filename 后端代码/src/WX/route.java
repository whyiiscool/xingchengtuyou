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
 * Servlet implementation class route
 */
@WebServlet("/route")
public class route extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL="jdbc:mysql://localhost:3306/yhw";
	static final String USER="root";
	static final String password="123";
    static Connection conn;
    static Statement stat;
    static PrintWriter out ;
    String day;
    String type;
    Result result;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public route() {
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
    		
    		day = request.getParameter("day");   
    		type = request.getParameter("type");  
//            System.out.println("天数:" + day+"类型:" + type);
    		
    		String sql = "select * from route where day like '%"+day+"%'"+" and type like '%"+type+"%';";
    		ResultSet resultSet = statement.executeQuery(sql);
    		ArrayList<Like> l=new ArrayList<Like>();
    		JSONArray jslike=new JSONArray();
    		JSONObject objlike=new JSONObject();
    		
    		
    		String way;
    		String sqlway;
            String sqlspec;
            while (resultSet.next()) {
            	way = resultSet.getString("way");
            	sqlspec = resultSet.getString("spec");
            	sqlway=way.replace(" ","\n");
//            	l.add(user);
            	
            	objlike.put("day", day);
            	objlike.put("type", type);
            	objlike.put("way", sqlway);
            	objlike.put("spec", sqlspec);
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
