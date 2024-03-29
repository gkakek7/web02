package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.db.CustomSqlSessionFactoryBulder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	private SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBulder.getSqlSessionFactrory();
	@Override
	public MemberVO selectMemberForAuth(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", memId);
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			int row = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
			sqlSession.commit();
			return row;
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
		}
	}

	@Override
	public List<MemberVO> selectMemberList(PaginationInfo paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			List<MemberVO> list = mapper.selectMemberList(paging);
			return list;
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapper.updateMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
		 int rowcnt = sqlSession.delete("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", memId);
		 sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int selectTotalRecord(PaginationInfo paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			int rowcnt = sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectTotalRecord",paging);
			return rowcnt;
		}
	}

}
