package com.zhiye.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyLink;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.services.LinkService;
import com.zhiye.services.ServiceException;

public class LinkAction extends GenericActionSupport<ZyLink> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyLink link;

	String type;

	int linkId;

	String linkName;

	LinkService linkService;

	List<ZyLink> links;

	private transient File image;

	private transient String imageFileName;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ZyLink> getLinks() {
		return links;
	}

	public void setLinks(List<ZyLink> links) {
		this.links = links;
	}

	/**
	 * 列出所有的链接,根据类型ID
	 * 
	 * @return
	 */
	public String listLinks() {
		String m = "listLinks";
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
			List<ZyLink> links = null;
			params.put("start", start);
			params.put("size", numPerPage);
			if (null != linkName && linkName.trim().length() > 0) {
				params.put("linkName", linkName);
			}
			if (null != type && type.trim().length() > 0) {
				params.put("type", type);
			}
			links = linkService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = linkService.countSearchPager(params);

			pager = new Pager<ZyLink>(pageNum, numPerPage);

			pager.setPageRecords(links);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " links");

		} catch (ServiceException e) {
			error(m, "find all links exeption", e);
		} catch (Exception e) {
			error(m, "find all links exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("type", type);
		request.setAttribute("linkName", linkName);
		return "success";

	}

	// 删除ARTICLE
	public String removeLink() {
		String m = "removeLink";
		info(m, "uidis" + linkId);
		int result = 0;
		try {
			result = linkService.removeLinkById(linkId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the link with id=" + linkId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listLinks";
			this.forwardUrl = "listLinks.action";

			info(m, "remove the link successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "200";
			info(m, "remove the link failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除ARTICLE
	public String removeLinks() {
		String m = "removeLinks";
		info(m, "links ids is" + entityIds);
		int result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = linkService
						.removeLinkById(Integer.parseInt(id.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the link with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listLinks";
			this.forwardUrl = "listLinks.action";
			info(m, "remove the link successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the link failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个链接，跳转到添加页面
	 * 
	 * @return
	 */
	public String addLink() {
		String m = "addLinkType";
		return "add";
	}

	/**
	 * 添加一个链接
	 * 
	 * @return
	 */
	public String doAddLink() {
		String m = "doAddLink";
		info(m, "add the link  =" + link);
		try {
			Date newDate = new Date();
			link.setCreatetime(newDate);
			
			byte[] buffer = null;
			if (null != image) {
				debug(m, "imageFileName=" + imageFileName
						+ " , image size = " + image.length());
				if (!imageFileName.contains(".")) {
					debug(m, "图片格式不正确");
					this.message = "图片格式不正确";
					this.statusCode = "300";
					this.navTabId = "addLink";
				}
				String mimeType = imageFileName.substring(imageFileName
						.lastIndexOf(".") + 1);
				if (!mimeType.equalsIgnoreCase("jpg")
						&& !mimeType.equalsIgnoreCase("gif")
						&& !mimeType.equalsIgnoreCase("bmp")
						&& !mimeType.equalsIgnoreCase("png")) {
					debug(m, "图片格式不正确");
					this.message = "图片格式不正确";
					this.statusCode = "300";
					this.navTabId = "addLink";
				}
				if (image.length() > 1024000) {
					debug(m, "图片超过了1M");
					this.message = "图片超过了1M";
					this.statusCode = "300";
					this.navTabId = "addLink";
				}
				debug(m, "begin reading image data...");
				buffer = new byte[(int) image.length()];
				FileInputStream fis = new FileInputStream(image);
				fis.read(buffer);
				fis.close();
				debug(m, "end reading image data...");
				link.setLinkimage(buffer);
			}
			linkService.addLink(link);
		} catch (ServiceException e) {
			error(m, "add the link  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addLink";
			info(m, "add the link failed with title=" + link.getLinkname());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listLinks";

		info(m, "add the link success with link title=" + link.getLinkname());
		return "ajaxDone";
	}

	/**
	 * 编辑一个链接，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editLink() {
		String m = "editLink";
		info(m, "edit the link  with link id=" + linkId);
		try {
			link = linkService.findLinkById(linkId);
		} catch (ServiceException e) {
			error(m, "find the link exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		if (link != null) {
			request.setAttribute("link", link);
			info(m, "find the link  success with linkId=" + linkId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listLinks.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listLinks";
			info(m, "find the link failed with linkId=" + linkId);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个链接
	 * 
	 * @return
	 */
	public String doEditLink() {
		String m = "doEditLink";
		info(m, "edit the link  with link id=" + link.getLinkId());
		int result = 0;
		try {
			ZyLink linkTemp = linkService.findLinkById(link.getLinkId());
			if (linkTemp != null) {
				link.setCreatetime(linkTemp.getCreatetime());
			}
			
			byte[] buffer = null;
			if (null != image) {
				debug(m, "imageFileName=" + imageFileName
						+ " , image size = " + image.length());
				if (!imageFileName.contains(".")) {
					debug(m, "图片格式不正确");
					this.message = "图片格式不正确";
					this.statusCode = "300";
					this.navTabId = "addLink";
				}
				String mimeType = imageFileName.substring(imageFileName
						.lastIndexOf(".") + 1);
				if (!mimeType.equalsIgnoreCase("jpg")
						&& !mimeType.equalsIgnoreCase("gif")
						&& !mimeType.equalsIgnoreCase("bmp")
						&& !mimeType.equalsIgnoreCase("png")) {
					debug(m, "图片格式不正确");
					this.message = "图片格式不正确";
					this.statusCode = "300";
					this.navTabId = "addLink";
				}
				if (image.length() > 1024000) {
					debug(m, "图片超过了1M");
					this.message = "图片超过了1M";
					this.statusCode = "300";
					this.navTabId = "addLink";
				}
				debug(m, "begin reading image data...");
				buffer = new byte[(int) image.length()];
				FileInputStream fis = new FileInputStream(image);
				fis.read(buffer);
				fis.close();
				debug(m, "end reading image data...");
				link.setLinkimage(buffer);
			}else{
				link.setLinkimage(linkTemp.getLinkimage());
				link.setCreatetime(linkTemp.getCreatetime());
			}
			result = linkService.updateLink(link);
		} catch (ServiceException e) {
			error(m, "find the link  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listLinks";
			info(m, "update the link  success with link id=" + link.getLinkId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editLink";

			info(m, "find the link type failed with link id="
					+ link.getLinkId());
		}
		return "ajaxDone";
	}

	public LinkService getLinkService() {
		return linkService;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	public ZyLink getLink() {
		return link;
	}

	public void setLink(ZyLink link) {
		this.link = link;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

}
