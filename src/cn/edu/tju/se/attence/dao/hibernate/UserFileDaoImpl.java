package cn.edu.tju.se.attence.dao.hibernate;

import java.util.List;

import cn.edu.tju.se.attence.dao.UserFileDao;
import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.base.cons.CommonConstant.Role;
import cn.edu.tju.se.base.dao.hibernate.BaseDaoImpl;

import org.springframework.stereotype.Repository;


@Repository
public class UserFileDaoImpl extends BaseDaoImpl<UserFile> implements UserFileDao{
	private final String GET_BY_Role = "from UserFile d where d.role = ?";
	@Override
	public List<UserFile> getByRole(Role role) {
		 List<UserFile> find = (List<UserFile>)find(GET_BY_Role,role);
			return find;
	}
}
