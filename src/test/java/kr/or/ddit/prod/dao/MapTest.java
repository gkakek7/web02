package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MapTest {

	@Test
	void test() {
		String buyerName="한글컴퓨터";
		String buyerLgu="buyerLgu";
		String lprodGu="LPROD_GU";
		String lprodNm="LPROD_NM";
		Map<String, Object> buyerMap = new HashedMap();
		buyerMap.put("buyerName", buyerName);
		buyerMap.put("buyerLgu", buyerLgu);
		Map<String,Object> lprod = new HashedMap();
		buyerMap.put("hashMap", lprod);
		lprod.put("lprodGu", lprodGu);
		lprod.put("lprodNm", lprodNm);
		
		log.info("buyerMap{}",buyerMap);
	}

}
