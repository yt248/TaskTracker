package com.eugene.spring.boot.pet.project.TaskTracker.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String gender;

    private String verificationCode;

    private boolean enabled;

    private Date birthday;

    private Set<RoleDto> roles = new HashSet<>();

    private Set<ProjectDto> creatingProjects = new HashSet<>();

    private Set<ProjectDto> listOfDeveloperProjects = new HashSet<>();


    public UserDto() {
    }

    public UserDto(String name, String surname, String email, String password, String gender, String verificationCode, boolean enabled, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.verificationCode = verificationCode;
        this.enabled = enabled;
        this.birthday = birthday;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public Set<ProjectDto> getCreatingProjects() {
        return creatingProjects;
    }

    public void setCreatingProjects(Set<ProjectDto> creatingProjects) {
        this.creatingProjects = creatingProjects;
    }

    public Set<ProjectDto> getListOfDeveloperProjects() {
        return listOfDeveloperProjects;
    }

    public void setListOfDeveloperProjects(Set<ProjectDto> listOfDeveloperProjects) {
        this.listOfDeveloperProjects = listOfDeveloperProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
