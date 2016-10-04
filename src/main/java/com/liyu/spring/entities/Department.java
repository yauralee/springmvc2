package com.liyu.spring.entities;

/**
 * Created by twcn on 10/4/16.
 */
public class Department {

    private Integer id;
    private String departmentName;

    public Department(Integer id, String departmentName){
        this.id = id;
        this.departmentName = departmentName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
