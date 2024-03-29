package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.BuyerVO;

public interface BuyerDAO {
	/**
	 * 제조사 조회
	 * @param buyerId
	 * @return 없으면, null 반환
	 */
	public BuyerVO selectBuyer(@Param("buyerId") String buyerId);
	public List<BuyerVO> selectBuyerList(PaginationInfo paging);
	public int selectTotalRecord(PaginationInfo paging);
	public int insertBuyer(BuyerVO buyer);
}
