package kr.co.rgrg.admin.post.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.domain.CommentDomain;
import kr.co.rgrg.admin.post.domain.PostDetailDomain;
import kr.co.rgrg.admin.post.domain.PostListDomain;

@Controller
public class PostController {
	
	/**
	 * �� ����� �������� ��
	 * @param rVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="post_list.do", method=GET)
	@ResponseBody
	public String getPostList(RangeVO rVO, Model model) {
		List<PostListDomain> list = null;
		return "post/post_list";
	}//getPostList
	
	/**
	 * �� �󼼳����� �������� ��
	 * @param post_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="post_detail.do", method=GET)
	public String getPostDetail(String post_num, Model model) {
		List<PostDetailDomain> list = null;
		return "";
	}//getPostDetail
	
	/**
	 * �� �󼼳����� ����� �������� ��
	 * @param rVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="comment_list.do", method=GET)
	@ResponseBody
	public String getCommentList(RangeVO rVO, Model model) {
		List<CommentDomain> list = null;
		return "";
	}//getCommentList
	
	/**
	 * ���� �����ϴ� ��
	 * @param post_num
	 * @return
	 */
	@RequestMapping(value="remove_post.do", method=GET)
	public String removePost(String post_num) {
		boolean flag = false;
		return "";
	}//removePost
	
	/**
	 * ����� �����ϴ� ��
	 * @param comm_num
	 * @return
	 */
	@RequestMapping(value="remove_comment.do", method=GET)
	public String removeComment(String comm_num) {
		boolean flag = false;
		return "";
	}//removeComment
	
}//PostController
