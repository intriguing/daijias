package org.crazyit.hrsystem.dao.impl;
/**
 * Creation Date:2016/5/7-11:51
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.HourDao;
import org.crazyit.hrsystem.domain.Hour;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-11:51
 * @since 2016/5/7-11:51
 */
public class HourDaoHibernate4 extends BaseDaoHibernate4<Hour>
        implements HourDao{
    @Override
    public boolean saveHourDriverNum(int num) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        SimpleDateFormat formatterS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStrings = formatterS.format(currentTime);
        Hour hour=new Hour();
        hour.setTime(dateString);
        hour.setTime2(dateStrings);
        hour.setDriverNum(num);
        this.save(hour);
        return true;
    }

    @Override
    public void deleteMonth() {
        String sql="delete daijia.hour_inf en where en.hour_time like ?0";
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM");
        Date dateNow = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dateNow);
        cl.add(Calendar.MONTH, -1);			//一个月
        Date dateFrom = cl.getTime();
        String dateString = sdf.format(dateFrom);
        getSessionFactory().getCurrentSession()
                .createQuery(sql)
                .setParameter("0" , dateString)
                .executeUpdate();
    }

    @Override
    public List<Hour> findByDate(String time) {
        return this.find("select p from Hour p where p.time=?0",time);
    }
}
