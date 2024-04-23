package dev.james.jpaandhibernate.course;

import dev.james.jpaandhibernate.course.Course;
import dev.james.jpaandhibernate.course.jdbc.CourseJdbcRepository;
import dev.james.jpaandhibernate.course.jpa.CourseJpaRepository;
import dev.james.jpaandhibernate.course.springdatajpa.CourseSpringDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Code inside commandLineRunner is run when the application starts


@Component
public class CourseCommandLineRunner implements CommandLineRunner {


    //For running jdbc
  // private final CourseJdbcRepository courseRepository;

    //For running jpa
//    private final CourseJpaRepository courseRepository;
    @Autowired
    private CourseSpringDataJpa courseRepository;





//    @Autowired
//    public CourseCommandLineRunner(CourseJpaRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    @Override
    public void run(String... args) throws Exception {
        courseRepository.save(new Course(1,"Learn Google cloud JPA","junior"));
        courseRepository.save(new Course(2,"Learn Azure Cloud","junior"));
        courseRepository.save(new Course(3,"Learn AWS cloud","junior"));

        // courseRepository.delete(2L);

        Course course = courseRepository.findById(2L).orElseThrow();

        courseRepository.deleteById(2l);


        System.out.println(courseRepository.findByAuthor("junior"));


        System.out.println(courseRepository.findAll());
        System.out.println(courseRepository.count());
    }
}
