package WX;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class wx
 */
@WebServlet("/wx")
public class wxtestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String from;  
	String to;
    String car;
    String hotel;
    String ps;
    String time;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wxtestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        from = request.getParameter("from");
        to = request.getParameter("to");
        car = request.getParameter("car");
        hotel = request.getParameter("hotel");
        ps = request.getParameter("ps");
        time=request.getParameter("time");
        Booking user=new Booking();
        user.setFrom(from);
        user.setTo(to);
        user.setCar(car);
        user.setHotel(hotel);
        user.setPs(ps);
        user.setTime(time);
        System.out.println("起点:" + from);
        System.out.println("目的地:" + to);
        System.out.println("交通工具:" + car);
        System.out.println("旅馆:" + hotel);
        System.out.println("提示:" + ps);
        System.out.println("时间"+time);
        test1 t=new test1();
        try {
			t.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("增加失败");
			e.printStackTrace();
		}
        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write("进入后台了");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        from = request.getParameter("from");
        to = request.getParameter("to");
        car = request.getParameter("car");
        hotel = request.getParameter("hotel");
        ps = request.getParameter("ps");
        time=request.getParameter("time");
        Booking user=new Booking();
        user.setFrom(from);
        user.setTo(to);
        user.setCar(car);
        user.setHotel(hotel);
        user.setPs(ps);
        user.setTime(time);
        System.out.println("起点:" + from);
        System.out.println("目的地:" + to);
        System.out.println("交通工具:" + car);
        System.out.println("旅馆:" + hotel);
        System.out.println("提示:" + ps);
        System.out.println("时间:" + time);
        test1 t=new test1();
        try {
			t.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("增加失败");
			e.printStackTrace();
		}
        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write("进入后台了");

	}
	

}
