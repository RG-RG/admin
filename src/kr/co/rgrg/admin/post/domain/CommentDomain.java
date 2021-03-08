package kr.co.rgrg.admin.post.domain;

public class CommentDomain {

	private int comm_num;
	private String id, comm_content, input_date, delete_flag;
	
	public int getComm_num() {
		return comm_num;
	}
	public String getId() {
		return id;
	}
	public String getComm_content() {
		return comm_content;
	}
	public String getInput_date() {
		return input_date;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	
}//CommentDomain
