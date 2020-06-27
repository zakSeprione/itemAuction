package com.app.auction.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.auction.api.controller.ItemControllerBean;
import com.app.auction.api.entity.Item;
import com.app.auction.util.debug;

@RestController
public class ItemAPI {

	private ItemControllerBean itemCB;
	
	@PostMapping("/Item/SaveItem")
	public Map saveItem(@RequestBody Item item){
		debug.print("inside "+this.getClass()+" saveItem");
		Map transResponse = new HashMap();
		try {
			itemCB = new ItemControllerBean();
			transResponse.put("response", itemCB.createItem(item));
		} catch (NullPointerException e){	
			transResponse.put("response", transResponse);
			e.printStackTrace();
		} catch (Exception e) {
			transResponse.put("response", "Error in Creating Item");
			e.printStackTrace();
		}
		debug.print("leaving "+this.getClass()+" saveItem");
		return transResponse;
	}
	
	

	@PostMapping("/Item/UpdateItem")
	public Map updateItem(@RequestBody Item item){
		debug.print("inside "+this.getClass()+" saveItem");
		Map transResponse = new HashMap();
		try {
			itemCB = new ItemControllerBean();
			transResponse.put("response", itemCB.updateItem(item));
		} catch (NullPointerException e){	
			transResponse.put("response", transResponse);
			e.printStackTrace();
		} catch (Exception e) {
			transResponse.put("response", "Error in Creating Item");
			e.printStackTrace();
		}
		debug.print("leaving "+this.getClass()+" saveItem");
		return transResponse;
	}
	
	@PostMapping("/Item/GetItemAll")
	public Map getItemAll(){
		debug.print("inside "+this.getClass()+" getItemAll");
		Map transResponse = new HashMap();
		itemCB = new ItemControllerBean();
		transResponse.put("items", itemCB.getAllItem());
		debug.print("leaving "+this.getClass()+" getItemAll");
		return transResponse;
	}
	
	@PostMapping("/Item/GetItemById")
	public Map getItemById(@RequestBody Item item){
		debug.print("inside "+this.getClass()+" getItemById");
		Map transResponse = new HashMap();
		itemCB = new ItemControllerBean();
		transResponse.put("items", itemCB.getItemById(item.getItemName()));
		debug.print("leaving "+this.getClass()+" getItemById");
		return transResponse;
	}
	
}
