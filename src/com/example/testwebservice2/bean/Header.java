package com.example.testwebservice2.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 
 * @author blue_sky
 */
public class Header implements Serializable{
	private String licensekey;
	private String username;
	private String password;
	private String lang;
	private int pagerecords;
	private int pageno;
	private int updatecount;
	private String messagetype;
	private String messageid;
	private String version;
	public String getLicensekey() {
		return licensekey;
	}
	public void setLicensekey(String licensekey) {
		this.licensekey = licensekey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public int getPagerecords() {
		return pagerecords;
	}
	public void setPagerecords(int pagerecords) {
		this.pagerecords = pagerecords;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getUpdatecount() {
		return updatecount;
	}
	public void setUpdatecount(int updatecount) {
		this.updatecount = updatecount;
	}
	public String getMessagetype() {
		return messagetype;
	}
	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
