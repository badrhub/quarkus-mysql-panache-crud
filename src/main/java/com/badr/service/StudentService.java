package com.badr.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.badr.dao.StudentDao;
import com.badr.models.Student;

@Path("students")
@Produces("application/json")
@Consumes("application/json")
public class StudentService{

    @Inject
    StudentDao service;
    
    @GET
    @Path("{id}")
    public Student getOne(@PathParam("id") int id){
        return service.getStudent(id);
    }
    
    @GET
    public List<Student> getAll(){
        return service.getStudents();
    }

    @POST
    @Transactional
    public Response addStudent(Student st){
        Student s = service.addStudent(st);
        return Response.ok(s).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response updateStudent(@PathParam("id") int id, Student e){
      Student st = service.updateStudent(id, e);
      return Response.ok(st).status(204).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteStudent(@PathParam("id") int id){
       service.deleteStudent(id);
      return Response.status(204).build();
    }

    
}