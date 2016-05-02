package org.crazyit.hrsystem.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Code;
import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.AdminaterManager;
import org.crazyit.hrsystem.service.CodeManager;
import org.crazyit.hrsystem.service.DriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/adminater")
public class AdminaterController {
    @Autowired
    private DriverManager driverManager;
    @Autowired
    private CodeManager codeManager;
    private AdminaterManager adminatermanager;

    @Autowired
    public void setAdminatermanager(AdminaterManager adminatermanager) {
        this.adminatermanager = adminatermanager;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Adminaterregister(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("code") String code, @RequestParam("sample-radio") String sex, @RequestParam("phone") String phone,
                                    @RequestParam("pass") String pass, HttpServletRequest request) {
        Adminater adminater = new Adminater();
        adminater.setName(name);
        adminater.setPhone(phone);
        adminater.setFlag("1");
        adminater.setInfor(address);
        adminater.setSex(Integer.parseInt(sex));
        adminater.setPass(pass);
        Code codes = new Code();
        codes.setCode(code);
        codes.setPhone(phone);
        if (!codeManager.saveCode(codes)) {
            return "redirect:/registration.html";
        }
        if (!adminatermanager.savaAdminater(adminater)) {
            return "redirect:/registration.html";
        }
        return "redirect:/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Adminaterlogin(@RequestParam("name") String name,
                                 @RequestParam("pass") String pass, @RequestParam("code") String code) {
        if (StringUtils.isBlank(code)) {
            Adminater adminater = adminatermanager.findByName(name);
            if (null != adminater) {
                if (adminater.getPass().equals(pass)) {
                    return "redirect:/basic_table.html";
                } else {
                    return "redirect:/login.html";
                }
            }
            return "redirect:/login.html";
        } else {
            Code codes = codeManager.findCodeByPhone(name);
            if (null != codes) {
                if (codes.getCode().equals(code)) {
                    return "redirect:/basic_table.html";
                } else {
                    return "redirect:/login.html";
                }
            }
            return "redirect:/login.html";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Object AdminaterUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Username> usernames = new ArrayList<Username>();
        Iterator<Username> iterator = adminatermanager.findUsername().iterator();
        while (iterator.hasNext()) {
            usernames.add(iterator.next());
        }
        map.put("usernames", usernames);
        return map;
    }

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    @ResponseBody
    public Object AdminaterDriver() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Driver> driverList = new ArrayList<Driver>();
        Iterator<Driver> iterator = adminatermanager.findDriver().iterator();
        while (iterator.hasNext()) {
            driverList.add(iterator.next());
        }
        map.put("drivers", driverList);
        return map;
    }

    @RequestMapping(value = "/driverDelete", method = RequestMethod.POST)
    public String AdminaterDriverDelete(@RequestParam("driverId") String driverId) {
        driverManager.deleteDriver(driverId);
        return "redirect:/editable_table.html";
    }

    @RequestMapping(value = "/driverDirs", method = RequestMethod.POST)
    @ResponseBody
    public Object AdminaterDriverDirs() {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<Driver> iterator = adminatermanager.findDriver().iterator();
        int online = 0, offline = 0, busyline = 0;
        while (iterator.hasNext()) {
            int temp = iterator.next().getStatus();
            if (temp == 1) {
                online++;
            } else if (temp == 2) {
                offline++;
            } else {
                busyline++;
            }
        }
        int onlines=100*online/(online+offline+busyline);
        int offlines=100*offline/(online+offline+busyline);
        int busylines=100*busyline/(online+offline+busyline);
        map.put("onLine", onlines);
        map.put("offLine", offlines);
        map.put("busyLine",busylines);
        return map;
    }
    @RequestMapping(value = "/driverStar", method = RequestMethod.POST)
    @ResponseBody
    public Object AdminaterDriverStar(){
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<Driver> iterator = adminatermanager.findDriver().iterator();
        int five=0,four=0,three=0,two=0,one=0;
        while (iterator.hasNext()) {
            int temp = iterator.next().getStarLeave();
            if (temp == 5) {
                five++;
            } else if (temp == 4) {
                four++;
            } else if(temp==3){
                three++;
            }else if(temp==2){
                two++;
            }else{
                one++;
            }
        }
        int fives=100*five/(five+four+three+two+one);
        int fours=100*four/(five+four+three+two+one);
        int threes=100*three/(five+four+three+two+one);
        int twos=100*two/(five+four+three+two+one);
        int ones=100*one/(five+four+three+two+one);
        map.put("five", fives);
        map.put("four", fours);
        map.put("three",threes);
        map.put("two",twos);
        map.put("one",ones);
        return map;
    }
}
