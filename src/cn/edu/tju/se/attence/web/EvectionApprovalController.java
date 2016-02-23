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

import cn.edu.tju.se.attence.domain.EvectionApproval;
import cn.edu.tju.se.attence.service.EvectionApprovalService;
import cn.edu.tju.se.base.web.controller.BaseController;

import com.google.gson.Gson;



@Controller
@RequestMapping(value="/EvectionApprovals")
public class EvectionApprovalController extends BaseController{
	@Autowired
	EvectionApprovalService evectionApprovalService;
//rest共有get、post、delete、put	
	public EvectionApprovalService getEvectionApprovalService() {
		return evectionApprovalService;
	}

	public void setEvectionApprovalService(EvectionApprovalService evectionApprovalService) {
		this.evectionApprovalService = evectionApprovalService;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/me/{userfileid}")
	public @ResponseBody List<EvectionApproval> getByUserFileId(@PathVariable String userfileid,Model model){
		return evectionApprovalService.getByUserFileId(Integer.parseInt(userfileid));
	}
//get 获得
	@RequestMapping(method=RequestMethod.GET, value="/{id}")	
	public @ResponseBody EvectionApproval getEvectionApproval(@PathVariable String id,Model model) {
		return evectionApprovalService.get(Integer.parseInt(id));
	}
//put 更新，提交，增加
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEvectionApprovalByPut(@RequestBody String body) {
		EvectionApproval evectionApproval = (new Gson()).fromJson(body, EvectionApproval.class);
		evectionApprovalService.update(evectionApproval);
	}
//post 更新，提交，增加
	@RequestMapping(method=RequestMethod.POST, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEvectionApprovalByPost(@RequestBody String body) {
		EvectionApproval evectionApproval = (new Gson()).fromJson(body, EvectionApproval.class);
		evectionApprovalService.update(evectionApproval);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addEvectionApproval(@RequestBody String body) {
		EvectionApproval evectionApproval = (new Gson()).fromJson(body, EvectionApproval.class);
		evectionApprovalService.add(evectionApproval);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public @ResponseBody List<EvectionApproval> removeEvectionApproval(@PathVariable String id) {
		evectionApprovalService.remove(Integer.parseInt(id));
		List<EvectionApproval> evectionApprovals = evectionApprovalService.getAll();
		return evectionApprovals;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<EvectionApproval> getEvectionApprovals(Model model) {
		return evectionApprovalService.getAll();
		
	}	

}
