package WX;

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

import com.sun.net.httpserver.Authenticator.Result;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class fruit
 */
@WebServlet("/fruit")
public class recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL="jdbc:mysql://localhost:3306/yhw";
	static final String USER="root";
	static final String password="123";
    static Connection conn;
    static Statement stat;
    static PrintWriter out ;
    Result result;
	String area;  
	String have;
	String value;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommend() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");

        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		conn=(Connection)DriverManager.getConnection(URL,USER,password);
    		
//    		PrintWriter out = response.getWriter();
    		
    		
    		
    		Statement statement = conn.createStatement();
    		fruit f=new fruit();
    		area = request.getParameter("message");   
    		f.setArea(area);
            System.out.println("�ص�:" + area);
    		
    		String sql = "select * from area where region='"+area+"';";
    		ResultSet resultSet = statement.executeQuery(sql);
    		ArrayList<Like> l=new ArrayList<Like>();
    		JSONArray jslike=new JSONArray();
    		JSONObject objlike=new JSONObject();
    		
    		
    		
    		String sqlhave;
            String sqlvalue;
            while (resultSet.next()) {
            	sqlhave = resultSet.getString("have");
            	sqlvalue = resultSet.getString("value");
            	
            	f.setHave(sqlhave);
            	f.setValue(sqlvalue);
//            	l.add(user);
            	
            	objlike.put("have", f.have);
            	objlike.put("area", f.area);
            	objlike.put("value", f.value);
            	jslike.add(objlike);
            	

            	}
        	
        	out=response.getWriter();
            out.append(jslike.toString());
        	out.flush();
        	System.out.println(jslike);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ����");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        /*������Ӧͷ����ajax�������*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
        area = request.getParameter("area");
        
        System.out.println("�ص�:" + area);
        try {
			this.doGet(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("����ʧ��");
			e.printStackTrace();
		}
        //����ֵ��΢��С����
        Writer out = response.getWriter();
        out.write("�����̨��");
	}

}
