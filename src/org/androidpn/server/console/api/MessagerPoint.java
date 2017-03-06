/**
 * @author Yao
 *这个类实现的是将收集的数据存储到服务器上。
 */
package org.androidpn.server.console.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.androidpn.server.model.Notification;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.androidpn.server.service.NotificationService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.yao.point.Point;
import org.androidpn.server.yao.point.PointService;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class MessagerPoint extends MultiActionController{
	
	 private  PointService pointService;
	 private NotificationService notificationService;
	      
	public void list(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	pointService= ServiceLocator.getPointService();
    	notificationService  = ServiceLocator.getNotificationService();
    	List<Notification> notifications =new ArrayList<Notification>();
    	String username=request.getParameter("username");
		 
    	notifications=notificationService.queryNotificationByUser(username);
    	
    	response.getWriter().println("<table align=\"center\" width=\"400\">");
    	response.getWriter().println("<tr align=\"center\"><th>Id</th><th>Angle</th><th>Distance</th></tr>");
		 for(int i=0;i<notifications.size();i++)
		 {
			 if((notifications.get(i).getId())>=300L&&(notifications.get(i).getId())<=650L)
			 {
				 
				 String str=notifications.get(i).getMessage().toString().trim();
				 String splitS[] = str.split(" ");
				 for(int j=0;j<splitS.length;j++)
				 {
					 String splitD[]=splitS[j].split(":");
					 if(Double.valueOf(splitD[0]) <=360)
					 {
					   response.getWriter().println("<tr align=\"center\"><td>"+notifications.get(i).getId()+"</td><td>"+splitD[0]+"</td><td>"+splitD[1]+"</td></tr>");	
					 }
					 else{
					  response.getWriter().println("<tr align=\"center\" bgcolor=\"red\"><td>"+notifications.get(i).getId()+"</td><td>"+splitD[0]+"</td><td>"+splitD[1]+"</td></tr>");	
					 }
				 }
			 }
		} 
		response.getWriter().println("</table>");
	}
}