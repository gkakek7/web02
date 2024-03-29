package kr.or.ddit.basetech.designpattern.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.basetech.designpattern.adapter.meterial.Adaptee;
import kr.or.ddit.basetech.designpattern.adapter.meterial.Adapter;
import kr.or.ddit.basetech.designpattern.adapter.meterial.Client;
import kr.or.ddit.basetech.designpattern.adapter.meterial.OtherConcrete;
import kr.or.ddit.basetech.designpattern.adapter.meterial.Target;

class AdapterPatternTest {
	@Test
	void test() {
		Client client = new Client();
		client.setTarget(new OtherConcrete());
		client.getTarget().request();
	}
	
	@Test
	void testUseAdaptee() {
		Client client = new Client();
		client.setTarget(new Adapter(new Adaptee()));
		client.getTarget().request();
	}
}
