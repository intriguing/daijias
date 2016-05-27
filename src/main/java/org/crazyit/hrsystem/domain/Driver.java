package org.crazyit.hrsystem.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "driver_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Driver implements Serializable{
	private static final long serialVersionUID = 48L;
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_name", nullable = false, length = 50)
	private String name;
	@Column(name = "user_sex", nullable = false)
	private int sex;
	@Column(name = "user_pass", nullable = false, length = 50)
	private String pass;
	@Column(name = "user_phone", nullable = false, length =18)
	private String phone;
	@Column(name = "user_infor", nullable = false)
	private String infor;
	@Column(name="status")
	private int status;
	@Column(name="driverrange")
	private int driverrange;
	@Column(name="drivingYears")
	private int drivingYears;
	@Column(name="pointX",length=10)
	private int pointX;
	@Column(name="pointY",length=10)
	private int pointY;
	@Column(name="starLeave",length=10)
	private int starLeave;
	@Column(name = "imageUrl", nullable = false)
	private String imageUrl;
	@Column(name="oauth",length=10)
	private int oauth;
	public Driver(){}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDrivingYears() {
		return drivingYears;
	}
	public void setDrivingYears(int drivingYears) {
		this.drivingYears = drivingYears;
	}
	public int getPointX() {
		return pointX;
	}
	public void setPointX(int pointX) {
		this.pointX = pointX;
	}
	public int getPointY() {
		return pointY;
	}
	public void setPointY(int pointY) {
		this.pointY = pointY;
	}
	public int getDriverrange() {
		return driverrange;
	}
	public void setDriverrange(int driverrange) {
		this.driverrange = driverrange;
	}
	public int getStarLeave() {
		return starLeave;
	}

	public void setStarLeave(int starLeave) {
		this.starLeave = starLeave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getOauth() {
		return oauth;
	}

	public void setOauth(int oauth) {
		this.oauth = oauth;
	}
}
