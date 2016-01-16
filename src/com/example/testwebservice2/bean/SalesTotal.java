package com.example.testwebservice2.bean;

import java.io.Serializable;

/**
 * 
 * @author blue_sky ���ۿ�������
 */
public class SalesTotal implements Serializable {
	
	
	private String txdate_yyyymmdd;
	private String txtime_hhmmss;
	private String mallid;
	private String storecode;
	private String tillid;
	private String salestype;
	private String txdocno;
	private String mallitemcode;
	private String cashier;
	private String netqty;
	private String sellingamount;
	private double netamount;
	private String paidamount;
	private String issueby;
	private String issuedate_yyyymmdd;
	private String issuetime_hhmmss;
	private String salesman;
	
	
	
	public double getNetamount() {
		return netamount;
	}
	public void setNetamount(double netamount) {
		this.netamount = netamount;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getTxdate_yyyymmdd() {
		return txdate_yyyymmdd;
	}
	public void setTxdate_yyyymmdd(String txdate_yyyymmdd) {
		this.txdate_yyyymmdd = txdate_yyyymmdd;
	}
	public String getTxtime_hhmmss() {
		return txtime_hhmmss;
	}
	public void setTxtime_hhmmss(String txtime_hhmmss) {
		this.txtime_hhmmss = txtime_hhmmss;
	}
	public String getMallid() {
		return mallid;
	}
	public void setMallid(String mallid) {
		this.mallid = mallid;
	}
	public String getStorecode() {
		return storecode;
	}
	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}
	public String getTillid() {
		return tillid;
	}
	public void setTillid(String tillid) {
		this.tillid = tillid;
	}
	public String getSalestype() {
		return salestype;
	}
	public void setSalestype(String salestype) {
		this.salestype = salestype;
	}
	public String getTxdocno() {
		return txdocno;
	}
	public void setTxdocno(String txdocno) {
		this.txdocno = txdocno;
	}
	public String getMallitemcode() {
		return mallitemcode;
	}
	public void setMallitemcode(String mallitemcode) {
		this.mallitemcode = mallitemcode;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public String getNetqty() {
		return netqty;
	}
	public void setNetqty(String netqty) {
		this.netqty = netqty;
	}
	public String getSellingamount() {
		return sellingamount;
	}
	public void setSellingamount(String sellingamount) {
		this.sellingamount = sellingamount;
	}
	public String getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}
	public String getIssueby() {
		return issueby;
	}
	public void setIssueby(String issueby) {
		this.issueby = issueby;
	}
	public String getIssuedate_yyyymmdd() {
		return issuedate_yyyymmdd;
	}
	public void setIssuedate_yyyymmdd(String issuedate_yyyymmdd) {
		this.issuedate_yyyymmdd = issuedate_yyyymmdd;
	}
	public String getIssuetime_hhmmss() {
		return issuetime_hhmmss;
	}
	public void setIssuetime_hhmmss(String issuetime_hhmmss) {
		this.issuetime_hhmmss = issuetime_hhmmss;
	}
	
}
