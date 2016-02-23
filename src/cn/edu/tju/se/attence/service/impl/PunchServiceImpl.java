package cn.edu.tju.se.attence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.se.attence.dao.PunchDao;
import cn.edu.tju.se.attence.domain.Punch;
import cn.edu.tju.se.attence.service.PunchService;


@Service
public class PunchServiceImpl implements PunchService{
	@Autowired 
	PunchDao punchDao;
	
	public void setPunchDao(PunchDao punchDao) {
		this.punchDao = punchDao;
	}

	@Override
	public Punch get(int id) {
		return punchDao.get(id);
	}

	@Override
	public void update(Punch punch) {
		punchDao.update(punch);
		
	}

	@Override
	public void add(Punch punch) {
		punchDao.save(punch);
		
	}

	@Override
	public void remove(int id) {
		punchDao.remove(punchDao.get(id));
		
	}

	@Override
	public List<Punch> getAll() {
		return punchDao.loadAll();
	}

	@Override
	public List<Punch> getByUserFileId(int userFileId) {
		return punchDao.getByUserFileId(userFileId);
	}

	@Override
	public List<Punch> getByEmployeeId(int employeeid) {
		return punchDao.getByEmployeeId(employeeid);

	}

}
