package org.crazyit.hrsystem.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "adminater_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Adminater  implements Serializable{
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
	@Column(name="flag",length=50)
	private String flag;
	public Adminater(){}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
}
