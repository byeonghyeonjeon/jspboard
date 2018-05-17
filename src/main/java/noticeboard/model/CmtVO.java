/**
 * 
 */
package noticeboard.model;

import java.util.Date;

/**
 * CmtVO.java
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
public class CmtVO {
	private int cmt_nm;
	private int post_nm;
	private String mem_id;
	private String cmt_cnt;
	private Date cmt_dt;
	private String cmt_yn;
	
	public int getCmt_nm() {
		return cmt_nm;
	}
	public void setCmt_nm(int cmt_nm) {
		this.cmt_nm = cmt_nm;
	}
	public int getPost_nm() {
		return post_nm;
	}
	public void setPost_nm(int post_nm) {
		this.post_nm = post_nm;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCmt_cnt() {
		return cmt_cnt;
	}
	public void setCmt_cnt(String cmt_cnt) {
		this.cmt_cnt = cmt_cnt;
	}
	public Date getCmt_dt() {
		return cmt_dt;
	}
	public void setCmt_dt(Date cmt_dt) {
		this.cmt_dt = cmt_dt;
	}
	public String getCmt_yn() {
		return cmt_yn;
	}
	public void setCmt_yn(String cmt_yn) {
		this.cmt_yn = cmt_yn;
	}
	
	

}
