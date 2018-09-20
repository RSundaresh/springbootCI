package com.samples.jwtauth.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.samples.jwtauth.dto.UserCountInfo;
import com.samples.jwtauth.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
	
    ApplicationUser findByUsername(String username);
    
	/*

SQL to execute 
--------------
SELECT 
  u.username, 
  COUNT(u.id) as idcount,
  u.password AS passwd
FROM user AS u
GROUP BY u.username, passwd
ORDER BY idcount DESC, u.username ASC

Generated org.Hibernate.SQL (upon running the following @Query )
---------------------------
select 
	applicatio0_.username as col_0_0_, 
	count(applicatio0_.id) as col_1_0_, 
	applicatio0_.password as col_2_0_ 
from user applicatio0_ 
group by applicatio0_.username , applicatio0_.password 
order by count(applicatio0_.id) DESC, applicatio0_.username ASC
----
	
	 */
	
	@Query("SELECT "
			+ "new com.samples.jwtauth.dto.UserCountInfo(u.username, COUNT(u.id), u.password)  "
			+ "FROM com.samples.jwtauth.model.ApplicationUser AS u "
			+ "GROUP BY u.username, u.password "
			+ "ORDER BY COUNT(u.id) DESC, u.username ASC"
	)
	List<UserCountInfo> getUserCountInfo();
			
}