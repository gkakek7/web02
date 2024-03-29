package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerDAOImplTest {
	BuyerDAO dao = new BuyerDAOImpl();
	@Test
	void test() {
		BuyerVO selectBuyer = dao.selectBuyer("P10102");
		log.info("vo{}",selectBuyer);
	}

}
