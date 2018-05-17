package noticeboard.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import noticeboard.model.BoardVO;
import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		int result = 0;
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("mem_id", mem_id);
		loginMap.put("mem_pass", mem_pass);
		
		
		
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		
		result = noticeBoardService.checkLogin(loginMap);
		noticeBoardService.getAllBoardList();
		
		if(result == 1){
			
			//보류 session으로 교체할지 ??!!
			request.setAttribute("mem_id", mem_id);
			request.setAttribute("mem_pass", mem_pass);
			
			
			//Board목록가져오기
			HttpSession session = request.getSession();
			List<BoardVO> boardList = new ArrayList<BoardVO>();
			boardList = noticeBoardService.getAllBoardList();			
			session.setAttribute("boardList", boardList);
			
			//아이디와 비밀번호 Map으로 보내기
			session.setAttribute("mem_id", mem_id);
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("NoticeBoard/main.jsp");		
			rd.forward(request, response);
			
		}else if (result == 0){
			response.sendRedirect("NoticeBoard/login.jsp");			
		}else{
			
		}
		
	}

}
