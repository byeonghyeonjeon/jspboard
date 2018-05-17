package noticeboard.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import noticeboard.model.CmtVO;
import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;

/**
 * Servlet implementation class CmtAddServlet
 */
@WebServlet("/cmtAdd")
public class CmtAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CmtAddServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    }
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		
		
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		HttpSession session = request.getSession();		
		String mem_id = (String) session.getAttribute("mem_id");		
		
		String cmt_cnt = request.getParameter("cmt_cnt");		
		int post_nm = Integer.parseInt(request.getParameter("post_nm"));
		int board_nm = Integer.parseInt(request.getParameter("board_nm"));
		
		CmtVO cmtVO = new CmtVO();
		cmtVO.setMem_id(mem_id);
		cmtVO.setCmt_cnt(cmt_cnt);
		cmtVO.setPost_nm(post_nm);
		
		try {
			noticeBoardService.insertCmt(cmtVO);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/postDetail?board_nm="+board_nm+"&post_nm="+post_nm);		
		
	}

}
