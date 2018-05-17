package noticeboard.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import noticeboard.model.CmtVO;
import noticeboard.model.PostVO;
import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;

@WebServlet("/postDetail")
public class PostDetaliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PostDetaliServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		
		
		int board_nm = Integer.parseInt(request.getParameter("board_nm"));
		int post_nm = Integer.parseInt(request.getParameter("post_nm"));
		
		Map<String, Integer> postMap = new HashMap<String, Integer>();
		postMap.put("board_nm", board_nm);
		postMap.put("post_nm", post_nm);
		
		//게시글 정보가져오기
		PostVO postVO = noticeBoardService.getPostDetail(postMap);
		
		//댓글정보가져오기
		List<CmtVO> cmtList = noticeBoardService.getCmtList(post_nm);
		
		request.setAttribute("postVO", postVO);
		request.setAttribute("cmtList", cmtList);
			
		
		RequestDispatcher rd = request.getRequestDispatcher("NoticeBoard/postDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
