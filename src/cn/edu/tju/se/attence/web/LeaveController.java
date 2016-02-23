package cn.edu.tju.se.attence.web;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.google.gson.Gson;

import cn.edu.tju.se.attence.domain.LeaveApproval;
import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.service.LeaveApprovalService;
import cn.edu.tju.se.attence.service.LeaveService;
import cn.edu.tju.se.base.web.controller.BaseController;

@Controller
@RequestMapping(value = "/Leaves")
public class LeaveController extends BaseController {
	@Autowired
	LeaveService leaveService;

	// rest共有get、post、delete、put
	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/me/{userfileid}")
	public @ResponseBody
	List<Leaving> getByUserFileId(@PathVariable String userfileid, Model model) {
		// System.out.println("leaves++");
		// System.out.println(userfileid);
		// System.out.println("leaves++----");
		return leaveService.getByUserFileId(Integer.parseInt(userfileid));
	}


	@RequestMapping(method = RequestMethod.GET, value = "/me/leaveapprovals/{userfileid}")
	public @ResponseBody
	List<Leaving> getByAppovalUserFileId(@PathVariable String userfileid,
			Model model) {

		List<Leaving> allleaves = leaveService.getAll();
		;
		List<Leaving> leaves = new ArrayList<Leaving>();
		Iterator<Leaving> it = allleaves.iterator();

		while (it.hasNext()) {
			Leaving l = it.next();
			for (int i = 0; i < l.getLeaveApprovals().size(); i++) {

				System.out.println(l.getLeaveApprovals().size());
				if (l.getLeaveApprovals().get(i).getUserfileid() == Integer
						.parseInt(userfileid)) {

					leaves.add(l);
				}
			}
		}
		return leaves;
	}

	// get 获得
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody
	Leaving getLeave(@PathVariable String id, Model model) {
		// System.out.println(id);
		// System.out.println("leave no leaves");
		return leaveService.get(Integer.parseInt(id));
	}

	// put 更新，提交，增加
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateLeaveByPut(@RequestBody String body) {
		Leaving leave = (new Gson()).fromJson(body, Leaving.class);
		leaveService.update(leave);
	}

	// post 更新，提交，增加
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateLeaveByPost(@RequestBody String body) {
		Leaving leave = (new Gson()).fromJson(body, Leaving.class);
		leaveService.update(leave);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/me/leaveapprovals")	
	@ResponseStatus(HttpStatus.OK)
	public void addLeaveApproval(@RequestBody String body) {
		System.out.println(body);
		Leaving leave = (new Gson()).fromJson(body, Leaving.class);
		leaveService.add(leave);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addLeave(@RequestBody String body) {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		Leaving leave = (new Gson()).fromJson(body, Leaving.class);
		leaveService.add(leave);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public @ResponseBody
	List<Leaving> removeLeave(@PathVariable String id) {
		
		leaveService.remove(Integer.parseInt(id));
		List<Leaving> leaves = leaveService.getAll();
		return leaves;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Leaving> getLeaves(Model model) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		return leaveService.getAll();

	}
//	@RequestMapping(method = RequestMethod.GET)
//	public @ResponseBody
//	List<Leaving> getLeaves(Model model) {
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println();
//		return leaveService.getAllLeaves();

//	}

}
