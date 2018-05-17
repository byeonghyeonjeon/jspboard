/**
 * 
 */
package noticeBoard.service;

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
import noticeboard.service.NoticeBoardService;
import noticeboard.service.NoticeBoardServiceInf;

import org.junit.Test;

/**
 * NoticeBoardServiceTest.java
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
public class NoticeBoardServiceTest {

	@Test
	public void checkLoginTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		String mem_id = "test";
		String mem_pass = "1234";
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("mem_id", mem_id);
		loginMap.put("mem_pass", mem_pass);
		
		int result = 0;
		
		/***When***/
	
		result= noticeBoardService.checkLogin(loginMap);
			
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
	}
	
	@Test
	public void getAllBoardListTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		/***When***/		
		boardList = noticeBoardService.getAllBoardList();
		
		/***Then***/
		assertNotNull(boardList);
		assertEquals(boardList.size(), 4);
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		int result = 0;
		String mem_id = "test";
		String board_title = "일정";
		
		Map<String, String> boardMap = new HashMap<String, String>();
		boardMap.put("mem_id", mem_id);
		boardMap.put("board_title", board_title);
		
		
		/***When***/
		result= noticeBoardService.insertBoard(boardMap);
		
		
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
	}
	
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		int PostTotalCnt = 0;

		/***When***/		
		PostTotalCnt = noticeBoardService.getPostTotalCnt();		

		/***Then***/
		assertNotNull(PostTotalCnt);
		assertEquals(PostTotalCnt, 11);		
	}
	
	
	@Test
	public void getPostListTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		List<PostVO> postVOList = new ArrayList<PostVO>();
		int board_nm = 1;
		int page = 1;
		int pageSize = 10;
		
		pageMap.put("board_nm", board_nm);
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		
		/***When***/
		postVOList = (List<PostVO>) noticeBoardService.getPostList(pageMap);
		

		/***Then***/
		assertNotNull(postVOList);
		assertEquals(postVOList.size(), 10);		
		assertEquals(postVOList.get(0).getBoard_nm(), 1);		
	}
	
	@Test
	public void getPostDetailTest() {
		
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		Map<String, Integer> postMap = new HashMap<String, Integer>();
		postMap.put("board_nm", 1);
		postMap.put("post_nm", 1);
		
		/***When***/		
		PostVO postVO = null;
		postVO = noticeBoardService.getPostDetail(postMap);		

		/***Then***/
		assertNotNull(postVO);
		assertEquals(postVO.getBoard_nm(), 1);		
	}
	
	@Test
	public void getCmtListTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
		Map<String, Integer> postMap = new HashMap<String, Integer>();
		int post_nm = 1;
		List<CmtVO> cmtList =null;
		/***When***/		
		cmtList = noticeBoardService.getCmtList(post_nm);	

		/***Then***/
		assertNotNull(cmtList);
		assertEquals(cmtList.size(), 5);		
	}
	@Test
	public void insertCmtTest() {
		/***Given***/
		NoticeBoardServiceInf noticeBoardService = NoticeBoardService.getInstance();
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
			result= noticeBoardService.insertCmt(cmtVO);
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
		NoticeBoardServiceInf noticeBoardService= NoticeBoardService.getInstance();
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
			result= noticeBoardService.insertPost(postVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/***Then***/
		assertNotNull(result);
		assertEquals(1, result);
	}


}
