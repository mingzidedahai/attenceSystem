package cn.edu.tju.se.attence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.se.attence.dao.EvectionApprovalDao;
import cn.edu.tju.se.attence.domain.EvectionApproval;
import cn.edu.tju.se.attence.service.EvectionApprovalService;


@Service
public class EvectionApprovalServiceImpl implements EvectionApprovalService{
	@Autowired 
	EvectionApprovalDao evectionApprovalDao;
	
	public void setEvectionApprovalDao(EvectionApprovalDao evectionApprovalDao) {
		this.evectionApprovalDao = evectionApprovalDao;
	}

	@Override
	public EvectionApproval get(int id) {
		return evectionApprovalDao.get(id);
	}

	@Override
	public void update(EvectionApproval evectionApproval) {
		evectionApprovalDao.update(evectionApproval);
		
	}

	@Override
	public void add(EvectionApproval evectionApproval) {
		evectionApprovalDao.save(evectionApproval);
		
	}

	@Override
	public void remove(int id) {
		evectionApprovalDao.remove(evectionApprovalDao.get(id));
		
	}

	@Override
	public List<EvectionApproval> getAll() {
		return evectionApprovalDao.loadAll();
	}

	@Override
	public List<EvectionApproval> getByUserFileId(int userFileId) {
		return evectionApprovalDao.getByUserFileId(userFileId);
	}

}
