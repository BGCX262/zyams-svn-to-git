package com.zhiye.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyMsg;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ArticleService;
import com.zhiye.services.MsgService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class MsgAction extends GenericActionSupport<ZyMsg> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyMsg msg;

	String username;
	String rand;
	String content;
	ArticleService articleService;
	int msgId;
	String flag;
	MsgService msgService;
	UserService userService;
	List<ZyMsg> msgs;

	public List<ZyMsg> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<ZyMsg> msgs) {
		this.msgs = msgs;
	}

	/**
	 * 列出所有的留言,根据类型ID
	 * 
	 * @return
	 */
	public String listMsgs() {
		String m = "listMsgs";
		try {
			// 获得配置的每页数量
			if (numPerPage == 0) {
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyMsg> msgs = null;
			 if(username!=null&&username.trim().length()>0){
				 params.put("username", username);
					request.setAttribute("username", username);
			 }
			 if(content!=null&&content.trim().length()>0){
				 params.put("content", content);
					request.setAttribute("content", content);
			 }
			 
			params.put("start", start);
			params.put("size", numPerPage);
			msgs = msgService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = msgService.countSearchPager(params);

			pager = new Pager<ZyMsg>(pageNum, numPerPage);

			pager.setPageRecords(msgs);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " msgs");

		} catch (ServiceException e) {
			error(m, "find all msgs exeption", e);
		} catch (Exception e) {
			error(m, "find all msgs exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);

		return "success";

	}

	// 删除ARTICLE
	public String removeMsg() {
		String m = "removeMsg";
		info(m, ",msg ids" + msgId);
		int result = 0;
		try {
			result = msgService.removeMsgById(msgId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the msg with id=" + msgId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listMsgs";
			this.forwardUrl = "listMsgs.action";

			info(m, "remove the msg successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "200";
			info(m, "remove the msg failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除ARTICLE
	public String removeMsgs() {
		String m = "removeMsgs";
		info(m, "msgs ids is" + entityIds);
		int result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = msgService.removeMsgById(Integer.parseInt(id.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the msg with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listMsgs";
			this.forwardUrl = "listMsgs.action";
			info(m, "remove the msg successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the msg failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个留言，跳转到添加页面
	 * 
	 * @return
	 */
	public String addMsg() {
		String m="addMsg";
		try {
			List<ZyUser> users = userService.findUserList(new ZyUserParams());
			request.setAttribute("users", users);
		} catch (Exception e1) {
			error(m,"exception="+e1);
		}

		return "add";
	}

	/**
	 * 添加一个留言
	 * 
	 * @return
	 */
	public String doAddMsg() {
		String m = "doAddMsg";
		info(m, "add the msg  =" + msg);
		try {
			Date newDate = new Date();
			msg.setCreatetime(newDate);
			msgService.addMsg(msg);
		} catch (ServiceException e) {
			error(m, "add the msg  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addMsg";
			info(m, "add the msg failed with title=" + msg.getUsername());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listMsgs";

		info(m, "add the msg success with msg title=" + msg.getUsername());
		return "ajaxDone";
	}

	/**
	 * 编辑一个留言，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editMsg() {
		String m = "editMsg";
		info(m, "edit the msg  with msg id=" + msgId);
		try {
			msg = msgService.findMsgById(msgId);
		} catch (ServiceException e) {
			error(m, "find the msg exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		try {
			List<ZyUser> users = userService.findUserList(new ZyUserParams());
			request.setAttribute("users", users);
		} catch (ServiceException e1) {
			error(m,"exception="+e1);
		}
		if (msg != null) {
			request.setAttribute("msg", msg);
			info(m, "find the msg  success with msgId=" + msgId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listMsgs.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listMsgs";
			info(m, "find the msg failed with msgId=" + msgId);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个留言
	 * 
	 * @return
	 */
	public String doEditMsg() {
		String m = "doEditMsg";
		info(m, "edit the msg  with msg id=" + msg.getMsgId());
		int result = 0;
		try {
			ZyMsg msgTemp = msgService.findMsgById(msg.getMsgId());
			if (msgTemp != null) {
				msg.setCreatetime(msgTemp.getCreatetime());
			}
			result = msgService.updateMsg(msg);
		} catch (ServiceException e) {
			error(m, "find the msg  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listMsgs";
			info(m, "update the msg  success with msg id=" + msg.getMsgId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editMsg";

			info(m, "find the msg type failed with msg id=" + msg.getMsgId());
		}
		return "ajaxDone";
	}
/////////////////////////////////////////////////////////////////////////////////WEB ACTION/////////////////////////////
	public String webAddMsg(){
		String m="webAddMsg";
		info(m, "add the msg  =" + msg);
//		查询通知通告
		List<ZyArticle> articleList3=articleService.findArticlesByCountAndArticleType(Config.getInt("tongzhitonggao_id"),10,1,true,true);
		request.setAttribute("articleList3", articleList3);
		
		List<ZyArticle> articleList1=articleService.findArticlesByCountAndArticleType(Config.getInt("banshizhinan_id"),10,1,true,true);
		
		request.setAttribute("articleList1", articleList1);
		//查询下载中心
		List<ZyArticle> articleList2=articleService.findArticlesByCountAndArticleType(Config.getInt("xiazaizhongxin_id"),10,1,true,true);
		request.setAttribute("articleList2", articleList2);
		if(flag!=null){
		try {
			List<ZyUser> users = userService.findUserList(new ZyUserParams());
			request.setAttribute("users", users);
		} catch (ServiceException e1) {
			error(m,"exception="+e1);
		}
		request.setAttribute("flag", flag);
		}

		
		String kaptchaExpected = (String) request.getSession().getAttribute("rand");
		if (!rand.equals(kaptchaExpected)) {
			this.addFieldError("kap", "对不起，您输入的验证码有误!");
			return INPUT;
		}
		try {
			Date newDate = new Date();
			msg.setCreatetime(newDate);
			msgService.addMsg(msg);
		} catch (ServiceException e) {
			error(m, "add the msg  exception", e);
			info(m, "add the msg failed with title=" + msg.getUsername());
			return "input";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		
		info(m, "add the msg success with msg title=" + msg.getUsername());
		request.setAttribute("msg1", "恭喜你，留言成功！");
		return "success";
	}
	public ZyMsg getMsg() {
		return msg;
	}

	public void setMsg(ZyMsg msg) {
		this.msg = msg;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public MsgService getMsgService() {
		return msgService;
	}

	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
