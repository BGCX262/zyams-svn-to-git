package com.zhiye.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyCorporationParams;
import com.zhiye.common.bean.ZyCorporationProduct;
import com.zhiye.common.bean.ZyDictionary;
import com.zhiye.common.bean.ZyIndex;
import com.zhiye.common.bean.ZyIndexParams;
import com.zhiye.common.bean.ZyIndexProd;
import com.zhiye.common.bean.ZyIndexProdParams;
import com.zhiye.common.bean.ZyProduct;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.common.util.ReportUtil;
import com.zhiye.common.util.Zipper;
import com.zhiye.services.ArticleService;
import com.zhiye.services.CorporationProductService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.DictionaryService;
import com.zhiye.services.IndexProdService;
import com.zhiye.services.IndexService;
import com.zhiye.services.ProductService;
import com.zhiye.services.ServiceException;

public class ReportAction extends GenericActionSupport<ZyCorporation> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyIndex index;

	ZyCorporation corporation;

	int corporationId;

	int indexId;

	int year;

	int rowid;

	int month;

	String status;

	ProductService productService;

	CorporationService corporationService;

	IndexProdService indexProdService;

	CorporationProductService corporationProductService;

	ZyCorporationProduct corporationProduct;

	DictionaryService dictionaryService;

	ArticleService articleService;

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	IndexService indexService;

	List<ZyIndex> indexs;

	public List<ZyIndex> getIndexs() {
		return indexs;
	}

	public void setIndexs(List<ZyIndex> indexs) {
		this.indexs = indexs;
	}

	/**
	 * 列出所有的申报,根据类型ID
	 * 
	 * @return
	 */
	public String listIndexs() {
		String m = "listIndexs";
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
			List<Map> corps = null;
			params.put("start", start);
			params.put("size", numPerPage);
			if (year > 0) {
				params.put("year", year);
			} else {
				Object yearObj = session.get("year");
				if (yearObj != null) {
					params.put("year", Integer.parseInt(yearObj.toString()));
				}
			}
			if (month > 0) {
				params.put("month", month);
			} else {
				Object monthObj = session.get("month");
				if (monthObj != null) {
					params.put("month", Integer.parseInt(monthObj.toString()));
				}
			}

			if (null != status && status.length() > 0 && !status.equals("all")) {
				params.put("status", status);
			} else {
				Object statusObj = session.get("status");
				if (statusObj != null && !statusObj.toString().equals("all")) {
					params
							.put("status", Integer.parseInt(statusObj
									.toString()));
				}
			}
			corps = corporationService.searchForPagerWithIndex(params);

			List<ZyCorporation> coprs = new ArrayList<ZyCorporation>(corps
					.size());
			for (Map map : corps) {
				ZyCorporation c = new ZyCorporation();
				c.setName(map.get("name").toString());
				if (map.get("BAK6") != null) {
					c.setStatus(map.get("BAK6").toString());
				}
				c.setRowid(Integer.parseInt(map.get("RowID").toString()
								.trim()));
				if (map.get("ID") != null) {
					c.setId(map.get("ID").toString());
				}
				coprs.add(c);
			}
			params.remove("start");
			params.remove("size");
			int count = corporationService
					.countSearchPager(new HashMap<String, Object>());
			pager = new Pager<ZyCorporation>(pageNum, numPerPage);

			pager.setPageRecords(coprs);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " Corporation");

		} catch (ServiceException e) {
			error(m, "find all Corporation exeption", e);
		} catch (Exception e) {
			error(m, "find all Corporation exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("status", status);
		request.setAttribute("year1", year);
		request.setAttribute("month1", month);
		session.put("status", status);
		session.put("year", year);
		session.put("month", month);
		return "success";

	}

	// 查看报表
	public String viewIndex() {
		String m = "viewIndex";
		info(m, "indexIds" + indexId);
		ZyIndex result = null;
		try {
			result = indexService.findIndexById(indexId);

			request.setAttribute("index", result);
			ZyCorporation pdo = corporationService.findcorporationById(result
					.getCorporationid());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("corportationid", pdo.getId());
			List<ZyProduct> doucts = corporationProductService
					.findCorporationProductList(params);
			request.setAttribute("corpProducts", doucts);
			List<ZyIndexProd> prod2 = new ArrayList<ZyIndexProd>();
			for (ZyProduct product : doucts) {
				ZyIndexProdParams param = new ZyIndexProdParams();
				param.createCriteria().andYearEqualTo(result.getYear() + "")
						.andMonthEqualTo(result.getMonth() + "")
						.andProductidEqualTo(product.getProductid() + "")
						.andCorporationidEqualTo(pdo.getId());
				List<ZyIndexProd> temnp = indexProdService
						.findIndexProdList(param);
				if (temnp == null || temnp.size() == 0) {
					prod2.add(new ZyIndexProd());
				} else {
					prod2.add(temnp.get(0));
				}
			}
			request.setAttribute("corpProducts2", prod2);
		} catch (ServiceException e) {
			error(m, "find the index with id=" + indexId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		return "success";
	}

	// 审核REPORT
	public String manageIndex() {
		String m = "manageIndex";
		info(m, "indexIds" + indexId);
		ZyIndex result = null;
		int count = 0;
		try {
			result = indexService.findIndexById(indexId);
			if (result != null) {
				// 审核状态
				result.setStatus("0");
				count = indexService.updateIndex(result);
			}
		} catch (ServiceException e) {
			error(m, "find the index with id=" + indexId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (count > 0) {
			this.callbackType = "forward";
			this.message = "审核成功";
			this.statusCode = "200";
			this.navTabId = "listIndexs";
			this.forwardUrl = "listIndexs.action";
			info(m, "manage the index successed!");
		} else {
			this.message = "审核失败";
			this.statusCode = "300";
			info(m, "manage the index failed!");
			request.setAttribute("errorMsg", "manage failed!");
		}
		return "ajaxDone";
	}

	// /**
	// * 添加一个申报，跳转到添加页面
	// *
	// * @return
	// */
	// public String addIndex() {
	// String m = "addIndexType";
	// return "add";
	// }

	public String editCorpPage() {
		String m = "editCorporation";
		info(m, "edit the editenterprise");
		List<ZyDictionary> dictionarys = null;
		try {

			corporation = corporationService
					.findcorporationById(((ZyCorporation) session
							.get("loginCorp")).getRowid());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dictid", 102);
			// 查询所属区域
			dictionarys = dictionaryService.finDictionaryDictid(params);
			if (null != dictionarys) {
				request.setAttribute("dictionarys", dictionarys);
				params.remove("dictid");
			}
			// 查询行业
			List<ZyDictionary> trades = null;
			params.put("dictid", 108);
			trades = dictionaryService.finDictionaryDictid(params);
			if (null != trades) {
				request.setAttribute("trades", trades);
				params.remove("dictid");
			}
			// 查询地区
			List<ZyDictionary> areas = null;
			params.put("dictid", 107);
			areas = dictionaryService.finDictionaryDictid(params);
			if (null != areas) {
				request.setAttribute("areas", areas);
				params.remove("dictid");
			}
			request.setAttribute("corporation", corporation);

			// 查询产品信息
			List<ZyProduct> products = null;
			products = productService.finDictionaryid();
			if (null != products) {
				request.setAttribute("product", products);
			}
			// 查询corporacton product信息
			List<ZyCorporationProduct> corporactonproducts = null;
			corporactonproducts = corporationProductService
					.finDictionaryid(corporation.getId());
			if (null != corporactonproducts) {
				request.setAttribute("corporactonproduct", corporactonproducts);
			}
			// 查询办事指南
			List<ZyArticle> articleList1 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("banshizhinan_id"), 10, 1, true, true);

			request.setAttribute("articleList1", articleList1);
			// 查询下载中心
			List<ZyArticle> articleList2 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("xiazaizhongxin_id"), 10, 1, true, true);
			request.setAttribute("articleList2", articleList2);
		} catch (ServiceException e) {
			error(m, "find all dictionarys exeption", e);
		} catch (Exception e) {
			error(m, "find all dictionarys exeption", e);
		}
		return "success";

	}

	public String editCorp() {
		String m = "editCorp";
		info(m, "edit the editEnterprise,by Corporation rowid"
				+ ((ZyCorporation) session.get("loginCorp")).getRowid());
		int result = 0;
		int resultProduct = 0;
		try {
			// 更新corporationService
			result = corporationService.updateCorporation(corporation);
			// 更新corporationProductService,先删除企业旗下 所有产品,然后再增加,实现更新方式
			corporationProductService.removeCorporationProduct(corporation
					.getId());
			// 增加
			String[] ssString = request.getParameterValues("productIds");
			for (String s : ssString) {
				corporationProduct = new ZyCorporationProduct();
				corporationProduct.setProductid(s.trim());
				corporationProduct.setCorportationid(corporation.getId());
				corporationProductService
						.addCorporationProduct(corporationProduct);
			}
			// 查询办事指南
			List<ZyArticle> articleList1 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("banshizhinan_id"), 10, 1, true, true);

			request.setAttribute("articleList1", articleList1);
			// 查询下载中心
			List<ZyArticle> articleList2 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("xiazaizhongxin_id"), 10, 1, true, true);
			request.setAttribute("articleList2", articleList2);

			// 查询所属区域
			List<ZyDictionary> dictionarys = null;
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dictid", 102);
			dictionarys = dictionaryService.finDictionaryDictid(params);
			if (null != dictionarys) {
				request.setAttribute("dictionarys", dictionarys);
				params.remove("dictid");
			}
			// 查询行业
			List<ZyDictionary> trades = null;
			params.put("dictid", 108);
			trades = dictionaryService.finDictionaryDictid(params);
			if (null != trades) {
				request.setAttribute("trades", trades);
				params.remove("dictid");
			}
			// 查询地区
			List<ZyDictionary> areas = null;
			params.put("dictid", 107);
			areas = dictionaryService.finDictionaryDictid(params);
			if (null != areas) {
				request.setAttribute("areas", areas);
				params.remove("dictid");
			}
			request.setAttribute("corporation", corporation);

			// 查询产品信息
			List<ZyProduct> products = null;
			products = productService.finDictionaryid();
			if (null != products) {
				request.setAttribute("product", products);
			}
			// 查询corporacton product信息
			List<ZyCorporationProduct> corporactonproducts = null;
			corporactonproducts = corporationProductService
					.finDictionaryid(corporation.getId());
			if (null != corporactonproducts) {
				request.setAttribute("corporactonproduct", corporactonproducts);
			}
		} catch (ServiceException e) {
			error(m, "unknown error", e);
		} catch (Exception e) {
			// TODO: handle exception
			error(m, "unknown exeption", e);
		}
		return "success";
	}

	/**
	 * 添加一个申报
	 * 
	 * @return
	 */
	public String doAddIndex() {
		String m = "doAddIndex";
		info(m, "add the index  =" + index);
		Date newDate = new Date();
		try {
			if (index.getId() != null && index.getId() > 0) {
				index.setUpdatetime(newDate);
				index.setCreatetime(newDate);
				indexService.updateIndex(index);
			} else {
				index.setCreatetime(newDate);
				index.setUpdatetime(newDate);
				index.setCorporationid(((ZyCorporation) session
						.get("loginCorp")).getRowid());
				// 未审核状态
				index.setStatus(Constant.REPORT_INACTIVE);
				indexService.addIndex(index);
			}

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("corportationid", ((ZyCorporation) session
					.get("loginCorp")).getId());
			List<ZyProduct> doucts = corporationProductService
					.findCorporationProductList(params);
			for (ZyProduct duct : doucts) {
				String v01 = request.getParameter("product_v01_"
						+ duct.getProductid());
				if (v01 == null || v01.trim().length() == 0) {
					v01 = "0";
				}
				String b01 = request.getParameter("product_b01_"
						+ duct.getProductid());
				if (b01 == null || b01.trim().length() == 0) {
					b01 = "0";
				}
				String q01 = request.getParameter("product_q01_"
						+ duct.getProductid());
				if (q01 == null || q01.trim().length() == 0) {
					q01 = "0";
				}
				String s01 = request.getParameter("product_s01_"
						+ duct.getProductid());
				if (s01 == null || s01.trim().length() == 0) {
					s01 = "0";
				}
				String v02 = request.getParameter("product_v02_"
						+ duct.getProductid());
				if (v02 == null || v02.trim().length() == 0) {
					v02 = "0";
				}
				String b02 = request.getParameter("product_b02_"
						+ duct.getProductid());
				if (b02 == null || b02.trim().length() == 0) {
					b02 = "0";
				}
				String q02 = request.getParameter("product_q02_"
						+ duct.getProductid());
				if (q02 == null || q02.trim().length() == 0) {
					q02 = "0";
				}
				String s02 = request.getParameter("product_s02_"
						+ duct.getProductid());
				if (s02 == null || s02.trim().length() == 0) {
					s02 = "0";
				}
				String v03 = request.getParameter("product_v03_"
						+ duct.getProductid());
				if (v03 == null || v03.trim().length() == 0) {
					v03 = "0";
				}
				String b03 = request.getParameter("product_b03_"
						+ duct.getProductid());
				if (b03 == null || b03.trim().length() == 0) {
					b03 = "0";
				}
				String q03 = request.getParameter("product_q03_"
						+ duct.getProductid());
				if (q03 == null || q03.trim().length() == 0) {
					q03 = "0";
				}
				String s03 = request.getParameter("product_s03_"
						+ duct.getProductid());
				if (s03 == null || s03.trim().length() == 0) {
					s03 = "0";
				}
				ZyIndexProd temProduct = new ZyIndexProd();
				temProduct.setB01(new BigDecimal(b01));
				temProduct.setV01(new BigDecimal(v01));
				temProduct.setQ01(new BigDecimal(q01));
				temProduct.setS01(new BigDecimal(s01));
				temProduct.setB02(new BigDecimal(b02));
				temProduct.setV02(new BigDecimal(v02));
				temProduct.setQ02(new BigDecimal(q02));
				temProduct.setS02(new BigDecimal(s02));
				temProduct.setB03(new BigDecimal(b03));
				temProduct.setV03(new BigDecimal(v03));
				temProduct.setQ03(new BigDecimal(q03));
				temProduct.setS03(new BigDecimal(s03));
				temProduct.setCorporationid(((ZyCorporation) session
						.get("loginCorp")).getId());
				temProduct.setProductid(duct.getProductid() + "");
				temProduct.setMonth(index.getMonth() + "");
				temProduct.setYear(index.getYear() + "");
				String prodid = request.getParameter("product_"
						+ duct.getProductid());
				if (prodid != null && prodid.trim().length() > 0) {
					temProduct.setId(Integer.parseInt(request
							.getParameter("product_" + duct.getProductid())));
					indexProdService.updateIndexProd(temProduct);
				} else {
					indexProdService.addIndexProd(temProduct);
				}

			}

			List<ZyIndexProd> prod2 = new ArrayList<ZyIndexProd>();
			for (ZyProduct product : doucts) {
				ZyIndexProdParams param = new ZyIndexProdParams();
				param.createCriteria().andYearEqualTo(index.getYear() + "")
						.andMonthEqualTo(index.getMonth() + "")
						.andProductidEqualTo(product.getProductid() + "")
						.andCorporationidEqualTo(
								((ZyCorporation) session.get("loginCorp"))
										.getId());
				List<ZyIndexProd> temnp = indexProdService
						.findIndexProdList(param);
				if (temnp == null || temnp.size() == 0) {
					prod2.add(new ZyIndexProd());
				} else {
					prod2.add(temnp.get(0));
				}
			}
			request.setAttribute("corpProducts2", prod2);
		} catch (ServiceException e) {
			error(m, "save the index  exception", e);
			info(m, "save the index failed with corporation id="
					+ index.getCorporationid());
			return "success";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		// 查询办事指南
		List<ZyArticle> articleList1 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("banshizhinan_id"), 10, 1, true, true);

		request.setAttribute("articleList1", articleList1);
		// 查询下载中心
		List<ZyArticle> articleList2 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("xiazaizhongxin_id"), 10, 1, true, true);
		request.setAttribute("articleList2", articleList2);

		info(m, "add the index success with corporation id="
				+ index.getCorporationid());
		request.setAttribute("index", index);
		request.setAttribute("year1", index.getYear());
		request.setAttribute("month1", index.getMonth());
		return "success";
	}

	// 查看报表
	public String searchIndex() {
		String m = "viewIndex";
		info(m, "year=" + year + ",month=" + month);
		try {
			ZyIndexParams p = new ZyIndexParams();
			p.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
			List<ZyIndex> indexs = indexService.findIndexListWithBLOB(p);
			if (indexs != null && indexs.size() > 0) {
				request.setAttribute("index", indexs.get(0));
			}

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("corportationid", ((ZyCorporation) session
					.get("loginCorp")).getId());
			List<ZyProduct> doucts = corporationProductService
					.findCorporationProductList(params);
			request.setAttribute("corpProducts", doucts);
			List<ZyIndexProd> prod2 = new ArrayList<ZyIndexProd>();
			for (ZyProduct product : doucts) {
				ZyIndexProdParams param = new ZyIndexProdParams();
				param.createCriteria().andYearEqualTo(year + "")
						.andMonthEqualTo(month + "").andProductidEqualTo(
								product.getProductid() + "")
						.andCorporationidEqualTo(
								((ZyCorporation) session.get("loginCorp"))
										.getId());
				List<ZyIndexProd> temnp = indexProdService
						.findIndexProdList(param);
				if (temnp == null || temnp.size() == 0) {
					prod2.add(new ZyIndexProd());
				} else {
					prod2.add(temnp.get(0));
				}
			}
			request.setAttribute("corpProducts2", prod2);
		} catch (ServiceException e) {
			error(m, "find the index with year=" + year + ",month=" + month, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		// 查询办事指南
		List<ZyArticle> articleList1 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("banshizhinan_id"), 10, 1, true, true);

		request.setAttribute("articleList1", articleList1);
		// 查询下载中心
		List<ZyArticle> articleList2 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("xiazaizhongxin_id"), 10, 1, true, true);
		request.setAttribute("articleList2", articleList2);
		request.setAttribute("year1", year);
		request.setAttribute("month1", month);
		return "success";
	}

	/**
	 * 编辑一个申报，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editIndex() {
		String m = "editIndex";
		info(m, "edit the index  with index id=" + indexId);
		try {
			index = indexService.findIndexById(indexId);
		} catch (ServiceException e) {
			error(m, "find the index exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (index != null) {
			request.setAttribute("index", index);
			info(m, "find the index  success with indexId=" + indexId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listIndexs.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listIndexs";
			info(m, "find the index failed with indexId=" + indexId);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个申报
	 * 
	 * @return
	 */
	public String doEditIndex() {
		String m = "doEditIndex";
		info(m, "edit the index  with index id=" + index.getId());
		int result = 0;
		try {
			ZyIndex indexTemp = indexService.findIndexById(index.getId());
			if (indexTemp != null) {
				index.setCreatetime(indexTemp.getCreatetime());
			}
			index.setUpdatetime(new Date());
			result = indexService.updateIndex(index);
		} catch (ServiceException e) {
			error(m, "find the index  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listIndexs";
			info(m, "update the index  success with index id=" + index.getId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editIndex";

			info(m, "find the index type failed with index id=" + index.getId());
		}
		return "ajaxDone";
	}

	/**
	 * 准备下载的文件
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void prepareData() {
		String m = "download";
		// 准备数据
		// 获得用户最后一次选择的年份和月份
		Object yearObj = session.get("year");
		Object monthObj = session.get("month");
		if (yearObj == null) {
			error(m, "no year select to download");
		}
		if (monthObj == null) {
			error(m, "no month select to download");
		}
		year = Integer.parseInt(yearObj.toString().trim());
		month = Integer.parseInt(monthObj.toString().trim());

		String zipUrl = Config.getString("report_folder") + "/" + year + "/"
				+ month + "/" + year + month + ".zip";
		String folder = Config.getString("report_folder") + "/" + year + "/"
				+ month;
		Zipper zca = new Zipper(zipUrl);
		// zca.compress(Config.getString("report_folder")+"/"+year+"/"+month+"/");
		File zipFile = new File(zipUrl);

		// 要下载的ZIP文件是否已经存在
		boolean isExist = false;
		if (zipFile.exists()) {
			isExist = true;
		}
		if (!isExist) {
			File targetFolder = new File(folder);
			if (!targetFolder.exists()) {
				try {
					targetFolder.mkdirs();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 准备所有企业数据
			try {
				Map parmls = new HashMap<String, Object>();
				parmls.put("month", month);
				parmls.put("year", year);
				List<ZyIndex> allIndexs = corporationService
						.findAllIndexsByCorp(parmls);
				Long[] allIndexValue = ReportUtil.statistics(allIndexs);
				// 准备所有地区数据
				Map params = new HashMap<String, Object>();
				params.put("dictid", "107");
				List<ZyDictionary> dicts = dictionaryService
						.finDictionaryDictid(params);
				if (dicts == null || dicts.size() == 0) {
					error(m, "no dictionary found!");
				}
				Map allAreaIndex = new LinkedMap(dicts.size());
				for (ZyDictionary dict : dicts) {
					Map<String, Object> parm1 = new HashMap<String, Object>();
					parm1.put("areaId", dict.getCode());
					parm1.put("month", month);
					parm1.put("year", year);
					List<ZyIndex> tempIndexs = corporationService
							.searchListByArea(parm1);
					if (tempIndexs != null && tempIndexs.size() > 0) {
						Long[] tempLongs = ReportUtil.statistics(tempIndexs);
						allAreaIndex.put(dict.getName(), tempLongs);
					}
				}

				// 准备所有行业
				Map<String, Object> params2 = new HashMap<String, Object>();
				params2.put("dictid", "108");
				List<ZyDictionary> dicts1 = dictionaryService
						.finDictionaryDictid(params2);
				if (dicts1 == null || dicts1.size() == 0) {
					error(m, "no dictionary found!");
				}
				Map allTradeIndex = new LinkedMap(dicts.size());
				for (ZyDictionary dict : dicts1) {
					Map<String, Object> parm1 = new HashMap<String, Object>();
					parm1.put("tradeId", dict.getCode());
					parm1.put("month", month);
					parm1.put("year", year);
					List<ZyIndex> tempIndexs = corporationService
							.searchListByTrade(parm1);
					if (tempIndexs != null && tempIndexs.size() > 0) {
						Long[] tempLongs = ReportUtil.statistics(tempIndexs);
						allTradeIndex.put(dict.getName(), tempLongs);
					}
				}

				// 准备所有骨干企业
				ZyCorporationParams pas = new ZyCorporationParams();
				pas.createCriteria().andIs50EqualTo("是");
				List<ZyCorporation> corps = corporationService
						.findCorpsWithParams(pas);
				Map allCorpIndex = new LinkedMap(corps.size());
				for (ZyCorporation corp : corps) {
					Map<String, Object> param3 = new HashMap<String, Object>();
					param3.put("corporationId", corp.getRowid());
					param3.put("month", month);
					param3.put("year", year);
					List<ZyIndex> tempIndexs = corporationService
							.searchListByCorp(param3);
					if (tempIndexs != null && tempIndexs.size() > 0) {
						Long[] tempLongs = ReportUtil.statistics(tempIndexs);
						allCorpIndex.put(corp.getName(), tempLongs);
					}
				}

				// 准备表1的数据
				// 总计
				Object[] allObjs = ReportUtil.prepareRowData1(allIndexValue);
				if (allObjs == null) {
					allObjs = new Object[0];
				}
				// 地区
				Map allAreas = new LinkedMap();
				Iterator i1 = allAreaIndex.entrySet().iterator();
				while (i1.hasNext()) {
					Map.Entry entry = (Map.Entry) i1.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneArea = ReportUtil.prepareRowData1(val);
					allAreas.put(key, oneArea);
				}
				// 行业
				Map allTrades = new LinkedMap();
				Iterator i2 = allTradeIndex.entrySet().iterator();
				while (i2.hasNext()) {
					Map.Entry entry = (Map.Entry) i2.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneTrade = ReportUtil.prepareRowData1(val);
					allTrades.put(key, oneTrade);
				}

				// 企业
				Map allCorps = new LinkedMap();
				Iterator i3 = allCorpIndex.entrySet().iterator();
				while (i3.hasNext()) {
					Map.Entry entry = (Map.Entry) i3.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneCorp = ReportUtil.prepareRowData1(val);
					allCorps.put(key, oneCorp);
				}

				if (month >= 10) {
					ReportUtil.prepareExcel(allObjs, allAreas, allTrades,
							allCorps, folder + "/" + year + month + "01.xls",
							year, month, 1);
				} else {
					ReportUtil.prepareExcel(allObjs, allAreas, allTrades,
							allCorps, folder + "/" + year + "0" + month
									+ "01.xls", year, month, 1);
				}

				// 准备表2的数据
				// 总计
				Object[] allObjs1 = ReportUtil.prepareRowData2(allIndexValue);
				// 地区
				Map allAreas1 = new LinkedMap();
				Iterator i11 = allAreaIndex.entrySet().iterator();
				while (i11.hasNext()) {
					Map.Entry entry = (Map.Entry) i11.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneArea = ReportUtil.prepareRowData2(val);
					allAreas1.put(key, oneArea);
				}
				// 行业
				Map allTrades1 = new LinkedMap();
				Iterator i22 = allTradeIndex.entrySet().iterator();
				while (i22.hasNext()) {
					Map.Entry entry = (Map.Entry) i22.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneTrade = ReportUtil.prepareRowData2(val);
					allTrades1.put(key, oneTrade);
				}

				// 企业
				Map allCorps1 = new LinkedMap();
				Iterator i33 = allCorpIndex.entrySet().iterator();
				while (i33.hasNext()) {
					Map.Entry entry = (Map.Entry) i33.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneCorp = ReportUtil.prepareRowData2(val);
					allCorps1.put(key, oneCorp);
				}
				if (month >= 10) {
					ReportUtil.prepareExcel(allObjs1, allAreas1, allTrades1,
							allCorps1, folder + "/" + year + month + "02.xls",
							year, month, 2);
				} else {
					ReportUtil.prepareExcel(allObjs1, allAreas1, allTrades1,
							allCorps1, folder + "/" + year + "0" + month
									+ "02.xls", year, month, 2);
				}
				// 准备表3的数据

				// 总计
				Object[] allObjs2 = ReportUtil.prepareRowData3(allIndexValue);
				// 地区
				Map allAreas2 = new LinkedMap();
				Iterator i111 = allAreaIndex.entrySet().iterator();
				while (i111.hasNext()) {
					Map.Entry entry = (Map.Entry) i111.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneArea = ReportUtil.prepareRowData3(val);
					allAreas2.put(key, oneArea);
				}
				// 行业
				Map allTrades2 = new LinkedMap();
				Iterator i222 = allTradeIndex.entrySet().iterator();
				while (i222.hasNext()) {
					Map.Entry entry = (Map.Entry) i222.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneTrade = ReportUtil.prepareRowData3(val);
					allTrades2.put(key, oneTrade);
				}

				// 企业
				Map allCorps2 = new LinkedMap();
				Iterator i333 = allCorpIndex.entrySet().iterator();
				while (i333.hasNext()) {
					Map.Entry entry = (Map.Entry) i333.next();
					String key = entry.getKey().toString();
					Long[] val = (Long[]) entry.getValue();
					Object[] oneCorp = ReportUtil.prepareRowData3(val);
					allCorps2.put(key, oneCorp);
				}
				if (month >= 10) {
					ReportUtil.prepareExcel(allObjs2, allAreas2, allTrades2,
							allCorps2, folder + "/" + year + month + "03.xls",
							year, month, 3);
				} else {
					ReportUtil.prepareExcel(allObjs2, allAreas2, allTrades2,
							allCorps2, folder + "/" + year + "0" + month
									+ "03.xls", year, month, 3);
				}

				// 获得所有产品的数据
				// 每个产品下面再获得所有企业的数据
				List<ZyProduct> products = productService.findAllProducts();
				List<String> units = new ArrayList<String>(products.size());
				Map allproducts = new LinkedMap(products.size());
				Map allCorps12 = new LinkedMap(products.size());
				// 循环每个产品的数据 包含所有企业的
				for (ZyProduct p : products) {
					units.add(p.getUnit());
					Map<String, Object> param1 = new HashMap<String, Object>();
					param1.put("month", month);
					param1.put("year", year);
					param1.put("productid", p.getProductid());
					List<ZyIndexProd> prods = indexProdService
							.searchListByProd(param1);
					if (prods != null && prods.size() > 0) {
						Long[] productValue = ReportUtil
								.statisticsProducts(prods);

						allproducts.put(p.getProductName(), ReportUtil
								.prepareRowData4(productValue));
					}

					List<ZyCorporation> allCorpras = corporationService
							.findAllCorporations();
					Map<String, Object[]> objs = new HashMap<String, Object[]>(
							allCorpras.size());
					// 循环所有企业的每个产品数据
					for (ZyCorporation zp : allCorpras) {
						param1.put("corporationid", zp.getId());

						List<ZyIndexProd> prods2 = indexProdService
								.searchListByCorp(param1);
						if (prods2 == null || prods2.size() == 0) {
							continue;
						}
						Long[] productValue2 = ReportUtil
								.statisticsProducts(prods2);
						// param1.remove("corporationid");
						if (productValue2 != null)
							objs.put(zp.getName(), ReportUtil
									.prepareRowData4(productValue2));
					}
					allCorps12.put(p.getProductName(), objs);
				}

				// 准备表格4
				if (month >= 10) {
					ReportUtil.prepareExcel4(allproducts, allCorps12, units,
							folder + "/" + year + month + "04.xls", year,
							month, -1);
				} else {
					ReportUtil.prepareExcel4(allproducts, allCorps12, units,
							folder + "/" + year + "0" + month + "04.xls", year,
							month, -1);
				}

				// 压缩四个表格为一个ZIP文件
				zca.compress(folder);
			} catch (Exception e) {
				error(m, "find indexs exception", e);
				e.printStackTrace();
			}
		}
	}

	private String fileName;// 初始的通过param指定的文件名属性

	private String inputPath;// 指定要被下载的文件路径

	public InputStream getInputStream() throws Exception {
		String m = "getInputStream";
		// 通过 ServletContext，也就是application 来读取数据
		// 准备数据
		prepareData();
		Object yearObj = session.get("year");
		Object monthObj = session.get("month");
		if (yearObj == null) {
			error(m, "no year select to download");
			yearObj = Calendar.getInstance().get(Calendar.YEAR);
		}
		if (monthObj == null) {
			error(m, "no month select to download");
			monthObj = Calendar.getInstance().get(Calendar.MONTH) + 1;
		}
		year = Integer.parseInt(yearObj.toString().trim());
		month = Integer.parseInt(monthObj.toString().trim());

		String zipUrl = Config.getString("report_folder") + "/" + year + "/"
				+ month + "/" + year + month + ".zip";
		setFileName(year + "" + month + ".zip");
		File file = new File(zipUrl);
		InputStream is = null;
		if (!file.exists()) {
			is = new FileInputStream("empty");
		} else {
			is = new FileInputStream(file);
		}

		return is;
	}

	public String execute() throws Exception {
		String m = "execute";
		Object yearObj = session.get("year");
		Object monthObj = session.get("month");
		if (yearObj == null) {
			error(m, "no year select to download");
			request.setAttribute("errorMsg", "请先根据年份和月份进行查询数据");
			return ERROR;
		}
		if (monthObj == null) {
			error(m, "no month select to download");
			request.setAttribute("errorMsg", "请先根据年份和月份进行查询数据");
			this.message = "请先根据年份和月份进行查询数据！";
			return ERROR;
		}

		ZyIndexParams param = new ZyIndexParams();
		param.createCriteria().andMonthEqualTo(
				Integer.parseInt(monthObj.toString().trim())).andYearEqualTo(
				Integer.parseInt(yearObj.toString().trim()));

		List<ZyIndex> indexs = indexService.findIndexListWithBLOB(param);
		if (indexs == null || indexs.size() == 0) {
			request.setAttribute("errorMsg", "对不起，系统没有找到" + yearObj.toString()
					+ "年" + monthObj.toString() + "月的任何企业申报数据。");
			return ERROR;
		}

		return SUCCESS;
	}

	public void setInputPath(String value) {
		inputPath = value;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/** 提供转换编码后的供下载用的文件名 */
	public String getDownloadFileName() {
		String downFileName = fileName;
		try {
			downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downFileName;
	}

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public ZyIndex getIndex() {
		return index;
	}

	public void setIndex(ZyIndex index) {
		this.index = index;
	}

	public ZyCorporation getCorporation() {
		return corporation;
	}

	public void setCorporation(ZyCorporation corporation) {
		this.corporation = corporation;
	}

	public CorporationService getCorporationService() {
		return corporationService;
	}

	public void setCorporationService(CorporationService corporationService) {
		this.corporationService = corporationService;
	}

	public int getCorporationId() {
		return corporationId;
	}

	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFileName() {
		return fileName;
	}

	// for(int i=142;i<297;i++){
	// ZyIndex index=new ZyIndex();
	// index.setCcpchv1(111l);
	// index.setCcpchv2(111l);
	// index.setCcpchv3(111l);
	//	
	// index.setCkjhzv1(111l);
	// index.setCkjhzv2(111l);
	// index.setCkjhzv3(111l);
	//	
	// index.setCorporationid(i);
	//	
	// index.setCpxscbv1(111l);
	// index.setCpxscbv2(111l);
	// index.setCpxscbv3(111l);
	//	
	// index.setCpxsfyv1(111l);
	// index.setCpxsfyv2(111l);
	// index.setCpxsfyv3(111l);
	//	
	// index.setCpxssjjfjv1(111l);
	// index.setCpxssjjfjv2(111l);
	// index.setCpxssjjfjv3(111l);
	//	
	// index.setCpxssrv1(111l);
	// index.setCpxssrv2(111l);
	// index.setCpxssrv3(111l);
	//	
	// index.setCreatetime(new Date());
	//	
	// index.setCwfyv1(111l);
	// index.setCwfyv2(111l);
	// index.setCwfyv3(111l);
	//	
	// index.setDngdzctzljv1(111l);
	// index.setDngdzctzljv2(111l);
	// index.setDngdzctzljv3(111l);
	//	
	// index.setFzhjv1(111l);
	// index.setFzhjv2(111l);
	// index.setFzhjv3(111l);
	// index.setGdzcjzv1(111l);
	// index.setGdzcjzv2(111l);
	// index.setGdzcjzv3(111l);
	//	
	// index.setGlfyv1(111l);
	// index.setGlfyv2(111l);
	// index.setGlfyv3(111l);
	//	
	// index.setGyxsczv1(111l);
	// index.setGyxsczv2(111l);
	// index.setGyxsczv3(111l);
	//	
	// index.setGyzczv1(111l);
	// index.setGyzczv2(111l);
	// index.setGyzczv3(111l);
	//	
	// index.setGyzjzv1(111l);
	// index.setGyzjzv2(111l);
	// index.setGyzjzv3(111l);
	//	
	// index.setLrzev1(111l);
	// index.setLrzev2(111l);
	// index.setLrzev3(111l);
	//	
	// index.setLszev1(111l);
	// index.setLszev2(111l);
	// index.setLszev3(111l);
	//	
	// index.setLxzcv1(111l);
	// index.setLxzcv2(111l);
	// index.setLxzcv3(111l);
	//	
	// index.setMonth(1);
	//	
	// index.setQbcyryrsv1(111l);
	// index.setQbcyryrsv2(111l);
	// index.setQbcyryrsv3(111l);
	//	
	// index.setQbldzcv1(111l);
	// index.setQbldzcv2(111l);
	// index.setQbldzcv3(111l);
	//	
	//	
	// index.setSbtzv1(111l);
	// index.setSbtzv2(111l);
	// index.setSbtzv3(111l);
	//	
	// index.setStatus("0");
	//	
	// index.setUpdatetime(new Date());
	//	
	// index.setXcpczv1(111l);
	// index.setXcpczv2(111l);
	// index.setXcpczv3(111l);
	//	
	// index.setYear(2012);
	//	
	// index.setYjzzsv1(111l);
	// index.setYjzzsv2(111l);
	// index.setYjzzsv3(111l);
	//	
	// index.setYszkjev1(111l);
	// index.setYszkjev2(111l);
	// index.setYszkjev3(111l);
	//	
	// index.setZchjv1(111l);
	// index.setZchjv2(111l);
	// index.setZchjv3(111l);
	//	
	// try {
	// indexService.addIndex(index);
	// } catch (ServiceException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	//
	//

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public ZyCorporationProduct getCorporationProduct() {
		return corporationProduct;
	}

	public void setCorporationProduct(ZyCorporationProduct corporationProduct) {
		this.corporationProduct = corporationProduct;
	}

	public CorporationProductService getCorporationProductService() {
		return corporationProductService;
	}

	public void setCorporationProductService(
			CorporationProductService corporationProductService) {
		this.corporationProductService = corporationProductService;
	}

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public IndexProdService getIndexProdService() {
		return indexProdService;
	}

	public void setIndexProdService(IndexProdService indexProdService) {
		this.indexProdService = indexProdService;
	}
}
