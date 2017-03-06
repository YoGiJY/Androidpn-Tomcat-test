package org.androidpn.server.console.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.yao.point.Point;
import org.androidpn.server.yao.point.PointService;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ShowPointController extends MultiActionController{

	  private PointService pointService;
	  public void list(HttpServletRequest request,HttpServletResponse response) throws IOException{
		  pointService = ServiceLocator.getPointService();
		  String clientIp = new String();
		  String messageId = new String();
		  List <Point> points = new ArrayList<Point>();
//		  clientIp=request.getParameter("clientIp");
//		  messageId = request.getParameter("messageId");
		  points = pointService.queryPoint();
		  response.getWriter().print("{\"point\":[");
		  for(int i=0;i<points.size();i++){
			  response.getWriter().print("{\"distance\":"+"\""+points.get(i).getDistance()+"\",");
			  response.getWriter().print("\"angle\":"+"\""+points.get(i).getAngle()+"\"},");
		  }
			 response.getWriter().print("{");
			 response.getWriter().print("\"distance\":" +"\""+"END"+"\""+",");
			 response.getWriter().print("\"angle\":"+"\""+"END"+"\"}"); 
			 response.getWriter().print("]}");
	  }
}
