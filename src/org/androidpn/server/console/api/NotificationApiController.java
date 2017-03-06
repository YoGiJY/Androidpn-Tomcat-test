//
//  NotificationApiController.java
//  FeOA
//
//  Created by LuTH on 2012-4-1.
//  Copyright 2012 flyrise. All rights reserved.
//

package org.androidpn.server.console.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.util.Config;
import org.androidpn.server.xmpp.push.NotificationManager;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NotificationApiController extends MultiActionController {

    private NotificationManager notificationManager;

    public NotificationApiController() {
        notificationManager = new NotificationManager();
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        // mav.addObject("list", null);
        mav.setViewName("api/apiform"); 
        return mav;
    }

    public void send(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try{
		 String broadcast ;
	     String username;
	     String title; 
	     String message; 
	     String uri ;
	     
		 broadcast = request.getParameter("broadcast");
//	     username = "username";
//	     title = "title";
//	     message = "message";
//	     uri = "uri";
	     username = request.getParameter("username");
	     title = request.getParameter("title");
	     message = request.getParameter("message");
	     uri = request.getParameter("uri");

        String apiKey = Config.getString("apiKey", "");
        logger.debug("apiKey=" + apiKey);

        if (broadcast.equalsIgnoreCase("Y")) {
            notificationManager.sendBroadcastToOnline(apiKey, title, message, uri);
        } else if (broadcast.equalsIgnoreCase("A")) {
            notificationManager.sendBroadcastToAll(apiKey, title, message, uri);
        } else {
            notificationManager.sendNotifcationToUser(apiKey, username, title, message, uri);
        }
        
        response.getWriter().print("{\"result\":\"1\",\"description\":\"Success\"}");
        
        }catch(Exception e){
        	 response.getWriter().print("{\"result\":\"0\",\"description\":\"Fail\",\""+e+"\"}");
        }
        // ModelAndView mav = new ModelAndView();
        // mav.setViewName("redirect:notification.do");
        // return mav;
    }
    
   }
