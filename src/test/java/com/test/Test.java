package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joyreach.h5.web.service.IVipBookService;

public class Test {

  public static void main(String[] args) {

    String[] path = { "/spring/applicationContext.xml", "/spring/applicationContext-persistence.xml", "/spring/applicationContext-dao.xml",
        "/spring/applicationContext-service.xml", "/spring/applicationContext-cache.xml" };
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
    // ApplicationContext ac1 = new FileSystemXmlApplicationContext(path);
    IVipBookService s = (IVipBookService) beanFactory.getBean("vipBookService");

  }
}
