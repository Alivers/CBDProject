package com.digital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digital.entity.Type;
import com.digital.dao.TypeDAO;
import com.digital.dao.BaseDAO;

public class TypeDAOImpl extends BaseDAO implements TypeDAO{
	Connection conn = null;		// 无限定符，default：包内友好
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public List<Type> getAll(){
		List<Type> typeList = null;
		typeList = new ArrayList<Type>();
		String sql = "select * from type";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Type type = null;
			while (rs.next()) {
				type = new Type();
				type.setId(rs.getInt("id"));
				type.setName(rs.getString(2));
				typeList.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return typeList;
	}
}
