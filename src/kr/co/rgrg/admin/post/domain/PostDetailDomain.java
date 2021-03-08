package kr.co.rgrg.admin.post.domain;

public class PostDetailDomain {

	private int post_num;
	private String id, input_date, post_title, post_content;
	
	public int getPost_num() {
		return post_num;
	}
	public String getId() {
		return id;
	}
	public String getInput_date() {
		return input_date;
	}
	public String getPost_title() {
		return post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	
}//PostDetailDomain
