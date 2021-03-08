package kr.co.rgrg.admin.post.service;

import java.util.List;

import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.domain.CommentDomain;
import kr.co.rgrg.admin.post.domain.PostDetailDomain;
import kr.co.rgrg.admin.post.domain.PostListDomain;

public class PostService {

	/**
	 * �� ����� �������� ��
	 * @param rVO
	 * @return
	 */
	public List<PostListDomain> getPostList(RangeVO rVO) {
		List<PostListDomain> list = null;
		return list;
	}//getPostList
	
	/**
	 * �� �󼼳����� �������� ��
	 * @param post_num
	 * @return
	 */
	public List<PostDetailDomain> getPostDetail(int post_num){
		List<PostDetailDomain> list = null;
		return list;
	}//getPostDetail
	
	/**
	 * �� �󼼳����� ����� �������� ��
	 * @param rVO
	 * @return
	 */
	public List<CommentDomain> getCommentList(RangeVO rVO){
		List<CommentDomain> list = null;
		return list;
	}//getCommentList
	
	/**
	 * ���� �����ϴ� ��
	 * @param post_num
	 * @return
	 */
	public boolean removePost(int post_num) {
		boolean flag = false;
		return flag;
	}//removePost
	
	/**
	 * ����� �����ϴ� ��
	 * @param comm_num
	 * @return
	 */
	public boolean removeComment(int comm_num) {
		boolean flag = false;
		return flag;
	}//removeComment
	
}//PostService
