package com.xnxy.carcheck.service;

import com.xnxy.carcheck.po.Manager;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.PageListVo;

/**
 * 
 * @author Administrator
 *
 */
public interface ManagerService {
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Manager login(String name, String pwd);
	
	/**
	 * 
	 * @param maneger
	 * @return
	 */
	public Integer addManeger(Manager maneger);
	
	/**
	 * 
	 * @param newName
	 * @return
	 */
	public Integer checkName(String newName);
	
	/**
	 * 
	 * @param mid
	 * @return
	 */
	public Integer removeManager(Integer mid);
	
	/**
	 * 
	 * @param mid
	 * @param pwd
	 * @return
	 */
	public int changePwd(Integer mid, String pwd);
	
	/**
	 * 
	 * @param manager
	 * @return
	 */
	public PageListVo<Manager> queryManager(String condition);

	public Message updateManager(Manager manager);
}
