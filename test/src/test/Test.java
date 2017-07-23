package test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Test extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dddddddddddddddddddddddddddddddddd");
		/* 공통부분 */

		URL url = new URL("http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=728");
		//URL url = new URL("https://api.bithumb.com/public/ticker/ALL");
		InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
		JSONObject object = (JSONObject) JSONValue.parse(isr);

		System.out.println("ggggggggggggggggggggggggggg");
		
//		System.out.println("jObj : " + object.toString());
//		System.out.println("returnValue : " + object.get("returnValue"));
//		System.out.println("drwtNo1 : " + object.get("drwtNo1"));
//		System.out.println("drwtNo2 : " + object.get("drwtNo2"));
//		System.out.println("drwtNo3 : " + object.get("drwtNo3"));
//		System.out.println("drwtNo4 : " + object.get("drwtNo4"));
//		System.out.println("drwtNo5 : " + object.get("drwtNo5"));
//		System.out.println("drwtNo6 : " + object.get("drwtNo6"));
//		System.out.println("bnusNo : " + object.get("bnusNo"));

		
		
//		System.out.println("dddddddddddddddddddddddddddddddddd");
//		System.out.println(url);

//		/* Object로 받을 경우 */
//
//		JSONObject head = (JSONObject) object.get("head");
//		System.out.println(head.get("code").toString());
//		System.out.println(head.get("adjust").toString());
//		System.out.println(head.get("ADMIN_ADDR").toString());
//		System.out.println(head.get("RETCODE").toString());

//		JSONArray bodyArray = (JSONArray) object.get("data");
//
//		for (int i = 0; i < bodyArray.size(); i++)
//		{
//			JSONObject data = (JSONObject) bodyArray.get(i);
//			System.out.println(data.get("opening_price").toString());
//			System.out.println(data.get("min_price").toString());
//			System.out.println(data.get("max_price").toString());
//			System.out.println(data.get("average_price").toString());
//			System.out.println(data.get("units_traded").toString());
//			System.out.println(data.get("volume_1day").toString());
//			System.out.println(data.get("volume_7day").toString());
//			System.out.println(data.get("buy_price").toString());
//			System.out.println(data.get("sell_price").toString());
//		}
//	}
	}
}
