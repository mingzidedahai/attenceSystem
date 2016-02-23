package cn.edu.tju.se.attence.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.se.attence.dao.UserFileDao;
import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.attence.service.UserFileService;
import cn.edu.tju.se.base.cons.CommonConstant.Role;

@Service
public class UserFileServiceImpl implements UserFileService {
	
	@Autowired 
	UserFileDao userFileDao;
	
	public void setUserFileDao(UserFileDao userFileDao) {
		this.userFileDao = userFileDao;
	}

	@Override
	public UserFile get(int id){
		return userFileDao.get(id);
	}
	@Override
	public void update(UserFile userfile){
		userFileDao.update(userfile);
	}
	@Override
	public void add(UserFile userfile){
		userFileDao.save(userfile);
	}
	@Override
	public void remove(int id){
		userFileDao.remove(userFileDao.get(id));
	}
	@Override
	public List<UserFile> getAll(){
		return userFileDao.loadAll();
	}

	@Override
	public List<UserFile> getByRole(Role role) {
		// TODO Auto-generated method stub
		return userFileDao.getByRole(role);
	}
	
}
