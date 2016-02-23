package cn.edu.tju.se.attence.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.tju.se.attence.dao.LeaveApprovalDao;
import cn.edu.tju.se.attence.domain.LeaveApproval;
import cn.edu.tju.se.base.dao.hibernate.BaseDaoImpl;


@Repository
public class LeaveApprovalDaoImpl extends BaseDaoImpl<LeaveApproval> implements LeaveApprovalDao{
	private final String GET_BY_UserFileId = "from LeaveApproval d where d.userfileid = ?";
	@Override
	public List<LeaveApproval> getByUserFileId(int userFileId) {
		 List<LeaveApproval> find = (List<LeaveApproval>)find(GET_BY_UserFileId,userFileId);
			return find;
	}

}

