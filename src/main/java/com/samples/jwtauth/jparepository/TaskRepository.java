package com.samples.jwtauth.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.samples.jwtauth.dto.UserAndTaskInfo;
import com.samples.jwtauth.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("SELECT COUNT(*) AS TOTAL_COUNT FROM Task")
	Integer getCountOfTasks();
	
	
	@Query("SELECT COUNT(*) AS TOTAL_COUNT,   "
			+ "COUNT(CASE WHEN t.id > 5 THEN 1 ELSE NULL END) AS ID_COUNT "
			+ "FROM Task AS t")
	List<Object> getMultipleCountOfTasks();
	
	
	@Query("SELECT new com.samples.jwtauth.dto.UserAndTaskInfo(t.id, t.description, u.id, u.username) "
			+ "FROM Task as t JOIN ApplicationUser as u ON t.id = u.id where u.username = :username")
	List<UserAndTaskInfo> getUserTaskInfo(@Param("username") String userName);
}
