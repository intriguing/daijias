package org.crazyit.hrsystem.service.impl;
/**
 * Creation Date:2016/5/7-12:01
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.dao.HourDao;
import org.crazyit.hrsystem.domain.Hour;
import org.crazyit.hrsystem.service.HourManager;

import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-12:01
 * @since 2016/5/7-12:01
 */
public class HourManagerImpl implements HourManager {
    HourDao hourDao;

    public void setHourDao(HourDao hourDao) {
        this.hourDao = hourDao;
    }

    @Override
    public void saveHour(int num) {
        hourDao.saveHourDriverNum(num);
    }

    @Override
    public void deleteMonth() {
        hourDao.deleteMonth();
    }

    @Override
    public List<Hour> findByDate(String time) {
        return  hourDao.findByDate(time);
    }
}
