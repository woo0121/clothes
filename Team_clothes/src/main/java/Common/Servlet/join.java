package Common.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Dto.MemberDto;
import Common.Service.MemberService;

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Member/join.jsp");
	     dispatcher.forward(request, response);





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html; charset=UTF-8");

	        String pwd = request.getParameter("pwd");
	        String name = request.getParameter("name");
	        String phone = request.getParameter("phone");
	        String addr = request.getParameter("addr");
	        String email = request.getParameter("email");

	        System.out.println(addr);

	        MemberDto mDto = new MemberDto();
	        mDto.setPwd(pwd);
	        mDto.setName(name);
	        mDto.setPhone(phone);
	        mDto.setAddr(addr);
	        mDto.setEmail(email);

	        MemberService service = new MemberService();
	        try {
				boolean result = service.memberJoin(mDto);
				 System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



	}

}
