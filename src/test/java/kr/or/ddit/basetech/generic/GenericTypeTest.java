package kr.or.ddit.basetech.generic;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import kr.or.ddit.basetech.generic.material.Child;
import kr.or.ddit.basetech.generic.material.ExtendedHous;
import kr.or.ddit.basetech.generic.material.GrandParent;
import kr.or.ddit.basetech.generic.material.Parent;
import kr.or.ddit.basetech.generic.material.SampleHouse;

public class GenericTypeTest {
	@Test
	void test1() {
		SampleHouse<Child,Parent> house = new SampleHouse<>();
		Child person=new Child();
		house.setPerson(person);
		Parent p = house.casting1();
	}
	@Test
	void test2() {
		ExtendedHous house = new ExtendedHous();
		Parent p = house.casting2(Parent.class);
		GrandParent gp = house.casting2(GrandParent.class);
	}
	@Test
	void test3() {
		Child child=new Child();
		GrandParent gp = ExtendedHous.casting3(child, GrandParent.class);
		Parent p = ExtendedHous.casting3(gp, Parent.class);
		assertSame(gp,p);
		System.out.println(child);
		System.out.println(p);
		System.out.println(gp);
		
	}
}
