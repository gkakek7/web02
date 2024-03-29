package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.db.CustomSqlSessionFactoryBulder;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements ProdDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBulder.getSqlSessionFactrory();
	@Override
	public int insertProd(ProdVO prod) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			int row = mapper.insertProd(prod);
			sqlSession.commit();
			return  row;
		}
	}
	@Override
	public int selectTotalRecord(PaginationInfo paging) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			return  mapper.selectTotalRecord(paging);
		}
	}
	
	@Override
	public List<ProdVO> selectProdList(PaginationInfo paging) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			return  mapper.selectProdList(paging);
		}
	}

	@Override
	public ProdVO selectProd(String prodId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			return  mapper.selectProd(prodId);
		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
			){
				ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
				int rw = mapper.updateProd(prod);
				sqlSession.commit();
				return  rw;
			}
	}

}
