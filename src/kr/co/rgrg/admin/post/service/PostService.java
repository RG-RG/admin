package kr.co.rgrg.admin.post.service;

import java.util.List;

import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.dao.PostDAO;
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
		
		PostDAO pDAO = PostDAO.getInstance();
		list = pDAO.selectPostList(rVO);
		
		return list;
	}//getPostList
	
	/**
	 * �� �󼼳����� �������� ��
	 * @param post_num
	 * @return
	 */
	public PostDetailDomain getPostDetail(int post_num){
		PostDetailDomain pdd = null;
		
		PostDAO pDAO = PostDAO.getInstance();
		pdd = pDAO.selectPostDetail(post_num);
		
		return pdd;
	}//getPostDetail
	
	/**
	 * �� �󼼳����� ����� �������� ��
	 * @param rVO
	 * @return
	 */
	public List<CommentDomain> getCommentList(RangeVO rVO){
		List<CommentDomain> list = null;
		
		PostDAO pDAO = PostDAO.getInstance();
		list = pDAO.selectComment(rVO);
		
		return list;
	}//getCommentList
	
	/**
	 * ���� �����ϴ� ��
	 * @param post_num
	 * @return
	 */
	public boolean removePost(int post_num) {
		boolean flag = false;
		
		PostDAO pDAO = PostDAO.getInstance();
		flag = pDAO.deletePost(post_num) > 0;
		
		return flag;
	}//removePost
	
	/**
	 * ����� �����ϴ� ��
	 * @param comm_num
	 * @return
	 */
	public boolean removeComment(int comm_num) {
		boolean flag = false;
		
		PostDAO pDAO = PostDAO.getInstance();
		flag = pDAO.deleteComment(comm_num) > 0;
		
		return flag;
	}//removeComment
	
}//PostService
