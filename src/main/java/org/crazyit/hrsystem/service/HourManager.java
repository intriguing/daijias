package org.crazyit.hrsystem.service;
/**
 * Creation Date:2016/5/7-12:00
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.domain.Hour;

import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-12:00
 * @since 2016/5/7-12:00
 */
public interface HourManager {
    void saveHour(int num);
    void deleteMonth();
    List<Hour> findByDate(String time);
}
