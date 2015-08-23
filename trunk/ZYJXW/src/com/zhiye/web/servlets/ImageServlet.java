package com.zhiye.web.servlets;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.zhiye.common.bean.ZyLink;
import com.zhiye.services.LinkService;

/**
 * Description of the class
 * 
 */
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = -2164157140488693357L;

	private WebApplicationContext ctx;

	private Logger log = LoggerFactory.getLogger(ImageServlet.class);

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
	}

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getRequestURI();
		log.debug("the request url is: {}", requestUrl);
		String imageName = requestUrl.substring(
				requestUrl.lastIndexOf('/') + 1, requestUrl.length());
		log.debug("the image name--" + imageName);
		if (imageName == null) {
			log.warn("the requestUrl is invalid!");
		} else {
			String[] linkIdUrl = imageName.split("\\.");
			log.debug("the linkid is :{}", linkIdUrl);
			if (linkIdUrl.length < 2) {
				log
						.warn("the request url is invalid, the image name is wrong!");
			} else {
				String linkId = linkIdUrl[0];
				log.debug("the image id is :{}", linkId);

				LinkService linkService = (LinkService) ctx.getBean("linkService");

				BufferedOutputStream toClient = null;
				InputStream streamIn = null;
				try {
					ZyLink tp = linkService.findLinkById(Integer.parseInt(linkId));

					// the width and height of new image
					int imageWidth = 133;
					int imageHeight = 39;
					if (request.getParameter("width") != null
							&& request.getParameter("height") != null) {
						imageWidth = Integer.parseInt(request
								.getParameter("width"));
						imageHeight = Integer.parseInt(request
								.getParameter("height"));
					} else {
						imageWidth = 133;
						imageHeight = 39;
					}

					byte[] b = null;
					if (null != tp)
						b = tp.getLinkimage();

					if (b != null) {
						log.debug("imgae byte array length = " + b.length);
						streamIn = new BufferedInputStream(
								new ByteArrayInputStream(b));
						response.setContentType("image/jpeg");
						toClient = new BufferedOutputStream(response
								.getOutputStream());

						Image srcImg = javax.imageio.ImageIO.read(streamIn);
						int newWidth = imageWidth;
						int newHeight = imageHeight;
						BufferedImage buffImg = new BufferedImage(newWidth,
								newHeight, BufferedImage.TYPE_INT_RGB);
						buffImg.getGraphics().drawImage(srcImg, 0, 0, newWidth,
								newHeight, null);

						JPEGImageEncoder jpgEncoder = JPEGCodec
								.createJPEGEncoder(toClient);
						jpgEncoder.encode(buffImg);
						toClient.flush();
					}
					log.debug("show image success!");

				} catch (Exception e) {
					log.debug("show image failed!");
					log.error("Exception:", e);
				} finally {
					try {
						if (toClient != null) {
							toClient.close();
						}
						if (streamIn != null) {
							streamIn.close();
						}
					} catch (IOException e) {
						log.error("show image failed!");
						log.error("IOException:", e);
					}
				}

			}
		}
	}
}
