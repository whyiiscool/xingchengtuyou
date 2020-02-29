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
        /*������Ӧͷ����ajax�������*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
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
        System.out.println("���:" + from);
        System.out.println("Ŀ�ĵ�:" + to);
        System.out.println("��ͨ����:" + car);
        System.out.println("�ù�:" + hotel);
        System.out.println("��ʾ:" + ps);
        System.out.println("ʱ��"+time);
        test1 t=new test1();
        try {
			t.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("����ʧ��");
			e.printStackTrace();
		}
        //����ֵ��΢��С����
        Writer out = response.getWriter();
        out.write("�����̨��");
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
        System.out.println("���:" + from);
        System.out.println("Ŀ�ĵ�:" + to);
        System.out.println("��ͨ����:" + car);
        System.out.println("�ù�:" + hotel);
        System.out.println("��ʾ:" + ps);
        System.out.println("ʱ��:" + time);
        test1 t=new test1();
        try {
			t.addUser(user);
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
