package kr.or.ddit.basetech.designpattern.adapter2.meterial;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SamsungProduct implements PluggableKST{

	@Override
	public void receiveElectricWithTwoLeg() {
		log.info("삼성");
	}

}
