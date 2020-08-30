package com.rj.service;

import java.sql.SQLException;
import java.util.List;

import com.rj.dto.ActorDto;

public interface ActorService {
	public List<ActorDto> fetchActorsList(String dept1,String dept2) throws SQLException;

}
