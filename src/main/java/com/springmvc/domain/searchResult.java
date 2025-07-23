package com.springmvc.domain;

import java.util.List;

public class searchResult {
	private int totalPages;
	private List<board> list;
	
	public searchResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<board> getList() {
		return list;
	}

	public void setList(List<board> list) {
		this.list = list;
	}
	
}
