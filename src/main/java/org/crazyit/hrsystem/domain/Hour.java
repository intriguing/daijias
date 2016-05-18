package org.crazyit.hrsystem.domain;
/**
 * Creation Date:2016/5/7-11:29
 * <p>
 * Copyright 2008-2016  Inc. All Rights Reserved
 */

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, 2016/5/7-11:29
 * @since 2016/5/7-11:29
 */
@Entity
@Table(name = "hour_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Hour {
    private static final long serialVersionUID = 48L;
    @Id
    @Column(name = "hour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "hour_driverNum", nullable = false)
    private int driverNum;
    @Column(name = "hour_time", nullable = false, length =18)
    private String time;
    @Column(name = "hour_time2", nullable = false, length =30)
    private String time2;

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(int driverNum) {
        this.driverNum = driverNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
