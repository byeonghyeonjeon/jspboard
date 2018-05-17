/**
 * 
 */
package noticeboard.model;

/**
 * AttacFileVO.java
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
public class AttacFileVO {
	private int attach_nm;
	private int post_nm;
	private String attach_path;
	
	public int getAttach_nm() {
		return attach_nm;
	}
	public void setAttach_nm(int attach_nm) {
		this.attach_nm = attach_nm;
	}
	public int getPost_nm() {
		return post_nm;
	}
	public void setPost_nm(int post_nm) {
		this.post_nm = post_nm;
	}
	public String getAttach_path() {
		return attach_path;
	}
	public void setAttach_path(String attach_path) {
		this.attach_path = attach_path;
	}
	

}
