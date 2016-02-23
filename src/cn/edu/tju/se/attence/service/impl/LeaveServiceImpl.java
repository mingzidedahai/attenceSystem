package cn.edu.tju.se.attence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.se.attence.dao.LeaveDao;
import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.service.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired 
	LeaveDao leaveDao;
	
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	@Override
	public Leaving get(int id) {
		return leaveDao.get(id);
	}

	@Override
	public void update(Leaving leave) {
		leaveDao.update(leave);
		
	}

	@Override
	public void add(Leaving leave) {
		leaveDao.save(leave);
		
	}

	@Override
	public void remove(int id) {
		leaveDao.remove(leaveDao.get(id));
		
	}

	@Override
	public List<Leaving> getAll() {
		return leaveDao.loadAll();
	}
	@Override
	public List<Leaving> getAllLeaves() {
		return leaveDao.getAllLeaves();
	}

	@Override
	public List<Leaving> getByUserFileId(int userFileId) {
		return leaveDao.getByUserFileId(userFileId);
	}
	@Override
	public List<Leaving> getByApprovalUserFileId(int userFileId) {
		return leaveDao.getByApprovalUserFileId(userFileId);
	}

}
