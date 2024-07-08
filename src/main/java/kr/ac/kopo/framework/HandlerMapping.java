package kr.ac.kopo.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import kr.ac.kopo.controller.ShoppingMallController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		
		Properties prop = new Properties();
		try(
//			InputStream is = new FileInputStream("C:\\Lecture\\web-workspace\\Mission-WEB-MVC01\\bean.properties");
			InputStream is = new FileInputStream(propLoc);
				
		){
			prop.load(is);
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className =prop.getProperty(key.toString());
				
				Class<?> clz = Class.forName(className);
//				clz.newInstance();//옛날버전
				Constructor<?> constructor = clz.getConstructor();
				Controller control =(Controller)constructor.newInstance();
				
				mappings.put(key.toString(), control);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
//		mappings.put("board/list.do", new BoardListController()); //controller를 상속받아서 둘중 하나 선택 객체를 상속받음
//		mappings.put("board/writeForm.do", new BoardWriteFormController());
		
	}
	public Controller getController(String uri) {
		return mappings.get(uri);
		}
}

/*
 * 2 
 *	new boardListController(); //전체적 시스템에서 필요하면 new 를 안하고 스프링이 만들도록 한다. -> bean
 *	<bean id = "list" class = "kr.co.mlec.controller.BoardListController"> //싱글턴 패턴으로 1개의 객체만 만들어진다.
 * </bean> 
 */



/* 1
 * switch(uri) {
			case "/board/list.do" :
				System.out.println("전체게시글 조회");
				control = new BoardListController();
				break;
			case "/board/writeForm.do":
				System.out.println("새글등록");
				control = new BoardWriteFormController();
				break;
			}
 * */

  

