package org.crazyit.hrsystem.dao.impl;

import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.DriverDao;
import org.crazyit.hrsystem.domain.Driver;

import java.util.List;

public class DriverDaoHibernate4 extends BaseDaoHibernate4<Driver> implements DriverDao{

	@Override
	public List<Driver> findDriverrange(String range) {
		// TODO Auto-generated method stub
		return find("select e from Driver e where e.driverrange like %?0% and e.status=1" 
				, range);
	}

	@Override
	public List<Driver> findDrivering() {
		// TODO Auto-generated method stub
		return find("select e from Driver e where e.status=1");
	}

	@Override
	public boolean updateDriverrange(String name, int driverrange) {
		// TODO Auto-generated method stub
		Driver temp=findByName(name);
		if(null!=temp){
			temp.setDriverrange(driverrange);
			return true;
			}
			return false;
	}

	@Override
	public Driver findByName(String name) {
		// TODO Auto-generated method stub
		List<Driver> emps = find("select e from Driver e where e.name = ?0"
				, name);
			if (emps!= null && emps.size() >= 1)
			{
				return emps.get(0);
			}
			return null;
	}

	@Override
	public boolean updateStatus(String name, int status) {
		// TODO Auto-generated method stub
		Driver temp=findByName(name);
		if(null!=temp){
			temp.setStatus(status);
			return true;
			}
			return false;
	}

	@Override
	public boolean updatePhoneStatus(String phone, int status,int pointX,int pointY) {
		Driver temp=findByPhone(phone);
		if(null!=temp){
			temp.setStatus(status);
			temp.setPointX(pointX);
			temp.setPointY(pointY);
			return  true;
		}
		return false;
	}

	@Override
	public List<Driver> findDriver() {
		// TODO Auto-generated method stub
		return find("select e from Driver e");
	}

	@Override
	public List<Driver> findByNameAndPass(Driver driver) {
		// TODO Auto-generated method stub
		return find("select p from Driver p where p.name = ?0 and p.pass=?1"
				, driver.getName() , driver.getPass());
	}

	@Override
	public Driver findByPhone(String phone) {
		// TODO Auto-generated method stub
		List<Driver> emps = find("select e from Driver e where e.phone = ?0"
				,phone);
			if (emps!= null && emps.size() >= 1)
			{
				return emps.get(0);
			}
			return null;
	}

	@Override
	public List<Driver> searchNearDriver(int pointX, int pointY) {
		// TODO Auto-generated method stub
		return find("select e from Driver e where e.pointX between ?0 and ?1 and e.pointY between ?2 and ?3"
				,pointX-20000,pointX+20000,pointY-20000,pointY+20000);
	}

	@Override
	public boolean updatePassword(String phone, String pass) {
		List<Driver> emp=find("select p from Driver p where p.phone=?0",phone);
		if (emp!=null&&emp.size()>=1){
			Driver temp=emp.get(0);
			temp.setPass(pass);
			this.save(temp);
			return  true;
		}
		return false;
	}

}
