package org.crazyit.hrsystem.schedule;
/**
 * Creation Date:2016/5/7-11:11
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.service.DriverManager;
import org.crazyit.hrsystem.service.HourManager;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-11:11
 * @since 2016/5/7-11:11
 */
public class AddHour extends QuartzJobBean {
    private boolean isRunning=false;
    private DriverManager driverManager;
    private HourManager hourManager;

    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void setHourManager(HourManager hourManager) {
        this.hourManager = hourManager;
    }

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext context) throws JobExecutionException {
        if (!isRunning) {
            isRunning=true;
            hourManager.saveHour(driverManager.driverOnline());
            isRunning=false;
        }
    }
}
