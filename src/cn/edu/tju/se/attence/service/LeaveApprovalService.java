package cn.edu.tju.se.attence.service;

import java.util.List;

import cn.edu.tju.se.attence.domain.LeaveApproval;


public interface LeaveApprovalService {
	public LeaveApproval get(int id);

	public void update(LeaveApproval leaveApproval);

	public void add(LeaveApproval leaveApproval);

	public void remove(int id);

	public List<LeaveApproval> getAll();
	
	public List<LeaveApproval> getByUserFileId(int userFileId);
}
