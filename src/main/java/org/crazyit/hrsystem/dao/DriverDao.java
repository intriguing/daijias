package org.crazyit.hrsystem.dao;

import java.util.List;

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Driver;
public interface DriverDao extends BaseDao<Driver>{
	List<Driver> findDriverrange(String range);
	List<Driver> findDrivering();
	public Driver findByName(String name);
	boolean updateDriverrange(String name,int driverrange);
	boolean updateStatus(String phone,int status);
	boolean updatePhoneStatus(String phone,int status,int pointX,int pointY);
	List<Driver> findDriver();
	List<Driver> findByNameAndPass(Driver driver);
	Driver  findByPhone(String phone);
	List<Driver> searchNearDriver(int pointX,int pointY);
	boolean updatePassword(String phone,String pass);
}
