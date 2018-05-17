/**
 * 
 */
package noticeboard.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import noticeboard.dao.NoticeBoardDao;
import noticeboard.dao.NoticeBoardDaoInf;
import noticeboard.model.BoardVO;
import noticeboard.model.CmtVO;
import noticeboard.model.PostVO;

/**
 * NoticeBoardService.java
 *
 * @author "J.B.H"
 * @since 2018. 5. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 12. "J.B.H" 최초 생성
 *
 * </pre>
 */
public class NoticeBoardService implements NoticeBoardServiceInf {
	private NoticeBoardDaoInf noticeBoardDao;
	private static NoticeBoardServiceInf noticeBoardServie = new NoticeBoardService();
	
	public static NoticeBoardServiceInf getInstance(){
		return noticeBoardServie;
	}
	
	private NoticeBoardService(){
		noticeBoardDao = NoticeBoardDao.getInstance();
	}
	
	/**
	* Method : checkLogin
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param loginMap
	* @return 성공시 1반환
	* Method 설명 : 로그인 확인 메서드 
	*/
	@Override
	public int checkLogin(Map<String, String> loginMap) {
		int result = 0;
		
		try {
			result = noticeBoardDao.checkLogin(loginMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	* Method : getAllBoardList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			boardList = noticeBoardDao.getAllBoardList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public int insertBoard(Map<String, String> BoardMap) {
		int result = 0;
		try {
			result = noticeBoardDao.insertBoard(BoardMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	* Method : makePageNav
	* 최초작성일 : 2018. 5. 4.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param page
	* @param userTotalCnt
	* Method 설명 : 페이지네이션 생성
	*/
	private String makePageNav(int page, int PostTotalCnt, int board_nm) {
		//Map<String, Integer> pageMap
		int pageTotal = (int)Math.ceil((double)PostTotalCnt/10L);
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("<ul class=\"pagination\">");
		pageNav.append("<li><a href='getUserPageList?page=1&pageSize=10' aria-label=\"Previous\">");
		pageNav.append("<span aria-hidden=\"true\">&laquo;</span>");
		pageNav.append("</a></li>");
		
		//pageTotalCnt
		for(int i = 1;i<=pageTotal;i++){
			if(i == page)
				pageNav.append("<li class ='actice'><a href=\"/boardContent?board_nm="+board_nm+"&page="+i+"&pageSize=10\">"+i+"</a></li>");			
			else
				pageNav.append("<li><a href=\"/noticeBoard/boardContent?board_nm="+board_nm+"&page="+i+"&pageSize=10\">"+i+"</a></li>");			
		}
		/*pageNav.append("<li><a href=\"#\">2</a></li>");
		pageNav.append("<li><a href=\"#\">3</a></li>");
		pageNav.append("<li><a href=\"#\">pageTotalCnt</a></li>");*/
		
		pageNav.append("<li><a href=\"/boardContent?board_nm="+board_nm+"&page="+page+1+"&pageSize=10\" aria-label=\"Next\">");
		pageNav.append("<span aria-hidden=\"true\">&raquo;</span>");
		pageNav.append("</a></li>");
		pageNav.append("</ul>");
		pageNav.append("</nav>");		
	
		return pageNav.toString();
	}
	
	/**
	* Method : getUserPageList
	* 최초작성일 : 2018. 5. 3.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 회원 페이지 list 조회
	*/
	@Override
	public Map<String, Object> getPostList(Map<String, Integer> pageMap) {
		//service(controller)-->service.xxxx()-->getUserPegeList(), dao.getUserTotalCnt()
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//Map<String, Integer> pageMap
		List<PostVO> postList = null;
		
		try {
			postList = noticeBoardDao.getPostList(pageMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int postTotalCnt = noticeBoardDao.getPostTotalCnt();
		
		String pageNav = makePageNav(pageMap.get("page"), postTotalCnt ,pageMap.get("board_nm"));
		
		resultMap.put("postList", postList);
		resultMap.put("pageNav", pageNav);		
		
		return resultMap;
	}

	/**
	* Method : getPostTotalCnt
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public int getPostTotalCnt() {
		int result = 0;	
		result = noticeBoardDao.getPostTotalCnt();
		
		return result;
	}

	/**
	* Method : getPostDetail
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param postMap
	* @return
	* @throws SQLException
	* Method 설명 :
	*/
	@Override
	public PostVO getPostDetail(Map<String, Integer> postMap)  {
		PostVO postVo = null;
		
		try {
			postVo = noticeBoardDao.getPostDetail(postMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return postVo;
	}

	/**
	* Method : getCmtList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param post_nm
	* @return
	* Method 설명 :
	*/
	@Override
	public List<CmtVO> getCmtList(int post_nm) {
		List<CmtVO> cmtList = new ArrayList<CmtVO>();
		cmtList = noticeBoardDao.getCmtList(post_nm);		
		return cmtList;		
	}

	/**
	* Method : insertCmt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param cmtMap
	* @return
	* @throws SQLException
	* Method 설명 :
	*/
	@Override
	public int insertCmt(CmtVO cmtVO) throws SQLException {
		int result = 0;
		try {
			result = noticeBoardDao.insertCmt(cmtVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	* Method : insertPost
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param postVO
	* @return
	* @throws SQLException
	* Method 설명 :
	*/
	@Override
	public int insertPost(PostVO postVO) throws SQLException {
		int result = 0;
		try {
			result = noticeBoardDao.insertPost(postVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	

	
	

}
