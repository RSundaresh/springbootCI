package com.samples.jwtauth.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.jwtauth.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
