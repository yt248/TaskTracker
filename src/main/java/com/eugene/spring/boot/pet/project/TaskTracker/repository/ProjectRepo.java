package com.eugene.spring.boot.pet.project.TaskTracker.repository;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.creator.email = :creator")
    List<Project> findProjectByCreator(@Param("creator") String creator);



}
