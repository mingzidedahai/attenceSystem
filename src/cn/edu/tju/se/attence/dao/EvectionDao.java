package cn.edu.tju.se.attence.dao;

import java.util.List;



import cn.edu.tju.se.attence.domain.Evection;
import cn.edu.tju.se.base.dao.BaseDao;



public interface EvectionDao extends BaseDao<Evection>{
	public List<Evection> getByUserFileId(int userFileId);

	List<Evection> getByApprovalUserFileId(int userFileId);
}