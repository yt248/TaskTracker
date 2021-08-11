package com.eugene.spring.boot.pet.project.TaskTracker.repository;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {

}
