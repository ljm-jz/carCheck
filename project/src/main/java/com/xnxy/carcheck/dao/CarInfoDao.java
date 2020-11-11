package com.xnxy.carcheck.dao;

import java.util.List;

import com.xnxy.carcheck.po.CarInfo;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * @author Administrator
 *
 */
public interface CarInfoDao {

	/**
	 * 
	 * @param carInfo
	 * @return
	 */
	Integer updataCarInfo(CarInfo carInfo);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteCarInfo(@Param("id") Integer id);
	
	/**
	 * 
	 * @param carinfo
	 * @return
	 */
	Integer addCarInfo(CarInfo carinfo);
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	List<CarInfo> queryCarInfo();
	List<CarInfo> queryFiewCarInfo(@Param("condition") String condition);
	
	/**
	 * 
	 * @param carId
	 * @return
	 */
	Integer checkCarId(@Param("carId") String carId);
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	Integer insertBatch(List<CarInfo> list);
	
	public Integer truncatCarInfo();
	

}
