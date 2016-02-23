package cn.edu.tju.se.attence.service;

import java.util.List;

import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.base.cons.CommonConstant.Role;



public interface UserFileService {
	public UserFile get(int id);

	public void update(UserFile userfile);

	public void add(UserFile userfile);

	public void remove(int id);

	public List<UserFile> getAll();
	public List<UserFile> getByRole(Role role);
}
