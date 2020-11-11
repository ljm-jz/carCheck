package com.xnxy.carcheck.util;

public class SendMsgUtil {
	
	
	/*public static void sendMsg(String phone,String msg) throws Exception
	{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.api.smschinese.cn/"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid", "暗夜木影"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",phone),new NameValuePair("smsText",msg)};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
		System.out.println(result); //打印返回消息状态
		post.releaseConnection();
	}*/
	
	public static void main(String[] args) {
		try {
			/*sendMsg("13348656598", "【暗夜木影】您的身份证已到期，请提交最新身份证信息");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
