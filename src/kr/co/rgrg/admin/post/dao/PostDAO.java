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
	 * 글 목록을 가져오는 일
	 * @param rVO
	 * @return
	 */
	public List<PostListDomain> selectPostList(RangeVO rVO){
		List<PostListDomain> list = null;
		return list;
	}//selectPostList
	
	/**
	 * 글 상세내용을 가져오는 일
	 * @param post_num
	 * @return
	 */
	public List<PostDetailDomain> selectPostDetail(int post_num){
		List<PostDetailDomain> list = null;
		return list;
	}//selectPostDetail
	
	/**
	 * 글 상세내용의 댓글을 가져오는 일
	 * @param rVO
	 * @return
	 */
	public List<CommentDomain> selectComment(RangeVO rVO){
		List<CommentDomain> list = null;
		return list;
	}//selectComment
	
	/**
	 * 글을 삭제하는 일
	 * @param post_num
	 * @return
	 */
	public int deletePost(int post_num){
		int cnt = 0;
		return cnt;
	}//deletePost
	
	/**
	 * 댓글을 삭제하는 일
	 * @param comm_num
	 * @return
	 */
	public int deleteComment(int comm_num) {
		int cnt = 0;
		return cnt;
	}//deleteComment
	
}//PostDAO
