package com.liyu.spring.dao;

import com.liyu.spring.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by twcn on 10/4/16.
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "D-AA"));
        departments.put(101, new Department(102, "D-BB"));
        departments.put(101, new Department(103, "D-CC"));
        departments.put(101, new Department(104, "D-DD"));
        departments.put(101, new Department(105, "D-EE"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
