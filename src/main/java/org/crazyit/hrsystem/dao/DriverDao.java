package org.crazyit.hrsystem.dao;

import java.util.List;

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Driver;
public interface DriverDao extends BaseDao<Driver>{
	List<Driver> findDriverrange(String range);
	List<Driver> findDrivering();
	Driver findByName(String name);
	Driver findById(String id);
	boolean updateDriverrange(String name,int driverrange);
	boolean updateStatus(String phone,int status);
	boolean updatePhoneStatus(String phone,int status,int pointX,int pointY);
	List<Driver> findDriver();
	List<Driver> findByKey(String key);
	List<Driver> findByKeyString(String key);
	List<Driver> findByNameAndPass(Driver driver);
	Driver  findByPhone(String phone);
	List<Driver> searchNearDriver(int pointX,int pointY);
	boolean updatePassword(String phone,String pass);
	boolean updateStarLeave(String driverId,int StarLeave);
	boolean updateOauth(String driverId,String oauth);
	int driverOnline();
}
