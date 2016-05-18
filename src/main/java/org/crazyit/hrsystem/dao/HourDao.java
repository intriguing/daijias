package org.crazyit.hrsystem.dao;
/**
 * Creation Date:2016/5/7-11:48
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Hour;

import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-11:48
 * @since 2016/5/7-11:48
 */
public interface HourDao extends BaseDao<Hour> {
    boolean saveHourDriverNum(int num);
    void deleteMonth();
    List<Hour> findByDate(String time);
}
