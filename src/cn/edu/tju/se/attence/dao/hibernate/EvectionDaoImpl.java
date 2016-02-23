package cn.edu.tju.se.attence.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.tju.se.attence.dao.EvectionDao;
import cn.edu.tju.se.attence.domain.Evection;
import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.base.dao.hibernate.BaseDaoImpl;


@Repository
public class EvectionDaoImpl extends BaseDaoImpl<Evection> implements EvectionDao{
	private final String GET_BY_UserFileId = "from Evection d where d.userfileid = ?";
	private final String GET_BY_ApprovalUserFileId = "from Evection d where d.evectionApprovals.get(0).userfileid = ?";
	@Override
	public List<Evection> getByUserFileId(int userFileId) {
		 List<Evection> find = (List<Evection>)find(GET_BY_UserFileId,userFileId);
			return find;
	}
	@Override
	public List<Evection> getByApprovalUserFileId(int userFileId) {
		 List<Evection> find = (List<Evection>)find(GET_BY_ApprovalUserFileId,userFileId);
			return find;
	}
}

