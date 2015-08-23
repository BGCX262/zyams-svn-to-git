package com.zhiye.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharEncodeFilter implements Filter {
	Logger log = LoggerFactory.getLogger(CharEncodeFilter.class);

	private FilterConfig filterConfig;

	/**
	 * init
	 * 
	 * @param filterConfig
	 *            FilterConfig
	 * @throws ServletException
	 *             servlet exception
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		String method = "init";
		log.info(method + "--init filter..");
		this.filterConfig = filterConfig;
	}

	/**
	 * do Fileter
	 * 
	 * @param servletRequest
	 *            ServletRequest
	 * @param servletResponse
	 *            ServletResponse
	 * @param chain
	 *            FilterChain
	 * @throws IOException
	 *             IO exception
	 * @throws ServletException
	 *             Servlet exception
	 * 
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		String method = "doFilter";

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
//		if(request.getParameter("nav")!=null){
//			request.getSession().setAttribute("navId",request.getParameter("nav") );
//		}
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			chain.doFilter(request, response);
		} catch (ServletException sx) {
			log.error(method + "--servletException:", sx);
			filterConfig.getServletContext().log(sx.getMessage());
		} catch (IOException iox) {
			log.error(method + "--IOException:", iox);
			filterConfig.getServletContext().log(iox.getMessage());
		}
	}

	public void destroy() {

	}

}
