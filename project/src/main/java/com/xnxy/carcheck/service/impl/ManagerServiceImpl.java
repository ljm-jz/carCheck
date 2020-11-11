package com.xnxy.carcheck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnxy.carcheck.dao.ManagerDao;
import com.xnxy.carcheck.po.Manager;
import com.xnxy.carcheck.service.ManagerService;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.PageListVo;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDao ud;
	@Override
	public Manager login(String name, String pwd) {
		// TODO Auto-generated method stub
		return ud.login(name,pwd);
	}

	@Override
	public Integer addManeger(Manager manager) {
		// TODO Auto-generated method stub
		return ud.addManeger(manager);
	}

	@Override
	public Integer checkName(String newName) {
		// TODO Auto-generated method stub
		return ud.checkName(newName);
	}

	@Override
	public Integer removeManager(Integer mid) {
		// TODO Auto-generated method stub
		return ud.removeManager(mid);
	}

	@Override
	public int changePwd(Integer mid,String pwd) {
		// TODO Auto-generated method stub
		return ud.changePwd(mid,pwd);
	}

	@Override
	public PageListVo<Manager> queryManager(String condition) {
		// TODO Auto-generated method stub
		List<Manager> list = ud.queryManager(condition);
		PageListVo<Manager> pagelist=new PageListVo<Manager>(0, "", list.size(), list); 
		return pagelist;
	}

	@Override
	public Message updateManager(Manager manager) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		if(ud.updateManager(manager)>0){
			msg.setStatus(1);
			msg.setMessage("修改成功");
		}else{
			msg.setStatus(0);
			msg.setMessage("修改失败");
		}
		return msg;
	}

}
