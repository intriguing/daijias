package org.crazyit.hrsystem.service.impl;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.dao.AdminaterDao;
import org.crazyit.hrsystem.dao.DriverCommentsDao;
import org.crazyit.hrsystem.dao.DriverDao;
import org.crazyit.hrsystem.dao.UsernameDao;
import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.DriverComments;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.DriverCommentsManager;
import org.crazyit.hrsystem.vo.CommentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public class DriverCommentsManagerImpl implements DriverCommentsManager {
    private AdminaterDao adminaterDao;
    private DriverDao driverDao;
    private UsernameDao usernameDao;
    private DriverCommentsDao driverCommentsDao;
    public  void setDriverCommentsDao(DriverCommentsDao driverCommentsDao){this.driverCommentsDao=driverCommentsDao;}
    public void setAdminaterDao(AdminaterDao adminaterDao) {
        this.adminaterDao = adminaterDao;
    }

    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    public void setUsernameDao(UsernameDao usernameDao) {
        this.usernameDao = usernameDao;
    }
    @Override
    public boolean saveUsername(DriverComments driverComments) {
        this.driverCommentsDao.save(driverComments);
        return true;
    }

    @Override
    public List<CommentVo> findCommentVoById(String driverId) {
        List<DriverComments> driverCommentses=driverCommentsDao.findDriverCommentsById(driverId);
        List<CommentVo> commentVos= new ArrayList<>();
        for(DriverComments driverComments :driverCommentses){
            CommentVo commentVo=new CommentVo();
            commentVo.setComment(driverComments.getComment());
            commentVo.setStarLevel(driverComments.getStarLevel());
                Driver driver=driverDao.findByPhone(driverComments.getPhone());
                if(null!=driver){
                    commentVo.setUserName(driver.getName());
                }else{
                    Username username=usernameDao.findByPhone(driverComments.getPhone());
                    if(null!=username){
                        commentVo.setUserName(username.getName());
                    }
                }
                commentVos.add(commentVo);
        }
        return commentVos;
    }
}
