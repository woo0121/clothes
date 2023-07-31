package Common.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Dto.EmailCodeDto;
import Common.Service.MemberService;

/**
 * Servlet implementation class emailchecker
 */
@WebServlet("/emailchecker")
public class emailchecker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public emailchecker() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("email"));
		EmailCodeDto Dto = new EmailCodeDto();
		Dto.setEmail(request.getParameter("email"));
		MemberService service = new MemberService();
		String email = request.getParameter("email");
		int result = service.emailchecker(Dto);
	
	}

}