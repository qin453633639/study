package com.lovego.user.util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ResponseUtil {
 	
	 
	public  static String writeResult(int id,String message ){
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		json.put("status", id);
		json.put("message", message);
		try {
			 
			return json.toString();
		} catch (Exception e) {
			return getJson(ReturnCode.C500).toString();
		}	 	 
	}

	public  static JSONObject writeResult(ReturnCode returnCode  ){
		PrintWriter out = null;
		 
		try {
			
			return getJson(returnCode);
		} catch (Exception e) {
			return getJson(ReturnCode.C500);
		}	 	 
	}
	
	public  static String writeResult(ReturnCode returnCode,JSONObject data ){
		PrintWriter out = null;
		try {
			 
			return getJson(returnCode, data).toString();
		} catch (Exception e) {
			return getJson(ReturnCode.C500).toString();
		}	 	 
	}
	
	
	public  static String writeResult(ReturnCode returnCode,JSONArray  data  ){
		PrintWriter out = null;
		try {
		 
			return getJson(returnCode, data).toString();
		} catch (Exception e) {
			
			return getJson(ReturnCode.C500).toString();
		}	 	 
	}
	
	public static JSONObject writeResult(ReturnCode returnCode, JSONArray data, int page, long totalPages, long totalCount,int pageSize) {
		PrintWriter out = null;
		try {
			 
			JSONObject json = getJson(returnCode, data);
			JSONObject childJson =  json.getJSONObject("data");
			childJson.put("page", page);
			childJson.put("totalPages", totalPages);
			childJson.put("totalCount", totalCount);
			childJson.put("pageSize", pageSize);
			return json;
		} catch (Exception e) {
			
			return getJson(ReturnCode.C500);
		}	 
	} 
	
	
	private static JSONObject getJson(ReturnCode returnCode){
		JSONObject json = new JSONObject();
		json.put("status", returnCode.getStatus());
		json.put("message", returnCode.getMessage());
		 
		return json;
	} 
	 
	private static JSONObject getJson(ReturnCode returnCode,JSONObject data){
		JSONObject json = new JSONObject();
		json.put("status", returnCode.getStatus());
		json.put("message", returnCode.getMessage());
		if(data != null){
			json.put("data", data);
		}
		 
		return json;
	} 
	
	private static JSONObject getJson(ReturnCode returnCode,  JSONArray  data){
		JSONObject json = new JSONObject();
		json.put("status", returnCode.getStatus());
		json.put("message", returnCode.getMessage());
		if(data != null){
			JSONObject temp = new JSONObject();
			temp.put("items", data);
			json.put("data", temp);
		}
		 
		return json;
	}

	 
	 
	
	
	 
	
}

