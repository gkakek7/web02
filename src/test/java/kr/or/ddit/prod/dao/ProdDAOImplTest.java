package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOImplTest {
	ProdDAO dao = new ProdDAOImpl();
	@Test
	void test() {
		ProdVO prod = dao.selectProd("P101000001");
		assertNotNull(prod);
		assertNotNull(prod.getLprod());
		log.info("prod{}",prod);
	}
}
