package kr.or.ddit.property.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class PropertyDAOImplTest {
	PropertyDAO dao = new PropertyDAOImpl();

	@Test
	void test() {
		PropertyVO newProp = new PropertyVO();
		newProp.setPropertyName("qewqewqew");
		newProp.setPropertyValue("qewqewqew");
		newProp.setDescription("qewqewqew");
		int insertProperty = dao.insertProperty(newProp);
		assertEquals(insertProperty, 1);
	}

}
