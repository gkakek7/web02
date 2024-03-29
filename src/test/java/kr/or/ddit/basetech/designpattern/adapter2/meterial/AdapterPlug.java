package kr.or.ddit.basetech.designpattern.adapter2.meterial;

public class AdapterPlug implements PluggableKST{
	public PluggableCN plugcn;

	public AdapterPlug(PluggableCN plugcn) {
		super();
		this.plugcn = plugcn;
	}
	
	@Override
	public void receiveElectricWithTwoLeg() {
		plugcn.receiveElectricWithhThreeLeg();
	}
	
}
