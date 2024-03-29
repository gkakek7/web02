package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BuyerVO;

public interface BuyerService {
	/**
	 * 제조사 상세 조회
	 * @param buyerId
	 * @return 없으면, 예외 발생
	 */
	public BuyerVO retrieveBuyer(String buyerId);
	public List<BuyerVO> retrieveBuyerList(PaginationInfo paging);
	public ServiceResult createBuyer(BuyerVO buyer);
}
