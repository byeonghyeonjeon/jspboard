/**
 * 
 */
package noticeboard.model;

import java.util.Date;

/**
 * BoardVO.java
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
public class BoardVO {
	
	private int board_nm;
	private String mem_id;
	private String board_title;
	private Date board_dt;
	private String board_yn;
	
	public int getBoard_nm() {
		return board_nm;
	}
	public void setBoard_nm(int board_nm) {
		this.board_nm = board_nm;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public Date getBoard_dt() {
		return board_dt;
	}
	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}
	public String getBoard_yn() {
		return board_yn;
	}
	public void setBoard_yn(String board_yn) {
		this.board_yn = board_yn;
	}
	
	

}
