package cn.edu.tju.se.attence.dao;

import java.util.List;



import cn.edu.tju.se.attence.domain.EvectionApproval;
import cn.edu.tju.se.base.dao.BaseDao;



public interface EvectionApprovalDao extends BaseDao<EvectionApproval>{
	public List<EvectionApproval> getByUserFileId(int userFileId);
}