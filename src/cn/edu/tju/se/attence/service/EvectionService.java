package cn.edu.tju.se.attence.service;

import java.util.List;

import cn.edu.tju.se.attence.domain.Evection;


public interface EvectionService {
	public Evection get(int id);

	public void update(Evection evection);

	public void add(Evection evection);

	public void remove(int id);

	public List<Evection> getAll();
	
	public List<Evection> getByUserFileId(int userFileId);

	List<Evection> getByApprovalUserFileId(int userFileId);
}
