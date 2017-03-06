package org.androidpn.server.yao.point;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PointServiceImpl implements PointService{

	protected final Log log = LogFactory.getLog(getClass());
	private PointDao  pointDao;
	
    public void setPointDao(PointDao pointDao){
    	this.pointDao=pointDao;
    }
	   
	public void savePoint(Point point) {
		// TODO Auto-generated method stub
		pointDao.savePoint(point);
	}

	public void updatePoint(Point point) {
		// TODO Auto-generated method stub
		pointDao.updatePoint(point);
	}

	public void deletePoint(Long id) {
		// TODO Auto-generated method stub
		pointDao.deletePoint(id);
	}

	public Point queryPointById(Long id) {
		// TODO Auto-generated method stub
		return pointDao.queryPointById(id);
	}

	public List<Point> queryPointBymessageId(String messageId, String clientIp) {
		// TODO Auto-generated method stub
		return pointDao.queryPointBymessageId(messageId, clientIp);
	}

	public void createPoint(List<Point> points) {
		// TODO Auto-generated method stub
		for(Point point:points){
			savePoint(point);
		}
	}

	public List<Point> queryPoint() {
		// TODO Auto-generated method stub
		return pointDao.queryPoint();
	}
     
}
