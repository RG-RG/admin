package kr.co.rgrg.admin.analytics.domain;

/**
 * @author doyeon
 *
 */
public class MostLikePost {
	String post_num, post_title, id, like_cnt, view_cnt;

	public String getPost_num() {
		return post_num;
	}

	public String getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(String view_cnt) {
		this.view_cnt = view_cnt;
	}

	public void setPost_num(String post_num) {
		this.post_num = post_num;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(String like_cnt) {
		this.like_cnt = like_cnt;
	}
	
	
}
