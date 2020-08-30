package com.rj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.rj.bo.ActorBo;

public class ActorDaoImpl implements ActorDao{
	private DataSource dataSource;
	

	public ActorDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public List<ActorBo> getActorsList(String dept1, String dept2) throws SQLException {
		Connection localConnection = null;
		PreparedStatement localPrepStmt = null;
		ResultSet localRs = null;
		ActorBo localActorBo = null;
		String localStrQuery = null;
		List<ActorBo> localAlActorBo = null;
		
		localStrQuery = getQuery();
		localAlActorBo = new ArrayList<>();
		
		try {
			localConnection = dataSource.getConnection();
			localPrepStmt = localConnection.prepareStatement(localStrQuery);
			localPrepStmt.setString(1,dept1);
			localPrepStmt.setString(2,dept2);
			localRs = localPrepStmt.executeQuery();
			
			while(localRs.next())
			{
				localActorBo = new ActorBo();
				
				localActorBo.setName(localRs.getString("NAME"));
				localActorBo.setIndustryType(localRs.getString("INDUSTRY_TYPE"));
				localActorBo.setDepartment(localRs.getString("DEPARTMENT"));
				localAlActorBo.add(localActorBo);
			}
			
		} 
		catch (SQLException e) {
			throw e;
		}
		finally
		{
			if(localRs!=null)
				localRs.close();
			if(localPrepStmt!=null)
				localPrepStmt.close();
			if(localConnection!=null)
				localConnection.close();
		}
		
		return localAlActorBo;
	}


	private String getQuery() {
		StringBuilder  localSb = null;
		
		localSb = new StringBuilder();
		
		localSb.append("SELECT a.NAME, ");
		localSb.append("       i.INDUSTRY_TYPE, ");
		localSb.append("       id.DEPARTMENT ");
		localSb.append("FROM   Actors a, ");
		localSb.append("       Industry i, ");
		localSb.append("       Industrydept id ");
		localSb.append("WHERE  id.DEPARTMENT IN (?,?) ");
		localSb.append("       AND id.DEPTSEQ = a.DEPTSEQ ");
		localSb.append("       AND a.INDUSTRYSEQ = i.INDUSTRYSEQ");
		
		return localSb.toString();
	}

}
