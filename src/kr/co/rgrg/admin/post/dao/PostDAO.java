package kr.co.rgrg.admin.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.rgrg.admin.dao.GetRgrgHandler;
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
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		list = ss.selectList("kr.co.rgrg.admin.post.selectPostList", rVO);
		ss.close();
		
		return list;
	}//selectPostList
	
	/**
	 * 글 상세내용을 가져오는 일
	 * @param post_num
	 * @return
	 */
	public PostDetailDomain selectPostDetail(int post_num){
		PostDetailDomain pdd = null;
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		pdd = ss.selectOne("kr.co.rgrg.admin.post.selectPostDetail", post_num);
		ss.close();
		
		return pdd;
	}//selectPostDetail
	
	/**
	 * 글 상세내용의 댓글을 가져오는 일
	 * @param rVO
	 * @return
	 */
	public List<CommentDomain> selectComment(RangeVO rVO){
		List<CommentDomain> list = null;
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		list = ss.selectList("kr.co.rgrg.admin.post.selectComment", rVO);
		ss.close();
		
		return list;
	}//selectComment
	
	/**
	 * 글을 삭제하는 일
	 * @param post_num
	 * @return
	 */
	public int deletePost(int post_num){
		int cnt = 0;
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		cnt = ss.update("kr.co.rgrg.admin.post.updatePostDelete", post_num);
		ss.commit();
		ss.close();
		
		return cnt;
	}//deletePost
	
	/**
	 * 댓글을 삭제하는 일
	 * @param comm_num
	 * @return
	 */
	public int deleteComment(int comm_num) {
		int cnt = 0;
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		cnt = ss.update("kr.co.rgrg.admin.post.updateCommentDelete", comm_num);
		ss.commit();
		ss.close();
		
		return cnt;
	}//deleteComment
	
}//PostDAO
