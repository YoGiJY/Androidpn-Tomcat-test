/**
 * @author Yao
 * Show the message in the Server
 * 
 */
package org.androidpn.server.console.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ShowNotificationInServer extends MultiActionController{
	
	 public void list(HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 //Notification notificationList;
		 String username = null;
		 username = request.getParameter("username").toString();
		// Date createDate = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String driverName="com.mysql.jdbc.Driver"; 
		 String userName="root"; 
		 String userPasswd="111340125jy"; 
		 String dbName="test"; 
		 String tableName="apn_notification"; 
		 String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd; 
		 Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		 Connection connection=DriverManager.getConnection(url); 
		 Statement statement = connection.createStatement(); 
		 Statement state = connection.createStatement(); 
		 String sql="SELECT * FROM "+tableName+" WHERE username=\'"+username+"\'"+"ORDER BY id desc;"; 
		 ResultSet rs = state.executeQuery(sql); 
		 ResultSetMetaData rmeta = rs.getMetaData(); 
		 int numColumns=rmeta.getColumnCount(); 
		 response.getWriter().print("{\"notification\":[");
		 while(rs.next()) { 
			 response.getWriter().print("{");
			 response.getWriter().print("\"id\":" +"\""+rs.getString("id")+"\""+",");
			 response.getWriter().print("\"title\":"+"\""+rs.getString("title")+"\","); 
			 response.getWriter().print("\"message\":"+"\""+rs.getString("message")+"\","); 
			 response.getWriter().print("\"time\":" +"\""+rs.getString("messageTime")+"\"},");
		 } 
		 
		 response.getWriter().print("{");
		 response.getWriter().print("\"id\":" +"\""+"END"+"\""+",");
		 response.getWriter().print("\"title\":"+"\""+"END"+"\","); 
		 response.getWriter().print("\"message\":"+"\""+"END"+"\","); 
		 response.getWriter().print("\"time\":" +"\"END\"}");
		 response.getWriter().print("]}");
		 rs.close(); 
		 state.close(); 
		 connection.close();
		
     }
}
