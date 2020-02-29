package WX;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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

import org.apache.tomcat.jni.User;

import com.sun.net.httpserver.Authenticator.Result;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class tt
 */
@WebServlet("/tt")
public class tt extends HttpServlet {
//	static final String URL="jdbc:mysql://127.0.0.1:3306/yhw?useSSL=false";
	static final String URL="jdbc:mysql://localhost:3306/yhw";
	static final String USER="root";
	static final String password="123";
    static Connection conn;
    static Statement stat;
    static PrintWriter out ;
    Result result;
	private static final long serialVersionUID = 1L;
	String from;  
	String to;
    String car;
    String hotel;
    String ps;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tt() {
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

//        //获取微信小程序get的参数值并打印
//        from = request.getParameter("from");
//        byte f[]=from.getBytes("ISO-8859-1");
//        from=new String(f);
//        to = request.getParameter("to");
//        car = request.getParameter("car");
//        hotel = request.getParameter("hotel");
//        ps = request.getParameter("ps");
//        Booking user=new Booking();
//        user.setFrom(from);
//        user.setTo(to);
//        user.setCar(car);
//        user.setHotel(hotel);
//        user.setPs(ps);
//        System.out.println(from+'\t'+to+'\t'+car+'\t'+hotel+'\t'+ps);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		conn=(Connection)DriverManager.getConnection(URL,USER,password);
    		
//    		PrintWriter out = response.getWriter();
    		
    		
    		Statement statement = conn.createStatement();
    		String sql = "select * from note;";
    		ResultSet resultSet = statement.executeQuery(sql);
    		ArrayList<Booking> l=new ArrayList<Booking>();
    		Booking user=new Booking();
    		JSONArray js=new JSONArray();
    		JSONObject obj=new JSONObject();
    		
    		String sqlstart;
            String sqlend;
            String sqlcar;
            String sqlhotel;
            String sqlps;
            String sqltime;
            while (resultSet.next()) {
            	sqlstart = resultSet.getString("start");
            	sqlend = resultSet.getString("end");
            	sqlcar = resultSet.getString("car");
            	sqlhotel = resultSet.getString("hotel");
            	sqlps = resultSet.getString("ps");
            	sqltime=resultSet.getString("time");
            	
            	user.setFrom(sqlstart);
            	user.setTo(sqlend);
            	user.setCar(sqlcar);
            	user.setHotel(sqlhotel);
            	user.setPs(sqlps);
            	user.setTime(sqltime);
            	
            	l.add(user);
            	
            	obj.put("start", user.from);
            	obj.put("end", user.to);
            	obj.put("car", user.car);
            	obj.put("hotel", user.hotel);
            	obj.put("ps", user.ps);
            	obj.put("time", user.time);
            	js.add(obj);
//            	out.print(user.from+'\t'+user.to+'\t'+user.car+'\t'+user.hotel+'\t'+user.ps);

            	}
            	

            out=response.getWriter();
            out.append(js.toString());
            out.flush();
            out.close();
            System.out.println(js);
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
