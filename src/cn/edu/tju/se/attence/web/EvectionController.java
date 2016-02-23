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

import cn.edu.tju.se.attence.domain.Evection;
import cn.edu.tju.se.attence.domain.Leaving;
import cn.edu.tju.se.attence.service.EvectionService;
import cn.edu.tju.se.base.web.controller.BaseController;

import com.google.gson.Gson;



@Controller
@RequestMapping(value="/Evections")
public class EvectionController extends BaseController{
	@Autowired
	EvectionService evectionService;
//rest共有get、post、delete、put	
	public EvectionService getEvectionService() {
		return evectionService;
	}

	public void setEvectionService(EvectionService evectionService) {
		this.evectionService = evectionService;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/me/{userfileid}")
	public @ResponseBody List<Evection> getByUserFileId(@PathVariable String userfileid,Model model){
		return evectionService.getByUserFileId(Integer.parseInt(userfileid));
	}
	@RequestMapping(method = RequestMethod.GET, value = "/me/evectionapprovals/{userfileid}")
	public @ResponseBody
	List<Evection> getByAppovalUserFileId(@PathVariable String userfileid,
			Model model) {

		List<Evection> allevections = evectionService.getAll();
		;
		List<Evection> evections = new ArrayList<Evection>();
		Iterator<Evection> it = allevections.iterator();

		while (it.hasNext()) {
			Evection l = it.next();
			for (int i = 0; i < l.getEvectionApprovals().size(); i++) {

				System.out.println(l.getEvectionApprovals().size());
				if (l.getEvectionApprovals().get(i).getUserfileid() == Integer
						.parseInt(userfileid)) {

					evections.add(l);
				}
			}
		}
		return evections;
	}
//get 获得
	@RequestMapping(method=RequestMethod.GET, value="/{id}")	
	public @ResponseBody Evection getEvection(@PathVariable String id,Model model) {
		return evectionService.get(Integer.parseInt(id));
	}
//put 更新，提交，增加
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEvectionByPut(@RequestBody String body) {
		Evection evection = (new Gson()).fromJson(body, Evection.class);
		evectionService.update(evection);
	}
//post 更新，提交，增加
	@RequestMapping(method=RequestMethod.POST, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEvectionByPost(@RequestBody String body) {
		Evection evection = (new Gson()).fromJson(body, Evection.class);
		evectionService.update(evection);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/me/evectionapprovals")	
	@ResponseStatus(HttpStatus.OK)
	public void addEvectionApproval(@RequestBody String body) {
		System.out.println(body);
		Evection evection = (new Gson()).fromJson(body, Evection.class);
		evectionService.add(evection);
	}
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addEvection(@RequestBody String body) {
		Evection evection = (new Gson()).fromJson(body, Evection.class);
		evectionService.add(evection);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public @ResponseBody List<Evection> removeEvection(@PathVariable String id) {
		evectionService.remove(Integer.parseInt(id));
		List<Evection> evections = evectionService.getAll();
		return evections;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Evection> getEvections(Model model) {
		return evectionService.getAll();
		
	}	

}
