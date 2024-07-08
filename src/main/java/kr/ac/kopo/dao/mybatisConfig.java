package kr.ac.kopo.dao;

import java.io.File;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisConfig {

	private SqlSession session;

	public mybatisConfig() {

		try {
			String resource = "kr/ac/kopo/dao/mybatis-config.xml";
			System.out.println(new File(resource).getAbsoluteFile());
			
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			session = sqlSessionFactory.openSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SqlSession getInstance() {
		return session;

	}
	
	public static void main(String[] args) {
		
		System.out.println(new mybatisConfig().getInstance());
		
	}
	

}
