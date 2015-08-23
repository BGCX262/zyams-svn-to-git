package com.zhiye.web.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.httpclient.params.HttpClientParams;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

public class WebServiceUtil {
	public static String sendInfo(Map<String, String> paramMap) {
		try {
			Client c = new Client(new URL(
					"http://zwgk.mas.gov.cn/zwgk/service/getClientInfo?wsdl"));
			Client c1 = new Client(new URL(
					"http://jxw.mas.gov.cn/bmsite/service/getClientInfo?wsdl "));
			StringBuffer sb = new StringBuffer();
			sb
					.append("<?xml version='1.0' encoding='utf-8'?><elements><gov><CLASSNAME>cn.sh.service.GovInfoService</CLASSNAME><METHODNAME>saveGovInfo</METHODNAME><TYPE>post</TYPE>");
			if (paramMap.get("categoryCode") != null) {
				sb.append("<categoryCode>" + paramMap.get("categoryCode")
						+ "</categoryCode>");
			}
			if (paramMap.get("navigationID") != null) {
				sb.append("<navigationID>" + paramMap.get("navigationID")
						+ "</navigationID>");
			}
			if (paramMap.get("title") != null) {
				sb.append("<title><![CDATA[" + paramMap.get("title")
						+ "]]></title>");
			}
			if (paramMap.get("data") != null) {
				sb.append("<data><![CDATA[" + paramMap.get("data")
						+ "]]></data>");
			}
			if (paramMap.get("keywords") != null) {
				sb.append("<keywords><![CDATA[" + paramMap.get("keywords")
						+ "]]></keywords>");
			}

			if (paramMap.get("orgCode") != null) {
				sb.append("<orgCode>" + paramMap.get("orgCode") + "</orgCode>");
			}
			if (paramMap.get("addTime") != null) {
				sb.append("<addTime>" + paramMap.get("addTime") + "</addTime>");
			}
			if (paramMap.get("orgType") != null) {
				sb.append("<orgType>" + paramMap.get("orgType") + "</orgType>");
			}
			sb.append("</gov></elements>");

			HttpClientParams params = new HttpClientParams();
			// 避免'Expect: 100-continue' handshake
			params.setParameter(HttpClientParams.USE_EXPECT_CONTINUE,
					Boolean.FALSE);
			// 设置ws连接超时时间
			params.setParameter(HttpClientParams.CONNECTION_MANAGER_TIMEOUT,
					5000l);
			c.setProperty(CommonsHttpMessageSender.HTTP_CLIENT_PARAMS, params);
			c1.setProperty(CommonsHttpMessageSender.HTTP_CLIENT_PARAMS, params);
			Object[] results = c.invoke("getClientInfo", new Object[] { sb
					.toString() });
			Object[] results1 = c1.invoke("getClientInfo", new Object[] { sb
					.toString() });
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "success";
	}

}
