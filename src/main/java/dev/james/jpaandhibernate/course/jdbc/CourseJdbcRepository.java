package dev.james.jpaandhibernate.course.jdbc;

import dev.james.jpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository is used to connect a class to a datasource

@Repository
public class CourseJdbcRepository {


    //Spring JDPC which can be much because of the total queries to be written

    @Autowired
   private JdbcTemplate springJdbcTemplate;

   private static final String insertQuery = """
           insert into course (id,name,author) values (?,?,?);
                      
           """;

   private static final String DELETE_QUERY = """
           delete from course where id=?
           """;
  private static final String SELECT_QUERY = """
           select * from course 
           where id=?
           """;

   public void insert(Course course){
       springJdbcTemplate.update(insertQuery,course.getId(),course.getName(),course.getAuthor());
   }

   public void delete(Long id){

       springJdbcTemplate.update(DELETE_QUERY,id);
   }

   //Bean property mapper is used to map or class to the database table
   public Course findById(long id){
       return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);

   }


}
