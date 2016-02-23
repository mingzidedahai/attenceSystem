package cn.edu.tju.se.attence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.se.attence.dao.EvectionDao;
import cn.edu.tju.se.attence.domain.Evection;
import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.service.EvectionService;


@Service
public class EvectionServiceImpl implements EvectionService{
	@Autowired 
	EvectionDao evectionDao;
	
	public void setEvectionDao(EvectionDao evectionDao) {
		this.evectionDao = evectionDao;
	}

	@Override
	public Evection get(int id) {
		return evectionDao.get(id);
	}

	@Override
	public void update(Evection evection) {
		evectionDao.update(evection);
		
	}

	@Override
	public void add(Evection evection) {
		evectionDao.save(evection);
		
	}

	@Override
	public void remove(int id) {
		evectionDao.remove(evectionDao.get(id));
		
	}

	@Override
	public List<Evection> getAll() {
		return evectionDao.loadAll();
	}

	@Override
	public List<Evection> getByUserFileId(int userFileId) {
		return evectionDao.getByUserFileId(userFileId);
	}
	@Override
	public List<Evection> getByApprovalUserFileId(int userFileId) {
		return evectionDao.getByApprovalUserFileId(userFileId);
	}
}
