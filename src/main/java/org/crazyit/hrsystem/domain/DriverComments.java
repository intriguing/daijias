package org.crazyit.hrsystem.domain;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
@Entity
@Table(name = "driverComment_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DriverComments implements Serializable {
    private static final long serialVersionUID = 48L;
    @Id
    @Column(name = "driverComment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_phone", nullable = false, length =18)
    private String phone;
    @Column(name = "driver_comment", nullable = false, length =18)
    private String comment;
    @Column(name = "driver_id", nullable = false, length =18)
    private String driverId;
    @Column(name = "starLevel", nullable = false, length =18)
    private String starLevel;

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
