package cn.edu.tju.se.attence.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.edu.tju.se.attence.domain.Punch;
import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.attence.service.PunchService;
import cn.edu.tju.se.attence.service.UserFileService;
import cn.edu.tju.se.base.web.controller.BaseController;

import com.google.gson.Gson;



@Controller
@RequestMapping(value="/Punchs")
public class PunchController extends BaseController{
	@Autowired
	PunchService punchService;
	@Autowired
	UserFileService userFileService;
//rest共有get、post、delete、put	
	public PunchService getPunchService() {
		return punchService;
	}

	public void setPunchService(PunchService punchService) {
		this.punchService = punchService;
	}
	
	public UserFileService getUserFileService() {
		return userFileService;
	}

	public void setUserFileService(UserFileService userFileService) {
		this.userFileService = userFileService;
	}

	@RequestMapping(method=RequestMethod.GET,value="/me/{userfileid}")
	public @ResponseBody List<Punch> getByEmployeeId(@PathVariable String userfileid,Model model){
		System.out.println("me punchs");
		System.out.println(userfileid);
		
		System.out.println(userFileService.get(Integer.parseInt(userfileid)));
		System.out.println(userFileService.get(Integer.parseInt(userfileid)).getEmployeeid());
		System.out.println(punchService.getByEmployeeId(userFileService.get(Integer.parseInt(userfileid)).getEmployeeid()));
		return punchService.getByEmployeeId(userFileService.get(Integer.parseInt(userfileid)).getEmployeeid());
	}
//get 获得
	@RequestMapping(method=RequestMethod.GET, value="/{id}")	
	public @ResponseBody Punch getPunch(@PathVariable String id,Model model) {
		return punchService.get(Integer.parseInt(id));
	}
//put 更新，提交，增加
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updatePunchByPut(@RequestBody String body) {
		Punch punch = (new Gson()).fromJson(body, Punch.class);
		punchService.update(punch);
	}
//post 更新，提交，增加
	@RequestMapping(method=RequestMethod.POST, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updatePunchByPost(@RequestBody String body) {
		Punch punch = (new Gson()).fromJson(body, Punch.class);
		punchService.update(punch);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addPunch(@RequestBody String body) {
		Punch punch = (new Gson()).fromJson(body, Punch.class);
		punchService.add(punch);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public @ResponseBody List<Punch> removePunch(@PathVariable String id) {
		punchService.remove(Integer.parseInt(id));
		List<Punch> punchs = punchService.getAll();
		return punchs;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	
	public @ResponseBody List<Punch> getPunchs(Model model) {
		System.out.println("hhhhpunchlist");
		return punchService.getAll();
		
	}	

}
