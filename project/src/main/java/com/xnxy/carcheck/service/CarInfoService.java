package com.xnxy.carcheck.service;

import com.xnxy.carcheck.po.CarInfo;
import com.xnxy.carcheck.vo.CarInfoVo;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.PageListVo;

/**
 * 
 * @author mumu
 *
 */
public interface CarInfoService {

	/**
	 * 更新车检信息
	 * @param carInfo
	 * @return
	 */
	Message updataCarInfo(CarInfoVo carInfo) throws Exception;

	/**
	 * 移除车检信息
	 * @param id
	 * @return
	 */
	Message deleteCarInfo(Integer id);

	/**
	 * 添加车检信息
	 * @param carInfo
	 * @return
	 */
	Message addCarInfo(CarInfoVo carInfo) throws Exception;

	/**
	 * 查询车检信息
	 * @param condition
	 * @return
	 */
	PageListVo<CarInfo> queryCarInfo(String condition);

	/**
	 * 校验车牌号是否以登记
	 * @param carId
	 * @return
	 */
	Message checkCarId(String carId);

	Message notice(CarInfo carInfo) throws Exception;

}
