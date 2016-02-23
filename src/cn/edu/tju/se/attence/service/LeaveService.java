package cn.edu.tju.se.attence.service;

import java.util.List;

import cn.edu.tju.se.attence.domain.Leaving;


public interface LeaveService {
	public Leaving get(int id);

	public void update(Leaving leave);

	public void add(Leaving leave);

	public void remove(int id);

	public List<Leaving> getAll();
	
	public List<Leaving> getByUserFileId(int userFileId);
	public List<Leaving> getByApprovalUserFileId(int userFileId);

	List<Leaving> getAllLeaves();
}
