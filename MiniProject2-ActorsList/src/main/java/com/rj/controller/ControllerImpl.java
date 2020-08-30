package com.rj.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.rj.dto.ActorDto;
import com.rj.service.ActorService;
import com.rj.vo.ActorVo;

public class ControllerImpl implements Controller{
	private ActorService actorService;
	

	public ControllerImpl(ActorService actorService) {
		this.actorService = actorService;
	}


	@Override
	public List<ActorVo> actorsList(String dept1, String dept2) throws SQLException {
		List<ActorVo> localAlActorVo = null;
		List<ActorDto> localAlActorDto = null;
		ActorVo localActorVo = null;
		
		localAlActorVo = new ArrayList<>();
		
		localAlActorDto = actorService.fetchActorsList(dept1, dept2);
		
		for(ActorDto dto:localAlActorDto)
		{
			localActorVo = new ActorVo();
			BeanUtils.copyProperties(dto, localActorVo);
			localActorVo.setSerialNo(String.valueOf(dto.getSerialNo()));
			localAlActorVo.add(localActorVo);
		}
		
		
		return localAlActorVo;
	}

}
