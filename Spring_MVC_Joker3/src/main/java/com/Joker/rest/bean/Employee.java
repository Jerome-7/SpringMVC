package com.Joker.rest.bean;

import java.util.Map;

/**
 * @author Joker
 * @Date 2022/11/30 20:34
 * @Description This is description of class
 * @since version-1.0
 */
public class Employee {

    private Integer id;
    private String lastname;
    private String email;
    private Integer gender;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastName){
        this.lastname = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Integer getGender(){
        return gender;
    }

    public void setGender(Integer gender){
        this.gender = gender;
    }

    public Employee(Integer id,String lastname,String email,Integer gender){
        super();
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
    }

    public Employee(){

    }

    public void put(Integer id, Employee employee) {
    }
}
