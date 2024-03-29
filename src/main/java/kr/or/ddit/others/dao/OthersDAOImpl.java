package kr.or.ddit.others.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBulder;

public class OthersDAOImpl implements OthersDAO {
	private SqlSessionFactory sqlSessionFactory
			= CustomSqlSessionFactoryBulder.getSqlSessionFactrory();
	@Override
	public List<Map<String, Object>> selectLprodList() {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();
		){
			OthersDAO mapper = sqlSession.getMapper(OthersDAO.class);
			return mapper.selectLprodList();
		}
	}

	@Override
	public List<Map<String, Object>> selectBuyerList() {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();
		){
			OthersDAO mapper = sqlSession.getMapper(OthersDAO.class);
			return mapper.selectBuyerList();
		}
	}

}
