/**
 * 
 */
package noticeboard.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import noticeboard.model.BoardVO;
import noticeboard.model.CmtVO;
import noticeboard.model.PostVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * NoticeBoardDao.java
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
public class NoticeBoardDao implements NoticeBoardDaoInf {
	//mybatis용
	private SqlSessionFactory sqlSessionFactory;
	
	//싱글톤
	private static NoticeBoardDaoInf noticeBoardDao = new NoticeBoardDao();
	
	//dao호출
	public static NoticeBoardDaoInf getInstance(){
		return noticeBoardDao;
	}	
	
	//기본 생성자
	public NoticeBoardDao(){		
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;		
		try {
			inputStream = Resources.getResourceAsStream(resource);			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/**
	* Method : checkLogin
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param loginMap
	* @return 로그인 성공시 1 반환
	* @throws SQLException
	* Method 설명 : 로그인 확인 메서드
	*/
	@Override
	public int checkLogin(Map<String, String> loginMap) throws SQLException {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("member.checkLogin", loginMap);				
		sqlSession.close();
		
		return result;
	}

	/**
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return	board전체리스트 
	* @throws SQLException
	* Method 설명 :board 리스트 가져오기
	*/
	@Override
	public List<BoardVO> getAllBoardList() throws SQLException {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("member.getAllBoardList");				
		sqlSession.close();
		
		return boardList;
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @return
	* @throws SQLException
	* Method 설명 :
	*/
	@Override
	public int insertBoard(Map<String, String> BoardMap) throws SQLException {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("member.insertBoard", BoardMap);				
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	//-------------------------------------------------------------------------------------------

	/**
	* Method : getPostList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "J.B.H"
	* 변경이력 :
	* @param pageMap
	* @return
	* @throws SQLException
	* Method 설명 : 10개씩 가져오기
	*/
	@Override
	public List<PostVO> getPostList(Map<String, Integer> pageMap) throws SQLException {
		List<PostVO> postList = new ArrayList<PostVO>();		
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		postList = sqlSession.selectList("member.getPostList", pageMap);				
		sqlSession.close();
		
		return postList;		
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = (Integer)sqlSession.selectOne("member.getPostTotalCnt");				
		sqlSession.close();
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
	public PostVO getPostDetail(Map<String, Integer> postMap) throws SQLException {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PostVO postVO  =(PostVO)sqlSession.selectOne("member.getPostDetail", postMap);				
		sqlSession.close();
		
		return postVO;	
		
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		cmtList=sqlSession.selectList("member.getCmtList", post_nm);
		
		sqlSession.close();
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("member.insertCmt", cmtVO);
		
		sqlSession.commit();
		sqlSession.close();
		
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("member.insertPost", postVO);
		
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}

}
