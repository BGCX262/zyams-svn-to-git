package com.zhiye.test.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.ServiceException;

public class ServiceTest {
	private ApplicationContext applicationContext;

	protected String[] getConfigLocations() {
		return new String[] { "spring/spring-service.xml",
				"spring/spring-dao.xml" };
	}

	@Test
	public void testGetUserByName() {
		String[] locations = { "WebRoot/WEB-INF/spring/spring-service.xml",
				"WebRoot/WEB-INF/spring/spring-dao.xml" };
		ApplicationContext ctx = new FileSystemXmlApplicationContext(locations); // 加载单个配置文件

		// UserService userService = (UserService) ctx.getBean("userService");

		// ZyUser user=new ZyUser();
		// user.setActive("0");
		// user.setCompanyId(122);
		// user.setCreateTime(new Date());
		// user.setPassword("eeeee");
		// user.setPid(12);
		// user.setPosition("2222222");
		// user.setRemarks("remarks");
		// user.setRoleId(12);
		// user.setUpdateTime(new Date());
		// user.setUsername("lionest23");
		ArticleTypeService typeService = (ArticleTypeService) ctx
				.getBean("articleTypeService");
		for (int i = 0; i < 20; i++) {
			ZyArticleType zat=new ZyArticleType();
			zat.setCreateTime(new Date());
			zat.setParentId(0);
			zat.setTypeName("大多数"+i);
			zat.setUpdateTime(new Date());
			try {
				typeService.addArticleType(zat);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// userService.getUserByName("哈哈");
		Assert.assertNotNull(typeService);

	}
}
