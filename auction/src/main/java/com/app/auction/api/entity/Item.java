package com.app.auction.api.entity;

public class Item {

	private String itemName;
	private String itemDescription;
	private double itemPrice;
	private String itemDateClosing;
	private double itemStartingPrice;
	private String itemStatus;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDateClosing() {
		return itemDateClosing;
	}
	public void setItemDateClosing(String itemDateClosing) {
		this.itemDateClosing = itemDateClosing;
	}
	
	public double getItemStartingPrice() {
		return itemStartingPrice;
	}
	public void setItemStartingPrice(double itemStartingPrice) {
		this.itemStartingPrice = itemStartingPrice;
	}
	
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Item(){
		;
	}
	public Item(String itemName, String itemDescription, double itemPrice, String itemDateClosing, double itemStartingPrice, String itemStatus) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemDateClosing = itemDateClosing;
		this.itemStartingPrice = itemStartingPrice;
		this.itemStatus = itemStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
