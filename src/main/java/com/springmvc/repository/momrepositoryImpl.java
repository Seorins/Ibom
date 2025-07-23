package com.springmvc.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.mom;

@Repository
public class momrepositoryImpl implements momrepository{
   
   private List<mom> listmom = new ArrayList<mom>();
   
   private JdbcTemplate template;
   //database 연결하기 위해 servlet-context.xml에 지정해놓은 객체 초기화
   
   @Autowired
   public void setJdbctemplate(DataSource dataSource) {
      this.template = new JdbcTemplate(dataSource);
      
   }

    @Override
    public void create(mom mother, HttpServletRequest request) {
        System.out.println("create 리파지토리");
        HttpSession session = request.getSession(false);
        String id = (String)session.getAttribute("sessionId");

        String sql = "insert into mom_visit(id, lastday, first_visit, name, visitFrequency, nextVisitDate) values(?,?,?,?,?,?)";
        template.update(sql, id, mother.getLastday(), mother.getFirst_visit(), mother.getName(), mother.getVisitFrequency(), mother.getNextVisitDate());

        listmom.add(mother);
    }

   @Override
   public List<mom> readall(String sessionId) {
      System.out.println("readall 리파지토리");
      String sql = "select * from mom_visit where id=?";
      listmom = template.query(sql, new Object[]{sessionId}, new MomoneRowMapper());
      return listmom;
   }
   
   @Override
   public mom readone(int num) {
      System.out.println("readone 리파지토리");
      mom motherone = new mom();
      String sql = "SELECT * FROM mom_visit WHERE num = ?";
      motherone =template.queryForObject(sql, new Object[]{num}, new MomoneRowMapper());
      return motherone;
   }
   
    @Override
    public void update(mom mother) {
        System.out.println("update 리파지토리");

        String sql = "UPDATE mom_visit SET lastday = ?, first_visit = ?, visitFrequency = ?, nextVisitDate = ? WHERE num = ?";
        template.update(sql, mother.getLastday(), mother.getFirst_visit(), mother.getVisitFrequency(), mother.getNextVisitDate(), mother.getNum());
    }
    
    
    @Override
    public void delete(int num) {
       String sql = "delete from mom_visit where num=?";
       template.update(sql, num);
       
    }
    

    

   
   
}
