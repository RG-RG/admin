package kr.co.rgrg.admin.post.service;

import java.util.List;

import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.domain.CommentDomain;
import kr.co.rgrg.admin.post.domain.PostDetailDomain;
import kr.co.rgrg.admin.post.domain.PostListDomain;

public class PostService {

	/**
	 * 글 목록을 가져오는 일
	 * @param rVO
	 * @return
	 */
	public List<PostListDomain> getPostList(RangeVO rVO) {
		List<PostListDomain> list = null;
		return list;
	}//getPostList
	
	/**
	 * 글 상세내용을 가져오는 일
	 * @param post_num
	 * @return
	 */
	public List<PostDetailDomain> getPostDetail(int post_num){
		List<PostDetailDomain> list = null;
		return list;
	}//getPostDetail
	
	/**
	 * 글 상세내용의 댓글을 가져오는 일
	 * @param rVO
	 * @return
	 */
	public List<CommentDomain> getCommentList(RangeVO rVO){
		List<CommentDomain> list = null;
		return list;
	}//getCommentList
	
	/**
	 * 글을 삭제하는 일
	 * @param post_num
	 * @return
	 */
	public boolean removePost(int post_num) {
		boolean flag = false;
		return flag;
	}//removePost
	
	/**
	 * 댓글을 삭제하는 일
	 * @param comm_num
	 * @return
	 */
	public boolean removeComment(int comm_num) {
		boolean flag = false;
		return flag;
	}//removeComment
	
}//PostService
