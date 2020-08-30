package com.rj.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.rj.bo.ActorBo;
import com.rj.dao.ActorDao;
import com.rj.dto.ActorDto;

public class ActorServiceImpl implements ActorService {
	private ActorDao actorDao;
	
	

	public ActorServiceImpl(ActorDao actorDao) {
		this.actorDao = actorDao;
	}



	@Override
	public List<ActorDto> fetchActorsList(String dept1, String dept2) throws SQLException {
		List<ActorDto> localAlActorDto =  new ArrayList<>();
		List<ActorBo> localAlActorBo = null;
		ActorDto localActorDto = null;
		
		localAlActorDto = new ArrayList<>();
		localAlActorBo = actorDao.getActorsList(dept1, dept2);
		
		for(ActorBo localBo:localAlActorBo)
		{
			localActorDto = new ActorDto();
			BeanUtils.copyProperties(localBo, localActorDto);
			localActorDto.setSerialNo(localAlActorDto.size()+1);
			
			localAlActorDto.add(localActorDto);
		}
		
		
		return localAlActorDto;
	}

}
