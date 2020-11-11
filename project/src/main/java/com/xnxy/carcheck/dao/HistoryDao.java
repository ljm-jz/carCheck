package com.xnxy.carcheck.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xnxy.carcheck.vo.HistoryVo;

public interface HistoryDao {

	List<HistoryVo> queryHistory();
	
	Integer saveHistory(@Param("fileName") String fileName, @Param("leadTime") Date leadTime, @Param("mid") Integer mid);
	

}
