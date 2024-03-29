package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import kr.or.ddit.others.dao.OthersDAO;
import kr.or.ddit.others.dao.OthersDAOImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class OthersDAOImplTest {
	OthersDAO dao = new OthersDAOImpl();
	@Test
	void test() {
		dao.selectLprodList().stream()
		.forEach((m)->{
			log.info("{}",m);
		});
		
	}
	@Test
	void test1() {
		dao.selectBuyerList().stream()
		.forEach((m)->{
			log.info("{}",m);
		});
	}

}