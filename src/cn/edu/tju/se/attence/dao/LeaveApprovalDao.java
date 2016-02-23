package cn.edu.tju.se.attence.dao;

import java.util.List;

import cn.edu.tju.se.attence.domain.LeaveApproval;
import cn.edu.tju.se.base.dao.BaseDao;



public interface LeaveApprovalDao extends BaseDao<LeaveApproval>{
	public List<LeaveApproval> getByUserFileId(int userFileId);
}