package kr.or.ddit.basetech.designpattern.adapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.basetech.designpattern.adapter2.meterial.AdapterPlug;
import kr.or.ddit.basetech.designpattern.adapter2.meterial.ConcentKST;
import kr.or.ddit.basetech.designpattern.adapter2.meterial.LGProduct;
import kr.or.ddit.basetech.designpattern.adapter2.meterial.PluggableKST;
import kr.or.ddit.basetech.designpattern.adapter2.meterial.RoomKST;
import kr.or.ddit.basetech.designpattern.adapter2.meterial.SamsungProduct;
import kr.or.ddit.basetech.designpattern.adapter2.meterial.XiaomiProduct;

class ConcentTest {
	@Test
	void test() {
		RoomKST room = new RoomKST(new ConcentKST(new LGProduct()));
		ConcentKST content = room.getContent();
		PluggableKST plugin = content.getPlugin();
		plugin.receiveElectricWithTwoLeg();
	}
	
	@Test
	void test1() {
		RoomKST room = new RoomKST(new ConcentKST(new SamsungProduct()));
		ConcentKST content = room.getContent();
		PluggableKST plugin = content.getPlugin();
		plugin.receiveElectricWithTwoLeg();
	}
	
	@Test
	void test2() {
		RoomKST room = new RoomKST(new ConcentKST(new AdapterPlug(new XiaomiProduct())));
		ConcentKST content = room.getContent();
		PluggableKST plugin = content.getPlugin();
		plugin.receiveElectricWithTwoLeg();
	}
}
