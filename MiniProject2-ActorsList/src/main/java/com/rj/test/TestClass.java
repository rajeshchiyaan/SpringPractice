package com.rj.test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rj.controller.Controller;
import com.rj.controller.ControllerImpl;
import com.rj.vo.ActorVo;

public class TestClass {

	public static void main(String[] args) {
		ApplicationContext localContextPresent = null;
		ApplicationContext localContextBusiness = null;
		List<ActorVo> localAlActorVo = null;
		Controller localController = null;
		
		localContextBusiness = new ClassPathXmlApplicationContext("BusinessConfiguration.xml");
		localContextPresent = new ClassPathXmlApplicationContext(new String[]{"Presentation.xml"}, localContextBusiness);
		
		localController = localContextPresent.getBean("controller", ControllerImpl.class);
		
		try {
			localAlActorVo = localController.actorsList("Hero", "Director");
			localAlActorVo.forEach(vo->System.out.println(vo));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
