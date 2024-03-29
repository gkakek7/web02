package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BuyerVO;

public class BuyerServiceImpl implements BuyerService {
	private BuyerDAO dao = new BuyerDAOImpl();
	@Override
	public BuyerVO retrieveBuyer(String buyerId) {
		return dao.selectBuyer(buyerId);
	}
	@Override
	public List<BuyerVO> retrieveBuyerList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectBuyerList(paging);
	}
	@Override
	public ServiceResult createBuyer(BuyerVO buyer) {
		ServiceResult result;
		result = dao.insertBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

}
