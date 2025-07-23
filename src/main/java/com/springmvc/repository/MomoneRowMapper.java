package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.mom;


public class MomoneRowMapper implements RowMapper<mom>{
   public mom mapRow(ResultSet rs, int rowNum) throws SQLException {
        mom mother = new mom();
        mother.setNum(rs.getInt("num"));
        mother.setName(rs.getString("name"));
        mother.setLastday(rs.getString("lastday"));
        mother.setFirst_visit(rs.getString("first_visit"));
        mother.setWeeksPregnant(rs.getLong("weeksPregnant"));
        mother.setVisitFrequency(rs.getInt("visitFrequency"));
        mother.setNextVisitDate(rs.getString("nextVisitDate"));
        mother.setDueDate(rs.getString("dueDate"));
        return mother;
   }
}
