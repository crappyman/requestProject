package com.revature.ers.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.ers.entity.RequestEntity;
import com.revature.ers.pojo.RequestPojo;


@Repository("requestDao")
@Transactional
public interface RequestDao extends JpaRepository <RequestEntity,Integer>{
	 //List<RequestEntity> findReimbursementBy(Integer manger);
	
	 List<RequestEntity> findByReqStatus( int status );
}
