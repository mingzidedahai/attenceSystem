package cn.edu.tju.se.auth.domain;

import javax.persistence.*;

import cn.edu.tju.se.base.cons.CommonConstant.Auth;
import cn.edu.tju.se.base.domain.BaseDomain;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "user")
public class User extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    protected int userfileid;
    
    protected String username;

    protected String password;
    
   protected Auth leavingapprovalauth;
   protected Auth evectionapprovalauth;
   protected Auth setvocationauth;
   protected Auth leavingtableauth;
   protected Auth importpunchdataauth;
   protected Auth allpunchauth;






public Auth getAllpunchauth() {
	return allpunchauth;
}

public void setAllpunchauth(Auth allpunchauth) {
	this.allpunchauth = allpunchauth;
}

public Auth getLeavingapprovalauth() {
	return leavingapprovalauth;
}

public void setLeavingapprovalauth(Auth leavingapprovalauth) {
	this.leavingapprovalauth = leavingapprovalauth;
}

public Auth getEvectionapprovalauth() {
	return evectionapprovalauth;
}

public void setEvectionapprovalauth(Auth evectionapprovalauth) {
	this.evectionapprovalauth = evectionapprovalauth;
}

public Auth getSetvocationauth() {
	return setvocationauth;
}

public void setSetvocationauth(Auth setvocationauth) {
	this.setvocationauth = setvocationauth;
}

public Auth getLeavingtableauth() {
	return leavingtableauth;
}

public void setLeavingtableauth(Auth leavingtableauth) {
	this.leavingtableauth = leavingtableauth;
}

public Auth getImportpunchdataauth() {
	return importpunchdataauth;
}

public void setImportpunchdataauth(Auth importpunchdataauth) {
	this.importpunchdataauth = importpunchdataauth;
}

	public int getUserfileid() {
		return userfileid;
	}

	public void setUserfileid(int userfileid) {
		this.userfileid = userfileid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}