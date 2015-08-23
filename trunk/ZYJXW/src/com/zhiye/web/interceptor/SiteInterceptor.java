package com.zhiye.web.interceptor;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zhiye.common.bean.ZySite;
import com.zhiye.common.util.Config;
import com.zhiye.log.Logger;
import com.zhiye.log.LoggerFactory;
import com.zhiye.services.ServiceException;
import com.zhiye.services.SiteService;

public class SiteInterceptor extends AbstractInterceptor {
	private Logger _logger = LoggerFactory.getPresentationLog(this.getClass());

	private static final long serialVersionUID = 1L;
	private SiteService siteService;

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String method = "intercept";
		ActionContext actionContext = actionInvocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(ServletActionContext.HTTP_REQUEST);
		String ip = getIPFromRequest(request);
		String uri = request.getRequestURI();
		
		if (uri.contains("/admin/")) {
			return actionInvocation.invoke();
		}
		if (ip != null) {
			try {
				List<ZySite> sites = siteService.findSiteByIP(ip);
				if (sites != null && sites.size() > 0) {
					ZySite temp = sites.get(0);
					Date curDate = new Date();
					if (curDate.getTime() - temp.getViewTime().getTime() > Config
							.getLong("site_view_time")) {
						temp.setIp(ip);
						temp.setViewTime(curDate);
						siteService.addSite(temp);
					}

				} else {
					ZySite temp = new ZySite();
					temp.setIp(ip);
					temp.setViewTime(new Date());
					siteService.addSite(temp);
				}

				long count = siteService.countAllSites();

				request.getSession().setAttribute("totalCount", count);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return actionInvocation.invoke();
	}

	private String getIPFromRequest(HttpServletRequest request) {
		String ip = null;
		ip = request.getHeader("Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
