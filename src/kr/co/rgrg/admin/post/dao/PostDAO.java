package kr.co.rgrg.admin.post.dao;

import java.util.List;

import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.domain.CommentDomain;
import kr.co.rgrg.admin.post.domain.PostDetailDomain;
import kr.co.rgrg.admin.post.domain.PostListDomain;

public class PostDAO {

	private static PostDAO pDAO;
	
	private PostDAO() {
	}//PostDAO
	
	public static PostDAO getInstance() {
		if (pDAO == null) {
			pDAO = new PostDAO();
		}//end if
		return pDAO;
	}//getInstance
	
	/**
	 * �� ����� �������� ��
	 * @param rVO
	 * @return
	 */
	public List<PostListDomain> selectPostList(RangeVO rVO){
		List<PostListDomain> list = null;
		return list;
	}//selectPostList
	
	/**
	 * �� �󼼳����� �������� ��
	 * @param post_num
	 * @return
	 */
	public List<PostDetailDomain> selectPostDetail(int post_num){
		List<PostDetailDomain> list = null;
		return list;
	}//selectPostDetail
	
	/**
	 * �� �󼼳����� ����� �������� ��
	 * @param rVO
	 * @return
	 */
	public List<CommentDomain> selectComment(RangeVO rVO){
		List<CommentDomain> list = null;
		return list;
	}//selectComment
	
	/**
	 * ���� �����ϴ� ��
	 * @param post_num
	 * @return
	 */
	public int deletePost(int post_num){
		int cnt = 0;
		return cnt;
	}//deletePost
	
	/**
	 * ����� �����ϴ� ��
	 * @param comm_num
	 * @return
	 */
	public int deleteComment(int comm_num) {
		int cnt = 0;
		return cnt;
	}//deleteComment
	
}//PostDAO
