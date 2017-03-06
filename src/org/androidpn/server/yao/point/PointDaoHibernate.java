/**
 * @author Yao
 * this is class about the PointDao in hibernate
 */

package org.androidpn.server.yao.point;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PointDaoHibernate extends HibernateDaoSupport implements PointDao{

	public void savePoint(Point point) {
		// TODO Auto-generated method stub
        getHibernateTemplate().saveOrUpdate(point);
        getHibernateTemplate().flush();
	}

	public void updatePoint(Point point) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(point);
		getHibernateTemplate().flush();
	}

	public void deletePoint(Long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(queryPointById(id));
	}
	
	public Point queryPointById(Long id) {
		// TODO Auto-generated method stub
		return (Point)getHibernateTemplate().get(Point.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Point> queryPointBymessageId(String messageId, String clientIp) {
		// TODO Auto-generated method stub
		Object[] param = new Object[]{messageId, clientIp};
		return getHibernateTemplate().find("from Point n where n.messageId=? and n.clientIp=? order by n.id desc", param);
	}

	public List<Point> queryPoint() {
		// TODO Auto-generated method stub
		return  getHibernateTemplate().find("from Point n order by n.id desc");
	}

}
