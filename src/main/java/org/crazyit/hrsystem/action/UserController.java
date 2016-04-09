package org.crazyit.hrsystem.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsernameManager usernameManager;
    @Autowired
    private DriverManager driverManager;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object UserRegister(@RequestParam("name") String name, @RequestParam("pass") String pass, @RequestParam("phone") String phone, @RequestParam("sex") String sex, @RequestParam("info") String info, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Username username = new Username();
        username.setName(name);
        username.setPass(pass);
        username.setPhone(phone);
        if (sex.equals("男")) {
            username.setSex(0);
        } else {
            username.setSex(1);
        }
        username.setInfor(info);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        if (!username.getName().equals(""))
            if (null != usernameManager.findUsernameByname(username.getName())) {
                map.put("code", false);
                return map;
            }
        if (!username.getPhone().equals(""))
            if (null != usernameManager.findUsernameByphone(username.getPhone())) {
                map.put("code", true);
                return map;
            }

        if (usernameManager.saveUsername(username)) {
            map.put("code", true);
        } else {
            map.put("code", false);
        }
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Userlogin(@RequestParam("name") String name,
                            @RequestParam("pass") String pass, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        Driver driver = driverManager.findByName(name);
        if (null != driver) {
            if (driver.getPass().equals(pass)) {
                map.put("code", true);
                map.put("demo", 2);
            } else {
                map.put("code", false);
                map.put("demo", 0);
            }
            return map;
        }
        Driver drivert = driverManager.findByPhone(name);
        if (null != drivert) {
            if (drivert.getPass().equals(pass)) {
                map.put("code", true);
                map.put("demo", 2);
            }else {
                map.put("code", false);
                map.put("demo", 0);
            }
            return map;
        }
        Username username = usernameManager.findUsernameByname(name);
        if (null != username) {
            if (username.getPass().equals(pass)) {
                map.put("code", true);
                map.put("demo", 1);
            } else {
                map.put("code", false);
                map.put("demo", 0);
            }
            return map;
        }
        Username usernamet = usernameManager.findUsernameByphone(name);
        if (null != usernamet) {
            if (usernamet.getPass().equals(pass)) {
                map.put("code", true);
                map.put("demo", 1);
                return map;
            }
        }
        map.put("code", false);
        map.put("demo", 0);
        return map;
    }

    @RequestMapping(value = "/updatephone", method = RequestMethod.POST)
    @ResponseBody
    public Object userUpdatePhone(@RequestParam("name") String name, @RequestParam("oldphone") String oldphone, @RequestParam("newphone") String newphone, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        if (usernameManager.updatephone(name, oldphone, newphone)) {
            map.put("code", true);
        } else {
            map.put("code", false);
        }
        return map;
    }

    @RequestMapping(value = "/updatePass", method = RequestMethod.POST)
    @ResponseBody
    public Object userUpdatePass(@RequestParam("password") String password, @RequestParam("phone") String phone, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        if(null!=usernameManager.findUsernameByphone(phone)) {
            if (usernameManager.updatePassword(phone, password)) {
                map.put("code", true);
            } else {
                map.put("code", false);
            }
            return map;
        }
        if (null!=this.driverManager.findByPhone(phone)){
            if (this.driverManager.updatePassword(phone,password)){
                map.put("code",true);
            }
        }
        map.put("code",false);
        return  map;
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object userUpdateInfo(@RequestParam("name") String name, @RequestParam("info") String info, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        if (usernameManager.updateinfor(name, info)) {
            map.put("code", true);
        } else {
            map.put("code", false);
        }
        return map;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "tsafa";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public Object certification(@RequestParam("phone") String phone,
                                @RequestParam("info") String info, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        Username username = usernameManager.findUsernameByphone(phone);
        if (null != username) {
            if (username.getInfor().equals(info)) {
                map.put("code", true);
            } else {
                map.put("code", false);
            }
            return map;
        }
        Driver driver=this.driverManager.findByPhone(phone);
        if(null!=driver){
            if(driver.getInfor().equals(info)){
                map.put("code",true);
                return map;
            }
        }
        map.put("code", false);
        return map;
    }
}
