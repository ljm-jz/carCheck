package com.xnxy.carcheck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xnxy.carcheck.po.Manager;
import com.xnxy.carcheck.service.ManagerService;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.PageListVo;

/**
 * 
 * @author mumu
 * 
 */
@Controller
@SessionAttributes({ "manager" })
public class ManagerController {

	@Autowired
	private ManagerService us;

	/**
	 * @param uname
	 * @param pwd
	 * @param map
	 * @return
	 */
	@RequestMapping("/login.action")
	@ResponseBody
	public Object login(@RequestParam("uname") String uname,
			@RequestParam("pwd") String pwd, ModelMap map) {
		Manager manager = us.login(uname, pwd);//查询数据库中是否有次用户名和密码
		if (manager != null) {
			map.addAttribute("manager", manager);//将登陆用户信息存在session中
			Message message = new Message();//创建返回信息对象
			message.setStatus(1);
			message.setMessage("登录成功");
			return message;
		} else {
			Message message = new Message();
			message.setStatus(0);
			message.setMessage("密码或用户名输入错误");
			return message;
		}
	}

	/**
	 * @param newName
	 * @return
	 */
	@RequestMapping("/checkName.action")
	@ResponseBody
	public Integer checkName(@RequestParam("uname") String newName) {
		return us.checkName(newName); //验证用户是否存在
	}

	/**
	 * @param mid
	 * @return
	 */
	@RequestMapping("/remove.action")
	@ResponseBody
	public Integer removeManager(@RequestParam("mid") Integer mid) {
		return us.removeManager(mid);//移除用户
	}

	/**
	 * @param oldPwd
	 * @param newPwd
	 * @param map
	 * @return
	 */
	@RequestMapping("changePwd.action")
	@ResponseBody
	public Message changePwd(@RequestParam("oldPwd") String oldPwd,
			@RequestParam("newPwd") String newPwd, ModelMap map,HttpServletRequest request) {
		Manager manager = (Manager) map.get("manager");//从session中获取当前用户信息
		Message message = new Message(0, "原密码输入错误");//创建返回信息
		HttpSession session = request.getSession();
		if (manager.getPwd().equals(oldPwd)) {
			if (us.changePwd(manager.getId(), newPwd) > 0) {//修改密码
				message.setStatus(1);
				message.setMessage("密码修改成功，请重新登录");
				session.removeAttribute("manager");
				map.remove("manager");
			} else {
				message.setStatus(0);
				message.setMessage("未知错误");
			}
		}
		return message;

	}

	@RequestMapping("/queryList.action")
	@ResponseBody
	public PageListVo<Manager> queryManager(
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit,
			@RequestParam(value = "condition", defaultValue = "") String condition) {
		return us.queryManager(condition);//获取用户列表
	}

	@RequestMapping("/addManager.action")
	@ResponseBody
	public Message addManager(Manager manager) {
		Message msg = new Message();
		if (us.addManeger(manager) > 0) {//添加用户
			msg.setStatus(1);
			msg.setMessage("添加成功");
		} else {
			msg.setStatus(0);
			msg.setMessage("添加失败");
		}
		return msg;
	}

	@RequestMapping("/logout.action")
	public String logout(ModelMap map,HttpServletRequest req) {
		map.remove("manager");
		req.getSession().removeAttribute("manager");
		return "redirect:login1.html";
	}

	@RequestMapping("/updateManager.action")
	@ResponseBody
	public Message updateManager(Manager manager) {
		return us.updateManager(manager);
	}
	
	@RequestMapping("/getRole.action")
	@ResponseBody
	public Object getRole(ModelMap map){
		return map.get("manager");
	}
}
