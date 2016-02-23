package cn.edu.tju.se.attence.domain;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.edu.tju.se.base.domain.BaseDomain;

@Entity
@Table(name="punch")
public class Punch extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected int id;
	protected int employeeid;
	protected String username;
	protected String time;

	 @ManyToOne
     @JoinColumn(name = "employeeid",referencedColumnName="employeeid", insertable = false, updatable = false)
     protected UserFile userfile;
	
	 
	public UserFile getUserfile() {
		return userfile;
	}
	public void setUserfile(UserFile userfile) {
		this.userfile = userfile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
