/**
 * 
 */
package noticeboard.model;

import java.util.Date;

/**
 * PostVO.java
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
public class PostVO {
	private int post_nm;
	private int post_pnm;
	private int board_nm;
	private int post_gnm;
	private String mem_id;
	private String post_title;
	private String post_cnt;
	private Date post_dt;
	private String post_yn;
	
	public int getPost_gnm() {
		return post_gnm;
	}
	public void setPost_gnm(int post_gnm) {
		this.post_gnm = post_gnm;
	}
	public int getPost_nm() {
		return post_nm;
	}
	public void setPost_nm(int post_nm) {
		this.post_nm = post_nm;
	}
	public int getPost_pnm() {
		return post_pnm;
	}
	public void setPost_pnm(int post_pnm) {
		this.post_pnm = post_pnm;
	}
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
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_cnt() {
		return post_cnt;
	}
	public void setPost_cnt(String post_cnt) {
		this.post_cnt = post_cnt;
	}
	public Date getPost_dt() {
		return post_dt;
	}
	public void setPost_dt(Date post_dt) {
		this.post_dt = post_dt;
	}
	public String getPost_yn() {
		return post_yn;
	}
	public void setPost_yn(String post_yn) {
		this.post_yn = post_yn;
	}
	
	

}
