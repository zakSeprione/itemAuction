package com.app.auction.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.app.auction.api.entity.Item;
import com.app.auction.util.Common;
import com.app.auction.util.constant;
import com.app.auction.util.debug;

public class DBAccess {

	public static void main(String[] args) {

		DBAccess db = new DBAccess();
		// db.createDBFile();
		db.readDBFile();

	}

	public JSONObject readDBFile() {
		JSONObject db = null;
		try (FileReader reader = new FileReader(constant.DB_FILE_NAME)) {
			// JSON parser object to parse read file
			JSONParser jsonParser = new JSONParser();
			// Read JSON file
			db = (JSONObject) jsonParser.parse(reader);
			debug.print("itemList:" + db);
		} catch (FileNotFoundException e) {
			Map itemList = new HashMap();
			this.createDBFile(itemList);
			this.readDBFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return db;

	}

	public String createDBFile(Map itemList) {
		debug.print("inside " + this.getClass() + " createDBFile");
		String response = Common.SUCCESSCODE;
		// Write JSON file
		try (FileWriter file = new FileWriter(constant.DB_FILE_NAME)) {
			if (itemList == null) {
				itemList = new HashMap();
			}
			this.clearDBFile();
			file.write(itemList.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
			response = Common.ERRCODE404;
		}
		debug.print("leaving " + this.getClass() + " createDBFile");
		return response;
	}

	public void clearDBFile() {
		debug.print("inside " + this.getClass() + " clearDBFile");
		try (FileWriter file = new FileWriter(constant.DB_FILE_NAME)) {
			file.write("");
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		debug.print("leaving " + this.getClass() + " clearDBFile");

	}

	public String insertToItemDB(Item item) {
		debug.print("inside " + this.getClass() + " insertToItemDB");
		String response = "";
		Map itemList = this.readDBFile();
		Map itemDetail = new HashMap();
		itemDetail.put("itemName", item.getItemName());
		itemDetail.put("itemDescription", item.getItemDescription());
		itemDetail.put("itemPrice", item.getItemPrice());
		itemDetail.put("itemDateClosing", item.getItemDateClosing());
		itemDetail.put("itemStartingPrice", item.getItemStartingPrice());
		itemDetail.put("itemStatus", item.getItemStatus());
		itemList.put(item.getItemName(), itemDetail);
		response = this.createDBFile(itemList);
		debug.print("leaving " + this.getClass() + " insertToItemDB");
		return response;
	}

	public Item getItembyItemName(String itemName) {
		debug.print("inside " + this.getClass() + " getItembyItemName");
		Map itemList = this.readDBFile();
		Item item = null;
		try {
			Map itemDetails = (Map) itemList.get(itemName);
			item = new Item(
					itemDetails.get("itemName").toString(), 
					itemDetails.get("itemDescription").toString(),
					Double.parseDouble(itemDetails.get("itemPrice").toString()), 
					itemDetails.get("itemDateClosing").toString(),
					Double.parseDouble(itemDetails.get("itemStartingPrice").toString()),
					itemDetails.get("itemStatus").toString());

		} catch (NullPointerException e) {
			debug.print("item " + itemName + " Not Found.");
		}
		debug.print("leaving " + this.getClass() + " getItembyItemName");
		return item;
	}

	public Map getItemAll() {
		debug.print("inside " + this.getClass() + " getItemAll");
		Map itemList = new HashMap();
		try {
			itemList = this.readDBFile();
		} catch (NullPointerException e) {
			debug.print("items Not Found.");
		}
		debug.print("leaving " + this.getClass() + " getItemAll");
		return itemList;
	}

	public String updateItemToDB(Item item) {
		debug.print("inside " + this.getClass() + " updateItemDB");
		String response = "";
		Map itemList = this.readDBFile();
		Map itemDetail = new HashMap();
		itemDetail.put("itemName", item.getItemName());
		itemDetail.put("itemDescription", item.getItemDescription());
		itemDetail.put("itemPrice", item.getItemPrice());
		itemDetail.put("itemDateClosing", item.getItemDateClosing());
		itemDetail.put("itemStartingPrice", item.getItemStartingPrice());
		itemDetail.put("itemStatus", item.getItemStatus());
		itemList.remove(item.getItemName());
		itemList.put(item.getItemName(), itemDetail);
		response = this.createDBFile(itemList);
		debug.print("leaving " + this.getClass() + " updateItemDB");
		return response;
	}

}
