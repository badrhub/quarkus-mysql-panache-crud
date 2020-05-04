package com.badr.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;

import com.badr.models.Student;

import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class StudentDao {
    
    public Student getStudent(Long id){
        Student st  = Student.findById(id);
             if(st == null){
                 throw new WebApplicationException("student with id = " + id + " doesn't exist" , 404);
             }
             return st;
    }

    public List<Student> getStudents(){
        return Student.listAll(Sort.by("nom"));
    }

    public void deleteStudent(Long id){
            Student st = Student.findById(id);
            if(st == null){
                throw new WebApplicationException("student with id = " + id + " doesn't exist" , 404);
            }
            st.delete();
    }

    public Student updateStudent(Long id , Student ne){
        Student st = Student.findById(id);
            if(st == null){
                throw new WebApplicationException("student with id = " + id + " doesn't exist" , 404);
            }
         st.nom = ne.nom;
         st.prenom = ne.prenom;
         st.age = ne.age;
         return st;
    }

    public Student addStudent(Student st){
        Student.persist(st);
        return st;
    }
}