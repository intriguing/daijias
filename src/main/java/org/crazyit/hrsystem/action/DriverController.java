package org.crazyit.hrsystem.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.DriverComments;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.DriverCommentsManager;
import org.crazyit.hrsystem.service.DriverManager;
import org.crazyit.hrsystem.service.UsernameManager;
import org.crazyit.hrsystem.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/driver")
public class DriverController {
    private DriverManager driverManager;
    @Autowired
    private DriverCommentsManager driverCommentsManager;
    @Autowired
    private UsernameManager usernameManager;
    @Autowired
    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object Driverregister(@RequestParam("driverYear") String driverYear, @RequestParam("phone") String phone, @RequestParam("driverRange") String driverRange, @RequestParam("pointX") String pointX, @RequestParam("pointY") String pointY, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String realPath=request.getRealPath("/");
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
        driver.setDriverrange(Integer.parseInt(driverRange));
        driver.setDrivingYears(Integer.parseInt(driverYear));
        driver.setPointX(Integer.parseInt(pointX));
        driver.setPointY(Integer.parseInt(pointY));
        driver.setStarLeave(5);
        driver.setOauth(0);
        driver.setImageUrl(this.saveFile(file,realPath));
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
    @RequestMapping(value = "/driverComments", method = RequestMethod.POST)
    @ResponseBody
    public Object findDriverComments(@RequestParam("driverId") String driverId){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("CommentVosInfo",driverCommentsManager.findCommentVoById(driverId));
        return map;
    }
    @RequestMapping(value = "/saveDriverComments", method = RequestMethod.POST)
    @ResponseBody
    public Object saveDriverComments(@RequestParam("driverId") String driverId,@RequestParam("phone") String phone,@RequestParam("comment") String comment,@RequestParam("starLevel") String starLevel){
        /*@RequestBody DriverComments driverComments*/
        DriverComments driverComments=new DriverComments();
        driverComments.setPhone(phone);
        driverComments.setComment(comment);
        driverComments.setDriverId(driverId);
        driverComments.setStarLevel(starLevel);
        Map<String, Object> map = new HashMap<String, Object>();
        if(driverCommentsManager.saveUsername(driverComments)){
           List<CommentVo> driverCommentsList= driverCommentsManager.findCommentVoById(driverId);
            int starLevelTotal=0;
            for(CommentVo commentVo:driverCommentsList)
                starLevelTotal+=Integer.parseInt(commentVo.getStarLevel());
            starLevelTotal=starLevelTotal/driverCommentsList.size();
            driverManager.updateStarLeave(driverId,starLevelTotal);
            map.put("code",true);
        }else{
            map.put("code",false);
        }
        return map;
    }
    private String saveFile(MultipartFile file,String realPath){
        if(!file.isEmpty()){
            try {
                DateFormat df   =   new SimpleDateFormat( "yyyyMMdd");
                String time =df.format(new Date());
                int last=file.getOriginalFilename().lastIndexOf(".");
                String suffess=file.getOriginalFilename().substring(last);
                String filePath="image/"+time+getStringRandom(6)+suffess;
                realPath=realPath+filePath;
                File saveDir=new File(realPath);
                if(!saveDir.getParentFile().exists())
                    saveDir.getParentFile().mkdirs();
                file.transferTo(saveDir);
                return filePath;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    //生成随机数字和字母,
    private String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
