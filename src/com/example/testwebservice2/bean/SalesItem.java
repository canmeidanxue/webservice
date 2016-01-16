package com.example.testwebservice2.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author blue_sky 
 */
@XStreamAlias("salesitem")
public class SalesItem implements Serializable {
	private String iscounteritemcode;
	private String lineno;
	private String storecode;
	private String mallitemcode;
	private String counteritemcode;
	private String itemcode;
	private String plucode;
	private String qty;
	private String netamount;
	public String getIscounteritemcode() {
		return iscounteritemcode;
	}
	public void setIscounteritemcode(String iscounteritemcode) {
		this.iscounteritemcode = iscounteritemcode;
	}
	public String getLineno() {
		return lineno;
	}
	public void setLineno(String lineno) {
		this.lineno = lineno;
	}
	public String getStorecode() {
		return storecode;
	}
	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}
	public String getMallitemcode() {
		return mallitemcode;
	}
	public void setMallitemcode(String mallitemcode) {
		this.mallitemcode = mallitemcode;
	}
	public String getCounteritemcode() {
		return counteritemcode;
	}
	public void setCounteritemcode(String counteritemcode) {
		this.counteritemcode = counteritemcode;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getPlucode() {
		return plucode;
	}
	public void setPlucode(String plucode) {
		this.plucode = plucode;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getNetamount() {
		return netamount;
	}
	public void setNetamount(String netamount) {
		this.netamount = netamount;
	}
	
}
