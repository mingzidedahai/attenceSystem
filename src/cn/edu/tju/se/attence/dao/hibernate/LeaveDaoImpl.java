package cn.edu.tju.se.attence.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;


import cn.edu.tju.se.attence.dao.LeaveDao;
import cn.edu.tju.se.attence.domain.Leaving;

import cn.edu.tju.se.base.dao.hibernate.BaseDaoImpl;


@Repository
public class LeaveDaoImpl extends BaseDaoImpl<Leaving> implements LeaveDao{
	private final String GET_BY_UserFileId = "from Leaving d where d.userfileid = ?";
	private final String GET_BY_ApprovalUserFileId = "from Leaving d where d.leaveApprovals.get(0).userfileid = ?";
	private final String GET_All = "from Leaving";

	@Override
	public List<Leaving> getByUserFileId(int userFileId) {
		 List<Leaving> find = (List<Leaving>)find(GET_BY_UserFileId,userFileId);
			return find;
	}
	
	@Override
	public List<Leaving> getByApprovalUserFileId(int userFileId) {
		 List<Leaving> find = (List<Leaving>)find(GET_BY_ApprovalUserFileId,userFileId);
			return find;
	}

	@Override
	public List<Leaving> getAllLeaves() {
		List<Leaving> find = (List<Leaving>)find(GET_All);
		return find;
	}

}

