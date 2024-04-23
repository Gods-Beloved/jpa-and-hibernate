package dev.james.jpaandhibernate.course.jpa;

import dev.james.jpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//Whenever we are working with JPA we also need the transactional

//Jpa defines specifications it is an api
//Example => How to define attributes
//How do you map attributes
//Hibernate is an implementation of jpa and most popular one

@Repository
@Transactional
public class CourseJpaRepository {

    //For jpa to talk to database we need Entity manager

   // @PersistenceContext is more specific than autowired in context of jpa

    @PersistenceContext
   private EntityManager entityManager ;


   public void insert(Course course){
       entityManager.merge(course);
   }

   public Course findById(long id){
      return entityManager.find(Course.class,id);
   }

   public void delete(long id){
       Course course = entityManager.find(Course.class,id);
       entityManager.remove(course);
   }



}
