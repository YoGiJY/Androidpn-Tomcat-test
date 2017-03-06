/**
 * @author Yao
 *这个类实现的是将收集的数据存储到服务器上。
 */
package org.androidpn.server.console.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.yao.point.Point;
import org.androidpn.server.yao.point.PointService;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PointController extends MultiActionController{
	
	 private  PointService pointService;
	      
    @SuppressWarnings("null")
	public void list(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	pointService= ServiceLocator.getPointService();
    	String distance;
    	String angle;
    	Point point = new Point();
    	distance = request.getParameter("distance");
    	angle = request.getParameter("angle");
    	
    	response.getWriter().println("distance:"+distance);
    	response.getWriter().println("angle:"+angle);
    	if(!distance.equals("")&&!angle.equals("")){
    		point.setAngle(angle);
    		point.setDistance(distance);
    		pointService.savePoint(point);
    		response.getWriter().println("The Point Is Success!");
    	}
    } 
}
