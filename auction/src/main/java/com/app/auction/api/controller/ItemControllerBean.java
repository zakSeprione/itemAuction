package com.app.auction.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.auction.api.entity.Item;
import com.app.auction.db.DBAccess;
import com.app.auction.util.Common;
import com.app.auction.util.constant;
import com.app.auction.util.debug;

public class ItemControllerBean {
	
	@Autowired
	private Item item;
	private DBAccess db;
	
	public Map getAllItem(){
		debug.print("inside "+this.getClass()+" getAllItem");
		Map response = new HashMap();
		db = new DBAccess();
		response = db.getItemAll();
		
		debug.print("leaving "+this.getClass()+" getAllItem");
		return response;
	}

	public Map getItemById(String itemName){
		debug.print("inside "+this.getClass()+" getItemById");
		Map response = new HashMap();
		db = new DBAccess();
		item = db.getItembyItemName(itemName);
		response.put(itemName, item);
		debug.print("leaving "+this.getClass()+" getItemById");
		return response;
	}
	
	public Map createItem(Item item){
		debug.print("inside "+this.getClass()+" createItem");
		Map response = new HashMap();
		try{
			db = new DBAccess();
			Item existItem = db.getItembyItemName(item.getItemName());
			if(existItem!=null){
				response.put("responseCode", Common.ERRCODE01);
				response.put("responseDesc", "Item "+item.getItemName()+" Already Exist");
			}else{
				String isItemCreate = db.insertToItemDB(item);
				response.put("responseCode", Common.SUCCESSCODE);
				response.put("responseDesc", Common.SUCCESSFUL);
			}
			
		} catch (NullPointerException e){	
			response.put("responseCode", Common.ERRCODE404);
			response.put("responseDesc", e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			response.put("responseCode", Common.ERRCODE404);
			response.put("responseDesc", "Error Upon Creating Item");
			e.printStackTrace();
		} 
		debug.print("leaving "+this.getClass()+" createItem");
		return response;
	}
	
	public Map updateItem(Item item){
		debug.print("inside "+this.getClass()+" createItem");
		Map response = new HashMap();
		try{
			db = new DBAccess();
			Item existItem = db.getItembyItemName(item.getItemName());
			if(existItem!=null){
				
				if(existItem.getItemStatus().equalsIgnoreCase(constant.ITEM_STATUS_CLOSED)){
					response.put("responseCode", Common.ERRCODE01);
					response.put("responseDesc", "Item "+item.getItemName()+" Status Already Closed.");
				}else{
					String isItemCreate = db.updateItemToDB(item);
					response.put("responseCode", Common.SUCCESSCODE);
					response.put("responseDesc", Common.SUCCESSFUL);
				}
				
			}else{
				response.put("responseCode", Common.ERRCODE01);
				response.put("responseDesc", "Item "+item.getItemName()+" Not Exist");
			}
			
		} catch (NullPointerException e){	
			response.put("responseCode", Common.ERRCODE404);
			response.put("responseDesc", e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			response.put("responseCode", Common.ERRCODE404);
			response.put("responseDesc", "Error Upon Creating Item");
			e.printStackTrace();
		} 
		debug.print("leaving "+this.getClass()+" createItem");
		return response;
	}
	
	

}
