package cn.edu.tju.se.attence.dao;

import java.util.List;



import cn.edu.tju.se.attence.domain.Punch;
import cn.edu.tju.se.base.dao.BaseDao;



public interface PunchDao extends BaseDao<Punch>{
	public List<Punch> getByUserFileId(int userFileId);

	public List<Punch> getByEmployeeId(int employeeid);

}