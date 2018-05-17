/**
 * 
 */
package noticeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import noticeboard.model.BoardVO;
import noticeboard.model.CmtVO;
import noticeboard.model.PostVO;

/**
 * NoticeBoardDaoInf.java
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
public interface NoticeBoardDaoInf {
	/**
	 * 
	* Method : checkLogin
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param loginMap
	* @return
	* @throws SQLException
	* Method 설명 :
	 */
	public int checkLogin(Map<String, String> loginMap) throws SQLException;
	
	/**
	 * 
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return board전체리스트 
	* Method 설명 :board 리스트 가져오기
	 */
	public List<BoardVO> getAllBoardList() throws SQLException;
	
	/**
	 * 
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return 성공하면 1반환
	* @throws SQLException
	* Method 설명 : board 추가하기
	 */
	public int insertBoard(Map<String, String> boardMap) throws SQLException;
	
	/**
	 * 
	* Method : getPostList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param board_nm
	* @return	List<BoardVO> 
	* @throws SQLException
	* Method 설명 : 게시판 번호로 내림차순한 PostList
	 */
	public List<PostVO> getPostList(Map<String, Integer> pageMap) throws SQLException;

	/**
	* Method : getPostTotalCnt
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	public int getPostTotalCnt();
	
	/**
	 * 
	* Method : getPostDetail
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param postMap
	* @return
	* @throws SQLException
	* Method 설명 : 선택한 게시물 정보가져오기 map key : board_nm, post_nm
	 */
	public PostVO getPostDetail(Map<String,Integer> postMap) throws SQLException;
	

	/**
	* Method : getCmtList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param post_nm
	* @return
	* Method 설명 :
	*/
	public List<CmtVO> getCmtList(int post_nm);
	
	/**
	 * 
	* Method : insertCmt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param cmtMap
	* @return
	* @throws SQLException
	* Method 설명 : 댓글 작성
	 */
	public int insertCmt(CmtVO cmtVO) throws SQLException;
	
	/**
	 * 
	* Method : insertPost
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param postVO
	* @return
	* @throws SQLException
	* Method 설명 : 게시글 작성
	 */
	public int insertPost(PostVO postVO) throws SQLException;
	
	

}
