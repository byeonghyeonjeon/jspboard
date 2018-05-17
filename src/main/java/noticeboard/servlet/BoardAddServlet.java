package noticeboard.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;


@WebServlet("/boardAdd")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardAddServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		
		int result = 0;
		Map<String, String> boardMap = new HashMap<String, String>();
		HttpSession session = request.getSession();
		
		String mem_id = (String) session.getAttribute("mem_id");		
		String board_title = request.getParameter("board_title");
		
		boardMap.put("mem_id", mem_id);
		boardMap.put("board_title", board_title);
		
		result = noticeBoardService.insertBoard(boardMap);
		
		response.sendRedirect("NoticeBoard/main.jsp");
		
	}

}
