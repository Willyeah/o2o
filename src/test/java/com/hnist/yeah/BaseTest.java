package com.hnist.yeah;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件在哪
@ContextConfiguration(locations = { "classpath:spring/spring-web.xml","classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
@WebAppConfiguration("src/main/resources")
public class BaseTest {

}
