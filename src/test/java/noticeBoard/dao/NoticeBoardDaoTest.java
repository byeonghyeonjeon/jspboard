/**
 * 
 */
package noticeBoard.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import noticeboard.dao.NoticeBoardDao;
import noticeboard.dao.NoticeBoardDaoInf;
import noticeboard.model.BoardVO;
import noticeboard.model.CmtVO;
import noticeboard.model.PostVO;

import org.junit.Before;
import org.junit.Test;

/**
 * noticeBoardDaoTest.java
 *
 * @author "J.B.H"
 * @since 2018. 5. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 14. "J.B.H" 최초 생성
 *
 * </pre>
 */
public class NoticeBoardDaoTest {
	
	

	@Test
	public void checkLoginTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		int result = 0;
		String mem_id = "test";
		String mem_pass = "1234";
		
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("mem_id", mem_id);
		loginMap.put("mem_pass", mem_pass);
		
		
		/***When***/
		try {
			result= noticeBoardDao.checkLogin(loginMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
	}
	
	@Test
	public void getAllBoardListTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		/***When***/
		try {
			boardList = noticeBoardDao.getAllBoardList();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/***Then***/
		assertNotNull(boardList);
		assertEquals(boardList.size(), 4);		
	}
	
	
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		int PostTotalCnt = 0;

		/***When***/
		
		PostTotalCnt = noticeBoardDao.getPostTotalCnt();
		

		/***Then***/
		assertNotNull(PostTotalCnt);
		assertEquals(PostTotalCnt, 11);		
	}
	

	@Test
	public void insertBoardTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		int result = 0;
		String mem_id = "test";
		String board_title = "일정";
		
		Map<String, String> boardMap = new HashMap<String, String>();
		boardMap.put("mem_id", mem_id);
		boardMap.put("board_title", board_title);
		
		
		/***When***/
		try {
			result= noticeBoardDao.insertBoard(boardMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
	}
	
	@Test
	public void getPostListTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		List<PostVO> postVOList = new ArrayList<PostVO>();
		
		int board_nm = 1;
		int page = 11;
		int pageSize = 1;
		
		pageMap.put("board_nm", board_nm);
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		
		/***When***/
		try {
			postVOList = noticeBoardDao.getPostList(pageMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/***Then***/
		assertNotNull(postVOList);
		assertEquals(postVOList.size(), 1);		
		assertEquals(postVOList.get(0).getBoard_nm(), 1);		
	}
	
	@Test
	public void getPostDetailTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		Map<String, Integer> postMap = new HashMap<String, Integer>();
		postMap.put("board_nm", 1);
		postMap.put("post_nm", 1);
		/***When***/
		
		PostVO postVO = null;
		try {
			postVO = noticeBoardDao.getPostDetail(postMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		/***Then***/
		assertNotNull(postVO);
		assertEquals(postVO.getBoard_nm(), 1);		
	}
	
	@Test
	public void getCmtListTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		Map<String, Integer> postMap = new HashMap<String, Integer>();
		int post_nm = 1;
		List<CmtVO> cmtList =null;
		/***When***/		
		cmtList = noticeBoardDao.getCmtList(post_nm);	

		/***Then***/
		assertNotNull(cmtList);
		assertEquals(cmtList.size(), 5);		
		assertEquals(cmtList.get(1).getCmt_nm(), 4);		
	}
	
	@Test
	public void insertCmtTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		CmtVO cmtVO = new CmtVO();
		int result = 0;
		
		String mem_id = "test";
		String cmt_cnt = "일정";
		int post_nm = 1;
		
		cmtVO.setMem_id(mem_id);
		cmtVO.setCmt_cnt(cmt_cnt);
		cmtVO.setPost_nm(post_nm);
				
		/***When***/
		try {
			result= noticeBoardDao.insertCmt(cmtVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		NoticeBoardDaoInf noticeBoardDao = NoticeBoardDao.getInstance();
		PostVO postVO = new PostVO();
		int result = 0;
		
		String mem_id = "test";
		String post_cnt = "쉬고싶다";
		String post_title = "일정";
		int board_nm = 1;
		
		postVO.setBoard_nm(board_nm);
		postVO.setPost_title(post_title);	
		
		postVO.setMem_id(mem_id);
		postVO.setPost_cnt(post_cnt);
				
		/***When***/
		try {
			result= noticeBoardDao.insertPost(postVO);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
		assertEquals(postVO.getPost_nm(), 31);
	}


}
