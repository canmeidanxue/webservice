package com.example.testwebservice2.bean;

import java.io.Serializable;

/**
 * 
 * @author blue_sky 
 */
public class SalesDelivery implements Serializable {
	private String receiver_name;
	private String receiver_country;
	private String receiver_province;
	private String receiver_city;
	private String receiver_district;
	private String receiver_address1;
	private String receiver_address2;
	private String receiver_address3;
	private String receiver_address4;
	private String receiver_postal;
	private String receiver_mobile;
	private String logisticscompany;
	private String logisticsdocno;
	private String expectdeliverydate_yyyymmdd;
	private String deliveryremarks;
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_country() {
		return receiver_country;
	}
	public void setReceiver_country(String receiver_country) {
		this.receiver_country = receiver_country;
	}
	public String getReceiver_province() {
		return receiver_province;
	}
	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}
	public String getReceiver_city() {
		return receiver_city;
	}
	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}
	public String getReceiver_district() {
		return receiver_district;
	}
	public void setReceiver_district(String receiver_district) {
		this.receiver_district = receiver_district;
	}
	public String getReceiver_address1() {
		return receiver_address1;
	}
	public void setReceiver_address1(String receiver_address1) {
		this.receiver_address1 = receiver_address1;
	}
	public String getReceiver_address2() {
		return receiver_address2;
	}
	public void setReceiver_address2(String receiver_address2) {
		this.receiver_address2 = receiver_address2;
	}
	public String getReceiver_address3() {
		return receiver_address3;
	}
	public void setReceiver_address3(String receiver_address3) {
		this.receiver_address3 = receiver_address3;
	}
	public String getReceiver_address4() {
		return receiver_address4;
	}
	public void setReceiver_address4(String receiver_address4) {
		this.receiver_address4 = receiver_address4;
	}
	public String getReceiver_postal() {
		return receiver_postal;
	}
	public void setReceiver_postal(String receiver_postal) {
		this.receiver_postal = receiver_postal;
	}
	public String getReceiver_mobile() {
		return receiver_mobile;
	}
	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}
	public String getLogisticscompany() {
		return logisticscompany;
	}
	public void setLogisticscompany(String logisticscompany) {
		this.logisticscompany = logisticscompany;
	}
	public String getLogisticsdocno() {
		return logisticsdocno;
	}
	public void setLogisticsdocno(String logisticsdocno) {
		this.logisticsdocno = logisticsdocno;
	}
	public String getExpectdeliverydate_yyyymmdd() {
		return expectdeliverydate_yyyymmdd;
	}
	public void setExpectdeliverydate_yyyymmdd(String expectdeliverydate_yyyymmdd) {
		this.expectdeliverydate_yyyymmdd = expectdeliverydate_yyyymmdd;
	}
	public String getDeliveryremarks() {
		return deliveryremarks;
	}
	public void setDeliveryremarks(String deliveryremarks) {
		this.deliveryremarks = deliveryremarks;
	}
	

}
