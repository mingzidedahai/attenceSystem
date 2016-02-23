package cn.edu.tju.se.attence.dao;

import java.util.List;

import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.base.cons.CommonConstant.Role;
import cn.edu.tju.se.base.dao.BaseDao;


public interface UserFileDao extends BaseDao<UserFile>{
	

	public List<UserFile> getByRole(Role role);
		
}