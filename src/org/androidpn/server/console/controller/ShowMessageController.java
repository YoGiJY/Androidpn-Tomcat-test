/**
 * @author Yao
 * Show the message in the Server
 * 
 */
package org.androidpn.server.console.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.model.Notification;
import org.androidpn.server.service.NotificationService;
import org.androidpn.server.service.ServiceLocator;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ShowMessageController extends MultiActionController{
	
	 private NotificationService notificationService;
	 public void list(HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 //Notification notificationList;
		 String username = null;
		 username = request.getParameter("username").toString();
		 List<Notification> notifications =new ArrayList<Notification>();
		 notificationService = ServiceLocator.getNotificationService();
		 notifications=notificationService.queryNotificationByUser(username);
		 response.getWriter().print("{\"notification\":[");
		 for(int i=0;i<notifications.size();i++){
			 response.getWriter().print("{");
			 response.getWriter().print("\"id\":" +"\""+notifications.get(i).getId()+"\""+",");
			 response.getWriter().print("\"title\":"+"\""+notifications.get(i).getTitle()+"\","); 
			 response.getWriter().print("\"message\":"+"\""+notifications.get(i).getMessage()+"\","); 
			 response.getWriter().print("\"time\":" +"\""+notifications.get(i).getMessageTime()+"\","); 
			 response.getWriter().print("\"clientIp\":" +"\""+notifications.get(i).getClientIP()+"\","); 
			 response.getWriter().print("\"messageId\":"+"\""+notifications.get(i).getMessageId()+"\"},");
		 }
		 response.getWriter().print("{");
		 response.getWriter().print("\"id\":" +"\""+"END"+"\""+",");
		 response.getWriter().print("\"title\":"+"\""+"END"+"\","); 
		 response.getWriter().print("\"message\":"+"\""+"END"+"\","); 
		 response.getWriter().print("\"time\":" +"\"END\",");
		 response.getWriter().print("\"clientIp\":"+"\""+"END"+"\",");
		 response.getWriter().print("\"messageId\":"+"\""+"END"+"\"}");
		 response.getWriter().print("]}");
     }
}
