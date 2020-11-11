package com.xnxy.carcheck.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xnxy.carcheck.po.Manager;

/**
 * 
 * @author Administrator
 *
 */
public interface ManagerDao {
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Manager login(@Param("name") String name, @Param("pwd") String pwd);
	
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
	public Integer checkName(@Param("name") String newName);
	
	/**
	 * 
	 * @param mid
	 * @return
	 */
	public Integer removeManager(@Param("mid") Integer mid);
	
	/**
	 * 
	 * @param mid
	 * @param pwd
	 * @return
	 */
	public int changePwd(@Param("mid") Integer mid, @Param("pwd") String pwd);
	
	/**
	 * 
	 * @param manager
	 * @return
	 */
	public List<Manager> queryManager(@Param("condition") String condition);

	public Integer updateManager(Manager manager);
}
