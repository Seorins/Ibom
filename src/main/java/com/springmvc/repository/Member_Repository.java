package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.member;

public interface Member_Repository {

	public void create(member mb);

	public member usercheck(String id, String pw);

	public member findId(String id);

	public void update(member mb);

	public void delete(String id);
	
	public List<member> readAll();
	
	public int memberCount();
	
	public List<member> getMemberPage(int page, int limit);

	public List<member> searchMember(String text);
}
