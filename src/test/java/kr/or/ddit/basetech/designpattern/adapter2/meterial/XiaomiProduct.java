package kr.or.ddit.basetech.designpattern.adapter2.meterial;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XiaomiProduct implements PluggableCN{

	@Override
	public void receiveElectricWithhThreeLeg() {
		log.info("샤오미");
	}

}
