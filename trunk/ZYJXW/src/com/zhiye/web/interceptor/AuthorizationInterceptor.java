package com.zhiye.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zhiye.log.Logger;
import com.zhiye.log.LoggerFactory;

public class AuthorizationInterceptor extends AbstractInterceptor {
	private Logger _logger = LoggerFactory.getPresentationLog(this.getClass());

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String method = "intercept";
		ActionContext actionContext = actionInvocation.getInvocationContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(ServletActionContext.HTTP_REQUEST);
		String uri = request.getRequestURI();
		String actionName = actionContext.getName();
		// 如果不是登录的URL并且用户未登录的情况下，让用户跳转到登录页面

		// 后台
		if (uri.contains("/admin/")) {

			if (session.get("loginUser") != null) {
				_logger.info(method, " action passed the interceptor!");
				return actionInvocation.invoke();
			} else if (!actionName.equals("login")
					&& !actionName.equals("logout")) {
				_logger.error(method, "sorry, you didn't logon system!");
				return "loginAdmin";
			} else {
				_logger.info(method, " action passed the interceptor!");
				return actionInvocation.invoke();
			}
			// 前台
		} else {
			if (actionName.equals("addIndex")
					|| actionName.equals("searchIndex")
					|| actionName.equals("editCorp")||actionName.equals("editCorpPage")) {
				if (session.get("loginCorp") != null) {
					_logger.info(method, " action passed the interceptor!");
					return actionInvocation.invoke();
				} else {
					_logger.error(method, "sorry, you didn't logon system!");
					return "loginCorp";
				}
			} else {
				_logger.info(method, " action passed the interceptor!");
				return actionInvocation.invoke();
			}

		}

	}
}