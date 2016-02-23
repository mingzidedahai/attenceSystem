package cn.edu.tju.se.attence.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;



import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.attence.service.UserFileService;
import cn.edu.tju.se.base.cons.CommonConstant.Role;
import cn.edu.tju.se.base.web.controller.BaseController;


import com.google.gson.Gson;
@Controller
@RequestMapping(value="/UserFiles")

public class UserFileController extends BaseController {
  
	@Autowired
	UserFileService userFileService;
	
	
	public UserFileService getUserFileService() {
		return userFileService;
	}

	public void setUserFileService(UserFileService userFileService) {
		this.userFileService = userFileService;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")	
	public @ResponseBody UserFile getUserFile(@PathVariable String id,Model model) {
		System.out.println(id+"+++");
		
		return userFileService.get(Integer.parseInt(id));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateUserFileByPut(@RequestBody String body) {
		UserFile userFile = (new Gson()).fromJson(body, UserFile.class);
		userFileService.update(userFile);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateUserFileByPost(@RequestBody String body) {
		UserFile userFile = (new Gson()).fromJson(body, UserFile.class);
		userFileService.update(userFile);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addUserFile(@RequestBody String body) {
		UserFile userFile = (new Gson()).fromJson(body, UserFile.class);
		userFileService.add(userFile);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public @ResponseBody List<UserFile> removeUserFile(@PathVariable String id) {
		userFileService.remove(Integer.parseInt(id));
		List<UserFile> userFiles = userFileService.getAll();
		return userFiles;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<UserFile> getUserFiles(Model model) {
		return userFileService.getAll();
	}	
	@RequestMapping(method=RequestMethod.GET, value="/BM")
	public @ResponseBody List<UserFile> getBMUserFiles(Model model) {
		
		return userFileService.getByRole(Role.部门经理 );
	}	
	@RequestMapping(method=RequestMethod.GET, value="/FZ")
	public @ResponseBody List<UserFile> getFZUserFiles(Model model) {
		return userFileService.getByRole(Role.副总经理 );
	}	
	@RequestMapping(method=RequestMethod.GET, value="/Z")
	public @ResponseBody List<UserFile> getZUserFiles(Model model) {
		return userFileService.getByRole(Role.总经理 );
	}	
	
}
