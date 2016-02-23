package cn.edu.tju.se.attence.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.tju.se.attence.dao.EvectionApprovalDao;
import cn.edu.tju.se.attence.domain.EvectionApproval;
import cn.edu.tju.se.base.dao.hibernate.BaseDaoImpl;


@Repository
public class EvectionApprovalDaoImpl extends BaseDaoImpl<EvectionApproval> implements EvectionApprovalDao{
	private final String GET_BY_UserFileId = "from EvectionApproval d where d.userfileid = ?";
	@Override
	public List<EvectionApproval> getByUserFileId(int userFileId) {
		 List<EvectionApproval> find = (List<EvectionApproval>)find(GET_BY_UserFileId,userFileId);
			return find;
	}

}

