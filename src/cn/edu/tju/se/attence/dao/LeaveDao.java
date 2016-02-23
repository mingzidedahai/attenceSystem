package cn.edu.tju.se.attence.dao;

import java.util.List;

import cn.edu.tju.se.attence.domain.Leaving;

import cn.edu.tju.se.base.dao.BaseDao;



public interface LeaveDao extends BaseDao<Leaving>{
	public List<Leaving> getByUserFileId(int userFileId);
	public List<Leaving> getByApprovalUserFileId(int userFileId);
	public List<Leaving> getAllLeaves();
}