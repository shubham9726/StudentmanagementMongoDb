package com.decipherzone.studmgntmongodb.dto;

import com.decipherzone.studmgntmongodb.model.Role;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class UserDataDTO {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ApiModelProperty
    private String name;
    @ApiModelProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ApiModelProperty
    private String lastName;
    @ApiModelProperty
    private String email;
    @ApiModelProperty
    private String password;
    @ApiModelProperty
    List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
