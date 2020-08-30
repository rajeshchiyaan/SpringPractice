package com.rj.dao;

import java.sql.SQLException;
import java.util.List;

import com.rj.bo.ActorBo;

public interface ActorDao {
	public List<ActorBo> getActorsList(String dept1,String dept2) throws SQLException;

}
