package cn.edu.tju.se.attence.service;

import java.util.List;

import cn.edu.tju.se.attence.domain.EvectionApproval;


public interface EvectionApprovalService {
	public EvectionApproval get(int id);

	public void update(EvectionApproval evectionApproval);

	public void add(EvectionApproval evectionApproval);

	public void remove(int id);

	public List<EvectionApproval> getAll();
	
	public List<EvectionApproval> getByUserFileId(int userFileId);
}
