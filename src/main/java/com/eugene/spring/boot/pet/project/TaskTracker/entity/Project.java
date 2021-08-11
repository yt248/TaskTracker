package com.eugene.spring.boot.pet.project.TaskTracker.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "projects")
public class    Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "projects_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> developers = new HashSet<>();


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = {CascadeType.ALL})
    private Set<Task> taskList = new HashSet<>();


    public Project() {
    }

    public Project(String name, String description, User creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


    public Set<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(Set<Task> taskList) {
        this.taskList = taskList;
    }

    public Set<User> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<User> developers) {
        this.developers = developers;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
