package in.manikanta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	
	private String name;
	private String email;
	private String pwd;
	private Double phno;
	
	@Override
	public String toString() {
		return "CounsellorsController [cid=" + cid + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", phno="
				+ phno + "]";
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Double getPhno() {
		return phno;
	}
	public void setPhno(Double phno) {
		this.phno = phno;
	}

}
