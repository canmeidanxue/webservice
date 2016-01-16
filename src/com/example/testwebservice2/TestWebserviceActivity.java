package com.example.testwebservice2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.testwebservice2.bean.AstrRequest;
import com.example.testwebservice2.bean.Header;
import com.example.testwebservice2.bean.SalesDelivery;
import com.example.testwebservice2.bean.SalesItem;
import com.example.testwebservice2.bean.SalesTender;
import com.example.testwebservice2.bean.SalesTotal;
import com.thoughtworks.xstream.XStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class TestWebserviceActivity extends Activity {
	private TextView showTextView;
	private static final String URL = "http://180.166.29.82:8080/TTPOS/sales.asmx?wsdl";

	private static final String WPCharset = "UTF-8";
	private static final String XmlContentType = "application/soap+xml";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_webservice);
		showTextView = (TextView) findViewById(R.id.request);
		findViewById(R.id.request).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						putRequest();
					}
				}).start();
			}

		});
	}
	
	private void putRequest() {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(URL);
		try {
			byte[] b = beanConvertXml().getBytes("utf-8");
			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			InputStreamEntity re=new InputStreamEntity(is, is.available());//ContentType.create(XmlContentType, WPCharset)
			re.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, XmlContentType));
			httpPost.setEntity(re);
			HttpResponse response=  httpClient.execute(httpPost);
			 if (response.getStatusLine().getStatusCode() == 200) { 
	                // 第三步，使用getEntity方法活得返回结果 
	                String result = EntityUtils.toString(response.getEntity()); 
	                System.out.println("result:" + result); 
	               Toast.makeText(TestWebserviceActivity.this, "result:"+response.getStatusLine().getStatusCode()+ result,Toast.LENGTH_SHORT).show(); 
	            } 
			System.out.println("response   "+response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 将实体转化为xml
	private String beanConvertXml() {
		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		String data = stream.toXML(getRequest()).replaceAll("__", "_");
		String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><postsalescreate xmlns=\"http://tempurl.org\">";
		soapRequestData += data;
		soapRequestData += " </postsalescreate></soap12:Body></soap12:Envelope>";
		System.out.println(soapRequestData);
		return soapRequestData;
	}

	// 拼接请求实体
	private AstrRequest getRequest() {
		AstrRequest astrRequest = new AstrRequest();
		astrRequest.setHeader(getHeader());
		astrRequest.setSalesTotal(getSalesTotal());
		astrRequest.setSalesItems(getSalesItem());
		astrRequest.setSalesTenders(getSalesTender());
		astrRequest.setSalesDelivery(getSaleDelivery());
		return astrRequest;

	}

	private Header getHeader() {
		Header header = new Header();
		header.setLicensekey("");
		header.setUsername("010201");
		header.setPassword("010201");
		header.setLang("");
		header.setPagerecords(100);
		header.setPageno(1);
		header.setUpdatecount(0);
		header.setMessagetype("SALESDATA");
		header.setMessageid("332");
		header.setVersion("V332M");
		return header;
	}

	private SalesTotal getSalesTotal() {
		SalesTotal salesTotal = new SalesTotal();
		salesTotal.setTxtime_hhmmss("113320");
		salesTotal.setTxdate_yyyymmdd("20151211");
		salesTotal.setMallid("5012");
		// Web服务系统需要校验该店铺的有效性
		salesTotal.setStorecode("A00001");
		salesTotal.setTillid("01");

		salesTotal.setSalestype("SA");
		salesTotal.setMallitemcode("2015101111332");

		// Web服务系统如果判断到此单号的记录已经存在，返回错误信息
		salesTotal.setTxdocno("1332");
		salesTotal.setCashier("1022");
		salesTotal.setSalesman("1022");

		salesTotal.setNetqty("1.00");
		salesTotal.setSellingamount("1.00");
		salesTotal.setNetamount(1.00);

		salesTotal.setPaidamount("1.00");
		salesTotal.setIssueby("lxp");
		salesTotal.setIssuedate_yyyymmdd("20151011");
		salesTotal.setTxtime_hhmmss("113320");
		return salesTotal;
	}

	private List<SalesItem> getSalesItem() {
		List<SalesItem> items = new ArrayList<SalesItem>();
		SalesItem salesItem = new SalesItem();
		salesItem.setItemcode("A000011");
		salesItem.setQty("1.00");
		salesItem.setNetamount("1.00");
		items.add(salesItem);
		return items;
	}

	private List<SalesTender> getSalesTender() {
		List<SalesTender> salesTenders = new ArrayList<SalesTender>();
		SalesTender salesTender = new SalesTender();
		salesTender.setTendercode("CH");
		salesTender.setPayamount("1.00");
		salesTender.setBaseamount("1.00");
		salesTenders.add(salesTender);
		return salesTenders;
	}

	private SalesDelivery getSaleDelivery() {
		SalesDelivery salesDelivery = new SalesDelivery();
		salesDelivery.setReceiver_name("李小鹏");
		return salesDelivery;
	}
}
