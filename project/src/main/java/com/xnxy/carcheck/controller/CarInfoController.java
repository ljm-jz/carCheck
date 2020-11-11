package com.xnxy.carcheck.controller;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xnxy.carcheck.po.CarInfo;
import com.xnxy.carcheck.service.CarInfoService;
import com.xnxy.carcheck.vo.CarInfoVo;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.PageListVo;

@Controller
public class CarInfoController {

	@Autowired
	private CarInfoService carInfoService;

	/**
	 * 
	 * @param carInfo
	 * @return
	 */
	//更新检车信息
	@RequestMapping("/carInfoUpdata.action")
	@ResponseBody
	public Message updataCarInfo(CarInfoVo carInfo) {

		try {
			return carInfoService.updataCarInfo(carInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0,"日期转换异常");
		}
	}

	//根据id，删除检车信息
	@RequestMapping("/carInfodel.action")
	@ResponseBody
	public Message deleteCarInfo(@RequestParam("mid") Integer id) {
		return carInfoService.deleteCarInfo(id);
	}

	//添加检车信息
	@RequestMapping("/carInfoAdd.action")
	@ResponseBody
	public Message addCarInfo(CarInfoVo carInfo) {
		try {
			return carInfoService.addCarInfo(carInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0,"日期转换异常");
		}
	}

	//查询全部检车信息或符合条件的检车信息
	@RequestMapping("/carInfoList.action")
	@ResponseBody
	public PageListVo<CarInfo> queryCarInfo(
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit,
			@RequestParam(value = "condition", defaultValue ="") String condition) {
		return carInfoService.queryCarInfo(condition);
	}

	//验证车车牌号是否存在
	@RequestMapping("/checkCarId.action")
	@ResponseBody
	public Message checkCarId(@RequestParam("carId") String carId) {
		return carInfoService.checkCarId(carId);
	}

	//检车到期通知
	@RequestMapping("/notice.action")
	@ResponseBody
	public Message notice(@RequestParam("param") String param) {
		JSONObject json = JSON.parseObject(param);
		try {
			return carInfoService.notice(new CarInfo(null, json
					.getString("carId"), null, json.getString("ownnerName"),
					json.getString("ownnerPhone"),
					json.getDate("carCheckTime"), json
							.getDate("carInsuranceTime"), json
							.getDate("technicalGradeTime"), json
							.getDate("secondMaintenanceTime")));
			// return carInfoService.notice(carinfo);
		} catch (UnknownHostException uhe) {
			// TODO Auto-generated catch block
			uhe.printStackTrace();
			return new Message(0, "未联网，连不到短信发送平台");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0, "未知错误");
		}
	}
}
