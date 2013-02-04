package com.alone.mitnick.taobao;


import org.json.JSONObject;

import android.util.Log;

import com.alone.mitnick.constant.Constant;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemcatsGetRequest;
import com.taobao.api.request.TaobaokeItemsGetRequest;
import com.taobao.api.response.ItemcatsGetResponse;
import com.taobao.api.response.TaobaokeItemsGetResponse;
/**
 * 
 * @author Mitnick
 *
 */
public class TaoBaoKeAPI {
	
	public void getTaobaokeItems(){
		TaobaoClient client=new DefaultTaobaoClient(Constant.TAOBAO_APP_API_URL, Constant.APP_KEY, Constant.APP_SECRET);
		TaobaokeItemsGetRequest req=new TaobaokeItemsGetRequest();
		req.setFields("num_iid");
		req.setNick("jay");
		req.setPid(123456L);
		req.setKeyword("abc");
		req.setCid(123L);
		req.setStartPrice("1");
		req.setEndPrice("999");
		req.setAutoSend("true");
		req.setArea("杭州");
		req.setStartCredit("1heart");
		req.setEndCredit("1heart");
		req.setSort("price_desc");
		req.setGuarantee("true");
		req.setStartCommissionRate("1234");
		req.setEndCommissionRate("2345");
		req.setStartCommissionNum("1000");
		req.setEndCommissionNum("10000");
		req.setStartTotalnum("1");
		req.setEndTotalnum("10");
		req.setCashCoupon("true");
		req.setVipCard("true");
		req.setOverseasItem("true");
		req.setSevendaysReturn("true");
		req.setRealDescribe("true");
		req.setOnemonthRepair("true");
		req.setCashOndelivery("true");
		req.setMallItem("true");
		req.setPageNo(1L);
		req.setPageSize(40L);
		req.setOuterCode("abc");
		req.setIsMobile(true);
		try {
			TaobaokeItemsGetResponse response = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	
	public void getItemcats(){
		TaobaoClient client=new DefaultTaobaoClient(Constant.TAOBAO_APP_API_URL, Constant.APP_KEY, Constant.APP_SECRET);
		ItemcatsGetRequest req=new ItemcatsGetRequest();
		req.setFields("cid,parent_cid,name,is_parent");
		req.setParentCid(0L);
		try {
			ItemcatsGetResponse response = client.execute(req);
			System.out.println(response.getBody());
			JSONObject jsonObject = new JSONObject(response.getBody()).getJSONObject("itemcats_get_response");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TaoBaoKeAPI api = new TaoBaoKeAPI();
		api.getItemcats();
	}
}
