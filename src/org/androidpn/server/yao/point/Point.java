/**
 * @author Yao
 * this is the class about the Rplidar Data;
 */
package org.androidpn.server.yao.point;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apn_points")
public class Point  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;   //this is id for a point
	  
	  @Column(name = "messageId", length = 64) 
	  private String messageId; 
	  
	  @Column(name = "distance", length = 64) 
	  private String distance;
	  
	  @Column(name = "angle", length = 64) 
	  private String angle;
	  
	  @Column(name = "clientIp", length = 64) 
	  private String clientIp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getAngle() {
		return angle;
	}

	public void setAngle(String angle) {
		this.angle = angle;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
     
	
}
