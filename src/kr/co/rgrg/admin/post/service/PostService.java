package kr.co.rgrg.admin.post.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.rgrg.admin.pagination.PaginationService;
import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.pagination.TotalCntVO;
import kr.co.rgrg.admin.post.dao.PostDAO;
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
		
		PostDAO pDAO = PostDAO.getInstance();
		list = pDAO.selectPostList(rVO);
		
		return list;
	}//getPostList
	
	/**
	 * 글 상세내용을 가져오는 일
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
	 * 글 상세내용의 댓글을 가져오는 일
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
	 * 글 상세내용의 댓글 페이지네이션
	 * @param current_page
	 * @param post_num
	 * @return
	 */
	public String moveCommentList(int current_page, String post_num){
		JSONObject json = new JSONObject();
		
		RangeVO rVO = new RangeVO(current_page, "POST_NUM", post_num);
		List<CommentDomain> list = null;
		PostDAO pDAO = PostDAO.getInstance();
		list = pDAO.selectComment(rVO);
		
		JSONArray ja = new JSONArray();
		JSONObject tmp = null;
		for (CommentDomain cd : list) {
			tmp = new JSONObject();
			tmp.put("comm_num", cd.getComm_num());
			tmp.put("id", cd.getId());
			tmp.put("comm_content", cd.getComm_content());
			tmp.put("input_date", cd.getInput_date());
			tmp.put("delete_flag", cd.getDelete_flag());
			ja.add(tmp);
		}//end for
		json.put("comment_list", ja);
		
		TotalCntVO tcVO = new TotalCntVO("COMM", "POST_NUM", post_num);
		String pagination = new PaginationService().getPagination(current_page, tcVO);
		json.put("pagination", pagination);
		
		return json.toJSONString();
	}//moveCommentList
	
	/**
	 * 글을 삭제하는 일
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
	 * 댓글을 삭제하는 일
	 * @param comm_num
	 * @return
	 */
	public String removeComment(int comm_num) {
		boolean flag = false;
		
		PostDAO pDAO = PostDAO.getInstance();
		flag = pDAO.deleteComment(comm_num) > 0;
		JSONObject json = new JSONObject();
		json.put("delete_flag", flag);
		
		return json.toJSONString();
	}//removeComment
	
}//PostService
