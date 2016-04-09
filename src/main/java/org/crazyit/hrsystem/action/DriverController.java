package org.crazyit.hrsystem.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.DriverManager;
import org.crazyit.hrsystem.service.UsernameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/driver")
public class DriverController {
    private DriverManager driverManager;
    @Autowired
    private UsernameManager usernameManager;
    @Autowired
    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object Driverregister(@RequestParam("driverYear") String driverYear,@RequestParam("phone") String phone, @RequestParam("pointX") String pointX, @RequestParam("pointY") String pointY,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        Username username=usernameManager.findUsernameByphone(phone);
        if(null==username){
            map.put("code",false);
            return map;
        }
        Driver driver=new Driver();
        driver.setName(username.getName());
        driver.setPass(username.getPass());
        driver.setSex(username.getSex());
        driver.setPhone(username.getPhone());
        driver.setInfor(username.getInfor());
        driver.setStatus(1);
        driver.setDriverrange(0);
        driver.setDrivingYears(Integer.parseInt(driverYear));
        driver.setPointX(Integer.parseInt(pointX));
        driver.setPointY(Integer.parseInt(pointY));
        if (null != driverManager.findByPhone(phone)) {
            map.put("code", false);
        } else {
            driverManager.saveDriver(driver);
            this.usernameManager.deleteUsername(username);
            map.put("code", true);
        }
        return map;
    }

    @RequestMapping(value = "/range", method = RequestMethod.POST)
    @ResponseBody
    public Object Driverrange(@RequestParam("range") String range) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Driver> driverlist = driverManager.findDriverrange(range);
        Iterator<Driver> iterator = driverlist.iterator();
        int i = 1;
        if (iterator.hasNext()) {
            map.put("" + i, iterator.next());
            i++;
        }
        return map;
    }

    @RequestMapping(value = "/updatedriverrange", method = RequestMethod.GET)
    @ResponseBody
    public Object UpdateDriverrange(@RequestParam("name") String name, @RequestParam("driverrange") int driverrange) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != driverManager.findByName(name)) {
            driverManager.updateDriverrange(name, driverrange);
            map.put("code", true);
            return map;
        }
        map.put("code", false);
        return map;
    }

    @RequestMapping(value = "/updatestatus", method = RequestMethod.POST)
    @ResponseBody
    public Object UpdateDriverStatus(@RequestParam("name") String name, @RequestParam("updatestatus") int updatestatus) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != driverManager.findByName(name)) {
            driverManager.updateStatus(name, updatestatus);
            map.put("code", true);
            return map;
        }
        map.put("code", false);
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Driverlogin(@RequestParam("name") String name,
                              @RequestParam("pass") String pass) {
        Map<String, Object> map = new HashMap<String, Object>();
        Driver driver = driverManager.findByName(name);
        if (null != driver) {
            if (driver.getPass().equals(pass)) {
                map.put("code", true);
            } else {
                map.put("code", false);
            }
            return map;
        }
        Driver drivert = driverManager.findByPhone(name);
        if (null != drivert) {
            if (drivert.getPass().equals(pass)) {
                map.put("code", true);
            }
            map.put("code", false);
            return map;
        }
        map.put("code", false);
        return map;
    }

    @RequestMapping(value = "/drivering", method = RequestMethod.POST)
    @ResponseBody
    public Object Drivering() {
        Map<String, Object> map = new HashMap<String, Object>();
        int i = 1;
        Iterator<Driver> iterator = driverManager.findDrivering().iterator();
        if (iterator.hasNext()) {
            map.put("" + i, iterator.next());
            i++;
        }
        return map;
    }

    @RequestMapping(value = "/searchNearDriver", method = RequestMethod.POST)
    @ResponseBody
    public Object DriversInfo(@RequestParam("pointX") String pointX,
                              @RequestParam("pointY") String pointY) {
        Map<String, Object> map = new HashMap<String, Object>();
        org.crazyit.hrsystem.vo.DriversInfo driversInfo = driverManager.searchNearDriver(Integer.parseInt(pointX), Integer.parseInt(pointY));
        map.put("DriversInfo", driversInfo.getDrivers());
        map.put("PageIndex", driversInfo.getPageIndex());
        map.put("TotalPage", driversInfo.getTotalPage());
        return map;
    }

    @RequestMapping(value = "/driverStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object ChangeDriverStatus( @RequestParam("pointX") String pointX,
                                      @RequestParam("pointY") String pointY,
            @RequestParam("phone") String phone,
                                     @RequestParam("status") String status) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (driverManager.changeDriverStatus(phone, status,pointX,pointY)) {
            map.put("code", true);
            return map;
        } else {
            map.put("code", false);
            return map;
        }
    }
    @RequestMapping(value = "/driverByPhone", method = RequestMethod.POST)
    @ResponseBody
    public Object findDriverByPhone(@RequestParam("phone") String phone){
        Map<String, Object> map = new HashMap<String, Object>();
        if(null!=driverManager.findByPhone(phone)){
            map.put("code", true);
            return map;
        }
        map.put("code", false);
        return map;
    }
}
