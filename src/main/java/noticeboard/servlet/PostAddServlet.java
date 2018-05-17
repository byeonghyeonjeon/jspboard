package noticeboard.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import noticeboard.model.PostVO;
import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;

/**
 * Servlet implementation class PostAddServlet
 */
@WebServlet("/postAdd")
public class PostAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_nm = Integer.parseInt(request.getParameter("board_nm"));		
		request.setAttribute("board_nm", board_nm);
		RequestDispatcher rd = request.getRequestDispatcher("NoticeBoard/postAdd.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		
		HttpSession session = request.getSession();
		PostVO postVO = new PostVO();
		
		String mem_id = (String) session.getAttribute("mem_id");
		int board_nm = Integer.parseInt(request.getParameter("board_nm"));
		String post_title = request.getParameter("post_title");
		String post_cnt =request.getParameter("post_cnt");
		//////////////
		
		int result_num =0;
		postVO.setBoard_nm(board_nm);
		postVO.setMem_id(mem_id);
		postVO.setPost_title(post_title);
		postVO.setPost_cnt(post_cnt);	
		
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		
		try {
			noticeBoardService.insertPost(postVO);
			result_num = postVO.getPost_nm();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/noticeBoard/postDetail?board_nm="+board_nm+"&post_nm="+result_num );
	}

}
