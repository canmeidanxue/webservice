package com.example.testwebservice2;

import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestWebservice2Activity extends Activity {

	// private static final String URL =
	// "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";
	private static final String URL = "http://180.166.29.82:8080/TTPOS/sales.asmx";
	private static final String NAMESPACE = "http://tempurl.org";
	// private static final String METHODNAME = "getMobileCodeInfo";
	private static final String METHODNAME = "postsalescreate";
	private EditText etPhoneNum;
	private Button btnQuery;
	private TextView tvResult;

	private void init() {
		etPhoneNum = (EditText) findViewById(R.id.phone_sec);
		btnQuery = (Button) findViewById(R.id.query_btn);
		tvResult = (TextView) findViewById(R.id.result_text);
		btnQuery.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ResponseOnClick();
			}
		});
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			String myData = msg.getData().getString("data");
			if (myData != null || !"".equals(myData)) {
				tvResult.setText(myData);
			}
		};
	};

	private void ResponseOnClick() {
		HttpThread thread = new HttpThread(handler);
		HashMap<String, Object> params = new HashMap<String, Object>();
		String phoneSec = etPhoneNum.getText().toString().trim();
		// 添加参数
		thread.doStart(URL, NAMESPACE, METHODNAME, params);

	}

	private class HttpThread extends Thread {
		Handler handler = null;
		String url = null;
		String namespace = null;
		String methodName = null;
		HashMap<String, Object> params = new HashMap<String, Object>();
		ProgressDialog progressDialog = null;

		// 构造函数
		public HttpThread(Handler handler) {
			this.handler = handler;
		}

		/**
		 * 启动线程
		 */
		public void doStart(String url, String namespace, String methodName, HashMap<String, Object> params) {
			this.url = url;
			this.namespace = namespace;
			this.methodName = methodName;
			this.params = params;
			progressDialog = ProgressDialog.show(TestWebservice2Activity.this, "提示", "正在请求请稍等...", true);
			this.start();
		}

		/**
		 * 线程运行
		 */
		@Override
		public void run() {
			System.out.println("jack");
			super.run();
			try {
				// web service 请求
				SoapObject result = (SoapObject) CallWebService();
				progressDialog.dismiss();
				// 构造数据
				String value = null;
				if (result != null && result.getPropertyCount() > 0) {
					for (int i = 0; i < result.getPropertyCount(); i++) {
						// SoapObject primitive = (SoapObject)
						// result.getProperty(0);
						// value = primitive.getProperty(0).toString();
						SoapObject primitive = (SoapObject) result.getProperty(i);
						value = primitive.getProperty(0).toString() + "&&" + value;
					}
					// 取消进度框
					// 构造消息
					Message message = handler.obtainMessage();
					Bundle bundle = new Bundle();
					bundle.putString("data", value);
					message.setData(bundle);
					handler.sendMessage(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private Object CallWebService() {
			return sendNromal(namespace,methodName,url);
			
//			return sendTest(namespace,"test_a_plus_b",url);

		}
	}
	
	private Object sendTest(String namespace,String methodName,String url)
	{
		String SOAP_ACTION = namespace + "/" + methodName;
		// 创建SoapObject实例
		SoapObject request = new SoapObject(namespace, methodName);
		// 生成调用web service 方法的soap请求消息
		// soapheader在这里
		SoapObject soapRequest =new SoapObject(namespace,"al_value2");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//		envelope.headerOut = new Element[1];
//		envelope.headerOut[0] = buildAuthHeader();
		envelope.dotNet = true;
		soapRequest.addProperty("astr_request", 1);
		soapRequest.addProperty("al_value2", 3);
		request.addSoapObject(soapRequest);
		// 发送请求
		System.out.print(request.getPropertyCount());
		Log.e("", "request   " + request.toString());
		envelope.setOutputSoapObject(request);
		HttpTransportSE transport = new HttpTransportSE(url);
		transport.debug = true;
		SoapObject result = null;
//		new MarshDouble().register(envelope);
		try {
			// web service请求
			transport.call(SOAP_ACTION, envelope);
			// result = (SoapObject) envelope.bodyIn;
			Log.e("", "result         " + envelope.getResponse().toString());
			result = (SoapObject) envelope.getResponse();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private Object sendNromal(String namespace,String methodName,String url)
	{
		String SOAP_ACTION = namespace + "/" + methodName;
		// 创建SoapObject实例
		SoapObject request = new SoapObject(namespace, methodName);
		// 生成调用web service 方法的soap请求消息
		// soapheader在这里

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//		envelope.headerOut = new Element[1];
//		envelope.headerOut[0] = buildAuthHeader();
		// 设置.net web service
		envelope.dotNet = true;
		// 请求参数
		SoapObject soapRequest =new SoapObject(namespace,"astr_request");
		SoapObject soapHead =new SoapObject(namespace,"header");
		soapHead.addProperty("username", "100283");
		soapHead.addProperty("password", "100283");
		soapHead.addProperty("messagetype", "SALESDATA");
		soapHead.addProperty("messageid", "332");
		soapHead.addProperty("version", "V332M");
		
		// 1.salestotal
		SoapObject salestotal = new SoapObject(NAMESPACE, "salestotal");
		salestotal.addProperty("txtime_hhmmss", "20141125");
		salestotal.addProperty("txdate_yyyymmdd", "111111");
		salestotal.addProperty("storecode", "100284");
		salestotal.addProperty("tillid", "01");
		salestotal.addProperty("txdocno", "T20141013007");
		salestotal.addProperty("cashier", "1022");
		salestotal.addProperty("salesman", "1022");
		// =============================================
		// 2.salesitems
		SoapObject salesitems = new SoapObject(NAMESPACE, "salesitems");
		SoapObject salesitem = new SoapObject(NAMESPACE, "salesitem");
		salesitem.addProperty("itemcode", "100290");
		salesitem.addProperty("qty", 1.00);
		salesitem.addProperty("netamount", 1.00);
		salesitems.addSoapObject(salesitem);
		// ========================================
		// 3. salestenders
		SoapObject salestenders = new SoapObject(NAMESPACE, "salestenders");
		SoapObject salestender = new SoapObject(NAMESPACE, "salestender");
		salestender.addProperty("tendercode", "CH");
		salestender.addProperty("payamount", 1);
		salestender.addProperty("baseamount", 1.00);
		salestenders.addSoapObject(salestender);
		soapRequest.addSoapObject(soapHead);
		soapRequest.addSoapObject(salestotal);
		soapRequest.addSoapObject(salesitems);
		soapRequest.addSoapObject(salestenders);
		request.addSoapObject(soapRequest);
		// 发送请求
		System.out.print(request.getPropertyCount());
		Log.e("", "request   " + request.toString());
		envelope.setOutputSoapObject(request);
		HttpTransportSE transport = new HttpTransportSE(url);
		transport.debug = true;
		SoapObject result = null;
//		new MarshDouble().register(envelope);
		try {
			// web service请求
			transport.call(SOAP_ACTION, envelope);
			String stringContent =transport.requestDump;
			result = (SoapObject) envelope.bodyIn;
			Log.e("", "result         " + stringContent);
//			result = (SoapObject) envelope.getResponse();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	private Element buildAuthHeader() {
		Element h = new Element().createElement(NAMESPACE, "header");
		Element username = new Element().createElement(NAMESPACE, "username");
		username.addChild(Node.TEXT, "100283");
		h.addChild(Node.ELEMENT, username);
		Element password = new Element().createElement(NAMESPACE, "password");
		password.addChild(Node.TEXT, "100283");
		h.addChild(Node.ELEMENT, password);
		Element messagetype = new Element().createElement(NAMESPACE, "messagetype");
		messagetype.addChild(Node.TEXT, "SALESDATA");
		h.addChild(Node.ELEMENT, messagetype);
		Element messageid = new Element().createElement(NAMESPACE, "messageid");
		messageid.addChild(Node.TEXT, "332");
		h.addChild(Node.ELEMENT, messageid);
		Element version = new Element().createElement(NAMESPACE, "version");
		version.addChild(Node.TEXT, "V332M");
		h.addChild(Node.ELEMENT, version);
		return h;
	}
}
