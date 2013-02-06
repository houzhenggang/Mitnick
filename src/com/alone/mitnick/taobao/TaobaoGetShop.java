package com.alone.mitnick.taobao;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.util.Log;

import com.alone.mitnick.constant.Constant;
import com.taobao.top.android.TopAndroidClient;
import com.taobao.top.android.TopParameters;
import com.taobao.top.android.api.ApiError;
import com.taobao.top.android.api.TopApiListener;

/**
 * 
 * @author Alone
 *
 */
public class TaobaoGetShop {
	
	private String mes;
	
	public String getShopList(TopAndroidClient client,long userId){
		TopParameters params = new TopParameters();
		//API方法
		params.setMethod("taobao.taobaoke.items.get");
		//返回字段
		params.addFields("num_iid,title,nick,pic_url,price,click_url,commission,commission_rate,commission_num,commission_volume,shop_click_url,seller_credit_score,item_location,volume");
		//封装参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("is_mobile", "true");
		map.put("page_size", "40");
		map.put("cid", "2813");
		params.setParams(map);
		
		client.api(params, userId, new TopApiListener() {
			@Override
			public void onException(Exception e) {
				Log.e(Constant.TAG, e.getMessage());
			}
			
			@Override
			public void onError(ApiError error) {
				Log.e(Constant.TAG, error.toString());
			}
			
			@Override
			public void onComplete(JSONObject json) {
				Log.e(Constant.TAG, json.toString());
				mes = json.toString();
			}
		}, true);
		return mes;
	}
}
