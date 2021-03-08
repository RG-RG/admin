package kr.co.rgrg.admin.post.domain;

public class PostListDomain {
	
	private int post_num;
	private String id, post_title, delete_flag, input_date;
	
	public int getPost_num() {
		return post_num;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPost_title() {
		return post_title;
	}
	
	public String getDelete_flag() {
		return delete_flag;
	}
	
	public String getInput_date() {
		return input_date;
	}
	
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	
}//PostListDomain
