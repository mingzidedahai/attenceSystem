package cn.edu.tju.se.attence.domain;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.edu.tju.se.base.cons.CommonConstant.State;
import cn.edu.tju.se.base.domain.BaseDomain;

@Entity
@Table(name="evection")
public class Evection extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected int id;
    protected String time;
    protected String startTime;
    protected String endTime;
    protected int hours;
    protected String reason;
    protected State state;
    protected int userfileid;
    
    @ManyToOne
    @JoinColumn(name = "userfileid",insertable = false, updatable = false)
    protected UserFile userfile;
    
    @OneToMany(cascade = { CascadeType.ALL },fetch= FetchType.EAGER)
    @JoinColumn(name = "evectionid")
    protected List<EvectionApproval> evectionApprovals;
    
    
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

	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getUserfileid() {
		return userfileid;
	}
	public void setUserfileid(int userfileid) {
		this.userfileid = userfileid;
	}
	public List<EvectionApproval> getEvectionApprovals() {
		return evectionApprovals;
	}
	public void setEvectionApprovals(List<EvectionApproval> evectionApprovals) {
		this.evectionApprovals = evectionApprovals;
	}
	
    
    
}
