package cn.edu.tju.se.attence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.se.attence.dao.LeaveApprovalDao;
import cn.edu.tju.se.attence.domain.LeaveApproval;
import cn.edu.tju.se.attence.service.LeaveApprovalService;


@Service
public class LeaveApprovalServiceImpl implements LeaveApprovalService{
	@Autowired 
	LeaveApprovalDao leaveApprovalDao;
	
	public void setLeaveApprovalDao(LeaveApprovalDao leaveApprovalDao) {
		this.leaveApprovalDao = leaveApprovalDao;
	}

	@Override
	public LeaveApproval get(int id) {
		return leaveApprovalDao.get(id);
	}

	@Override
	public void update(LeaveApproval leaveApproval) {
		leaveApprovalDao.update(leaveApproval);
		
	}

	@Override
	public void add(LeaveApproval leaveApproval) {
		leaveApprovalDao.save(leaveApproval);
		
	}

	@Override
	public void remove(int id) {
		leaveApprovalDao.remove(leaveApprovalDao.get(id));
		
	}

	@Override
	public List<LeaveApproval> getAll() {
		return leaveApprovalDao.loadAll();
	}

	@Override
	public List<LeaveApproval> getByUserFileId(int userFileId) {
		return leaveApprovalDao.getByUserFileId(userFileId);
	}

}
