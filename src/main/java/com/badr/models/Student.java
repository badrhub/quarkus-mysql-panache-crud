package com.badr.models;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
public class Student extends PanacheEntity{

    public String nom;
    public String prenom;
    public int age; 

    
}