package Common.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import Common.Dto.EmailCodeDto;
import Common.Service.MemberService;

/**
 * Servlet implementation class emailcodevalid
 */
@WebServlet("/emailcodevalid")
public class emailcodevalid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emailcodevalid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dd");
		EmailCodeDto dto = new EmailCodeDto();
		dto.setEmailcode(request.getParameter("emailcode"));
		MemberService Mdto = new MemberService();
		int result = Mdto.emailcodevaild(dto);
		System.out.println(result);
		
		ArrayList<Integer> resultList = new ArrayList<>();
		resultList.add(result);

		request.setAttribute("rlist", resultList);
        
        //타입을 json으로 바꿔줘야됨
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
       
        //DTO 타입의 어레이리스트를 json 형태로 바꿔주는 구문(라이브러리 필수, zip->jar 확장자명 꼭 확인)
        String gson = new Gson().toJson(Collections.singletonMap("resultList", resultList));

        try {
            //ajax로 리턴해주는 부분
            response.getWriter().write(gson);
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
		
	}

}
