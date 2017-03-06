/**
 * @author Yao
 * this is class about PointDao
 */
package org.androidpn.server.yao.point;

import java.util.List;

public interface PointDao {
	/**
	 * 保存来自Point点和角度数据
	 */
      public void savePoint(Point point);
      
    /**
     * 更新来自Point数据
     * */
      public void updatePoint(Point point);
      
      /**
       * 删除Point数据
       */
      public void deletePoint(Long id);
     
    /**
     * 通过ID查找Point数据
     */
      
      public Point queryPointById(Long id);
      
      /**
       * 获取point
       */
      
      public List<Point> queryPoint();
      
      /**
       * 通过messageId和clientIp查询Point
       */
      
      public List<Point> queryPointBymessageId(String messageId,String clientIp);
      
      
}
