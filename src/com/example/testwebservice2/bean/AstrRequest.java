package com.example.testwebservice2.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("astr_request")
public class AstrRequest {
	//标头
	private Header header;
	//销售开单主表
	@XStreamAlias("salestotal")
	private SalesTotal salesTotal;
	//销售开单明细表
	@XStreamAlias("salesitems")
	private List<SalesItem> salesItems;
	//销售开单付款明细表
	@XStreamAlias("salestenders")
	private List<SalesTender> salesTenders;
	//销售开单配送表
	@XStreamAlias("salesdlvy")
	private SalesDelivery salesDelivery;
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public SalesTotal getSalesTotal() {
		return salesTotal;
	}
	public void setSalesTotal(SalesTotal salesTotal) {
		this.salesTotal = salesTotal;
	}
	public List<SalesItem> getSalesItems() {
		return salesItems;
	}
	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}
	public List<SalesTender> getSalesTenders() {
		return salesTenders;
	}
	public void setSalesTenders(List<SalesTender> salesTenders) {
		this.salesTenders = salesTenders;
	}
	public SalesDelivery getSalesDelivery() {
		return salesDelivery;
	}
	public void setSalesDelivery(SalesDelivery salesDelivery) {
		this.salesDelivery = salesDelivery;
	}
	
	
	
	
	
	
	
}
