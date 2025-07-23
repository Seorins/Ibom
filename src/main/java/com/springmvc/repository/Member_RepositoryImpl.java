package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.member;

@Repository
public class Member_RepositoryImpl implements Member_Repository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 멤버 삽입
	public void create(member mb) {
		String sql = "insert into member (id, pw, name, postcode, address, detailAddress, extraAddress, birth, phone, due) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, mb.getId(), mb.getPw(), mb.getName(), mb.getPostcode(), mb.getAddress(),
				mb.getDetailAddress(), mb.getExtraAddress(), mb.getBirth(), mb.getPhone(), mb.getDue());
	}

	// 멤버 usercheck
	public member usercheck(String id, String pw) {
		String sql = "select * from member where id = ? and pw = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id, pw }, new MemberRowMapper());
		} catch (Exception e) {
			return null;
		}
	}

	// 아이디 검색
	public member findId(String id) {
		String sql = "select * from member where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new MemberRowMapper());
		} catch (Exception e) {
			return null;
		}
	}

	// 멤버 회원정보 수정
	public void update(member mb) {
		System.out.println("리파지토리 멤버: " + mb);
		String sql = "update member set pw = ?, name = ?, postcode = ?, address = ?, detailAddress = ?,  extraAddress = ?, birth = ?, phone = ?, due = ? where id = ?";
		jdbcTemplate.update(sql, mb.getPw(), mb.getName(), mb.getPostcode(), mb.getAddress(), mb.getDetailAddress(),
				mb.getExtraAddress(), mb.getBirth(), mb.getPhone(), mb.getDue(), mb.getId());
	}

	// 멤버 회원정보 삭제
	public void delete(String id) {
		String sql = "delete from member where id=?";
		jdbcTemplate.update(sql, id);
	}
	
	//멤버 전부 불러오기 
	public List<member> readAll(){
		String sql = "select * from member";
		return jdbcTemplate.query(sql, new MemberRowMapper());
	}
	
	//멤버 수 세리
	public int memberCount() {
		String sql = "select count(*) from member";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
	    return (count != null) ? count : 0;
	}
	
	public List<member> getMemberPage(int page, int limit){
		int offset = (page - 1) * limit; 
	    String sql = "select * from member order by id limit ? offset ?";
	    return jdbcTemplate.query(sql, new Object[] { limit, offset }, new BeanPropertyRowMapper<>(member.class));
	}

	public List<member> searchMember(String text){
		String sql = "select * from member where name like ?";
		String plustext = "%" + text + "%";
		return jdbcTemplate.query(sql, new Object[] {plustext}, new MemberRowMapper());
		
			
	}
	
}
