/**
 * @author Yao
 * this is a class about PointDaoHibernate
 */
package org.androidpn.server.yao.point;

import java.util.List;


public interface PointService {
	
      public void savePoint(Point point);

      public void updatePoint(Point point);
      
      public void deletePoint(Long point);
     
      public Point queryPointById(Long id);

      public void createPoint(List<Point> points);
      
      public List<Point> queryPointBymessageId(String messageId,String clientIp);
      
      public List<Point> queryPoint();
}
