package cn.edu.tju.se.attence.domain;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.edu.tju.se.base.cons.CommonConstant.Agree;
import cn.edu.tju.se.base.domain.BaseDomain;

@Entity
@Table(name="evectionapproval")
public class EvectionApproval extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
     protected int id;
     protected String comment;
     protected String time;
     protected int evectionid;
     protected int userfileid;
     protected Agree agree;
     @ManyToOne
     @JoinColumn(name = "userfileid",insertable = false, updatable = false)
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getEvectionid() {
		return evectionid;
	}
	public void setEvectionid(int evectionid) {
		this.evectionid = evectionid;
	}
	public int getUserfileid() {
		return userfileid;
	}
	public void setUserfileid(int userfileid) {
		this.userfileid = userfileid;
	}
	public Agree getAgree() {
		return agree;
	}
	public void setAgree(Agree agree) {
		this.agree = agree;
	}
	
     
     
     
}
