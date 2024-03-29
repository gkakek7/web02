package kr.or.ddit.basetech.designpattern.adapter2.meterial;

public class ConcentKST {
	public PluggableKST plugin;

	public ConcentKST(PluggableKST plugin) {
		super();
		this.plugin = plugin;
	}
	public PluggableKST getPlugin() {
		return plugin;
	}
}
