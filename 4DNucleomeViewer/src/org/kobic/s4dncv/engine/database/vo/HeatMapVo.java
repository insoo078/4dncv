package org.kobic.s4dncv.engine.database.vo;

import java.io.Serializable;

public class HeatMapVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int bin;
	private int interactionPair;
	private float count;

	public int getBin() {
		return bin;
	}
	public void setBin(int bin) {
		this.bin = bin;
	}
	public int getInteractionPair() {
		return interactionPair;
	}
	public void setInteractionPair(int interactionPair) {
		this.interactionPair = interactionPair;
	}
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}

	public String getKey() {
		return this.bin + " " + this.interactionPair;
	}
	
	public HeatMapVo clone() {
		HeatMapVo vo = new HeatMapVo();
		vo.setBin( this.bin);
		vo.setInteractionPair( this.interactionPair );
		vo.setCount( this.count );
		return vo;
	}
	public void subtract(HeatMapVo vo) {
		this.count = this.count - vo.getCount();
	}
}
