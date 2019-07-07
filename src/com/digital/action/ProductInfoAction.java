package com.digital.action;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

import com.digital.dao.TypeDAO;
import com.digital.dao.impl.TypeDAOImpl;
import com.digital.entity.Type;

import java.util.List;
import java.util.Map;

public class ProductInfoAction extends ActionSupport implements RequestAware{
	Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String list() {
		TypeDAO typeDAO = new TypeDAOImpl();
		List<Type> typeList = typeDAO.getAll();
		
		if (!typeList.isEmpty()) {
			request.put("typeList", typeList);
		}
		return "index";
	}
}
