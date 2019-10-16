package com.decipherzone.studmgntmongodb.dto;

import com.decipherzone.studmgmtmongodb.model.Role;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserResponseDTO {

    @ApiModelProperty
    private Integer id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String lastName;
    @ApiModelProperty
    private String email;
    @ApiModelProperty
    List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
