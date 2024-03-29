package kr.or.ddit.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomSqlSessionFactoryBulder {
	private static SqlSessionFactory sqlSessionFactrory;
	static {
		String configFile="kr/or/ddit/mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(configFile);
			sqlSessionFactrory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new PersistenceException(e);
		}
	}
	public static SqlSessionFactory getSqlSessionFactrory() {
		return sqlSessionFactrory;
	}
}
