package cn.edu.tju.se.attence.service;

import java.util.List;

import cn.edu.tju.se.attence.domain.Punch;


public interface PunchService {
	public Punch get(int id);

	public void update(Punch punch);

	public void add(Punch punch);

	public void remove(int id);

	public List<Punch> getAll();
	
	public List<Punch> getByUserFileId(int userFileId);

	public List<Punch> getByEmployeeId(int employeeid);
}
