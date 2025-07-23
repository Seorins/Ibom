package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.InjectionList;
import com.springmvc.repository.InjectionList_Repository;
import com.springmvc.repository.InjectionList_RepositoryImpl;

@Service
public class InjectionListService {

	@Autowired
	InjectionList_Repository dao;

	public void saveInjectionList(List<InjectionList> InjectionList) {
		dao.saveList(InjectionList);
		System.out.println(InjectionList);
	}

	public List<InjectionList> getInjectionList(String id, String birth) {
		System.out.println("서비스" + id);
		return dao.getInjectionList(id, birth);
	}
}
