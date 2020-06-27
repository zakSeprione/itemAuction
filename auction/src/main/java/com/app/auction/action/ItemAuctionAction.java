package com.app.auction.action;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.auction.action.actionForm.ItemAuctionActionForm;
import com.app.auction.util.Path;
import com.app.auction.util.debug;



@Controller
public class ItemAuctionAction {
	
	
	@Autowired
    private Environment environment;
	
	@RequestMapping("/Auction")
	public String auction(Model model) {
		debug.print("execute ItemAuctionAction");
		//AdLogonActionForm login = new AdLogonActionForm();
		//model.addAttribute("login", login);
				
		return "itemAuction";
	}
	
	/*
	@RequestMapping(value = "/AuctionAPP/Auction")
	private String index(Model model){
		return this.auction(model);
	}
	*/
	@PostMapping("/Auction")
	private String executeLoginIndex(HttpServletRequest request, HttpSession sessions,Model model,@ModelAttribute ItemAuctionActionForm auctionForm){
	//	return this.executeLogin(request,sessions,model,frm);
		return "itemAuction";
	}
	
}
