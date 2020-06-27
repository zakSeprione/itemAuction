package com.app.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.auction.util.debug;

@SpringBootApplication
public class AuctionApplication {

	public static void main(String[] args) {
		debug.print("AuctionAPP Application BootUP");
		System.setProperty("server.servlet.context-path", "/AuctionAPP");
		SpringApplication.run(AuctionApplication.class, args);
		debug.print("AuctionAPP Application BootUP DONE");
	}

}
