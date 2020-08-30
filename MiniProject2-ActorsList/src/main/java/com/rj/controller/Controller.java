package com.rj.controller;

import java.sql.SQLException;
import java.util.List;

import com.rj.vo.ActorVo;

public interface Controller {
	public List<ActorVo> actorsList(String dept1,String dept2) throws SQLException;
	

}
