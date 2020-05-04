package com.badr.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.badr.dao.StudentDao;
import com.badr.models.Student;

@Path("students")
@Produces("application/json")
@Consumes("application/json")
public class StudentService{

    @Inject
    StudentDao service;
    
    @GET
    public Student getOne(int id){
        return service.getStudent(id);
    }

    
    
}