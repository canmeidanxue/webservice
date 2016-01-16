package com.example.testwebservice2.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author blue_sky ���ۿ���������ϸ��
 */
@XStreamAlias("salestender")
public class SalesTender implements Serializable {
	private String lineno;
	private String tendercode;
	private String payamount;
	private String baseamount;
	public String getLineno() {
		return lineno;
	}
	public void setLineno(String lineno) {
		this.lineno = lineno;
	}
	public String getTendercode() {
		return tendercode;
	}
	public void setTendercode(String tendercode) {
		this.tendercode = tendercode;
	}
	public String getPayamount() {
		return payamount;
	}
	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}
	public String getBaseamount() {
		return baseamount;
	}
	public void setBaseamount(String baseamount) {
		this.baseamount = baseamount;
	}
	
}
