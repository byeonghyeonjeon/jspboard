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

import noticeboard.model.PostVO;
import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;

/**
 * Servlet implementation class BoardContentsServlet
 */
@WebServlet("/boardContent")
public class BoardContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardContentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		
		int board_nm = Integer.parseInt(request.getParameter("board_nm"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();	
		pageMap.put("board_nm", board_nm);
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		
		resultMap = noticeBoardService.getPostList(pageMap);
		
		String pageNav =(String) resultMap.get("pageNav");
		List<PostVO> postList = (List<PostVO>) resultMap.get("postList");	
		
		request.setAttribute("postList", postList);
		request.setAttribute("pageNav", pageNav);
		
		request.setAttribute("board_nm", board_nm);
		
		RequestDispatcher rd = request.getRequestDispatcher("NoticeBoard/contents.jsp");
		rd.forward(request, response);		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
