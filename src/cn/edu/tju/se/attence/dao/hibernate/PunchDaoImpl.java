package cn.edu.tju.se.attence.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.tju.se.attence.dao.PunchDao;
import cn.edu.tju.se.attence.domain.Punch;
import cn.edu.tju.se.base.dao.hibernate.BaseDaoImpl;


@Repository
public class PunchDaoImpl extends BaseDaoImpl<Punch> implements PunchDao{
	private final String GET_BY_UserFileId = "from Punch d where d.userfileid = ?";
	private final String GET_BY_EmployeeId = "from Punch d where d.employeeid=?";
	@Override
	public List<Punch> getByUserFileId(int userFileId) {

		 List<Punch> find = (List<Punch>)find(GET_BY_UserFileId,userFileId);
			return find;
	}
	@Override
	public List<Punch> getByEmployeeId(int employeeid) {
		List<Punch> find = (List<Punch>)find(GET_BY_EmployeeId,employeeid);
		return find;
	}

}

