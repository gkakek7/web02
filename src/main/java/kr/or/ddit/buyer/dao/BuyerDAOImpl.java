package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.db.CustomSqlSessionFactoryBulder;
import kr.or.ddit.vo.BuyerVO;

public class BuyerDAOImpl implements BuyerDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBulder.getSqlSessionFactrory();
	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try (
				SqlSession sqlSession =sqlSessionFactory.openSession();
		){
				BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
				return mapper.selectBuyer(buyerId);
		}
	}
	@Override
	public List<BuyerVO> selectBuyerList(PaginationInfo paging) {
		try (
				SqlSession sqlSession =sqlSessionFactory.openSession();
		){
				BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
				return mapper.selectBuyerList(paging);
		}
	}
	@Override
	public int selectTotalRecord(PaginationInfo paging) {
		try (
				SqlSession sqlSession =sqlSessionFactory.openSession();
		){
				BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
				return mapper.selectTotalRecord(paging);
		}
	}
	@Override
	public int insertBuyer(BuyerVO buyer) {
		try (
				SqlSession sqlSession =sqlSessionFactory.openSession();
		){
				BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
				int rw = mapper.insertBuyer(buyer);
				sqlSession.commit();
				return rw;
		}
	}

}
