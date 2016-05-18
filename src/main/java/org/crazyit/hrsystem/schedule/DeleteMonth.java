package org.crazyit.hrsystem.schedule;
/**
 * Creation Date:2016/5/7-13:27
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.service.HourManager;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-13:27
 * @since 2016/5/7-13:27
 */
public class DeleteMonth extends QuartzJobBean {
    private boolean isRunning=false;
    private HourManager hourManager;

    public void setHourManager(HourManager hourManager) {
        this.hourManager = hourManager;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if(!isRunning){
            isRunning=true;
            hourManager.deleteMonth();
            isRunning=false;
        }
    }
}
