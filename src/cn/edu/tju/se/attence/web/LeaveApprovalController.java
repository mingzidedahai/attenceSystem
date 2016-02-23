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

import cn.edu.tju.se.attence.domain.LeaveApproval;
import cn.edu.tju.se.attence.service.LeaveApprovalService;
import cn.edu.tju.se.base.web.controller.BaseController;

import com.google.gson.Gson;



@Controller
@RequestMapping(value="/LeaveApprovals")
public class LeaveApprovalController extends BaseController{
	@Autowired
	LeaveApprovalService leaveApprovalService;
//rest共有get、post、delete、put	
	public LeaveApprovalService getLeaveApprovalService() {
		return leaveApprovalService;
	}

	public void setLeaveApprovalService(LeaveApprovalService leaveApprovalService) {
		this.leaveApprovalService = leaveApprovalService;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/me/{userfileid}")
	public @ResponseBody List<LeaveApproval> getByUserFileId(@PathVariable String userfileid,Model model){
		return leaveApprovalService.getByUserFileId(Integer.parseInt(userfileid));
	}

//get 获得
	@RequestMapping(method=RequestMethod.GET, value="/{id}")	
	public @ResponseBody LeaveApproval getLeaveApproval(@PathVariable String id,Model model) {
		return leaveApprovalService.get(Integer.parseInt(id));
	}
//put 更新，提交，增加
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateLeaveApprovalByPut(@RequestBody String body) {
		LeaveApproval leaveApproval = (new Gson()).fromJson(body, LeaveApproval.class);
		leaveApprovalService.update(leaveApproval);
	}
//post 更新，提交，增加
	@RequestMapping(method=RequestMethod.POST, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateLeaveApprovalByPost(@RequestBody String body) {
		LeaveApproval leaveApproval = (new Gson()).fromJson(body, LeaveApproval.class);
		leaveApprovalService.update(leaveApproval);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addLeaveApproval(@RequestBody String body) {
		LeaveApproval leaveApproval = (new Gson()).fromJson(body, LeaveApproval.class);
		leaveApprovalService.add(leaveApproval);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public @ResponseBody List<LeaveApproval> removeLeaveApproval(@PathVariable String id) {
		leaveApprovalService.remove(Integer.parseInt(id));
		List<LeaveApproval> leaveApprovals = leaveApprovalService.getAll();
		return leaveApprovals;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<LeaveApproval> getLeaveApprovals(Model model) {
		return leaveApprovalService.getAll();
		
	}	

}
