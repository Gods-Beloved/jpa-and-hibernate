package dev.james.jpaandhibernate.course.jpa;

import dev.james.jpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Code inside commandLineRunner is run when the application starts


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

   private final CourseJdbcRepository courseJdbcRepository;



    @Autowired
    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1,"Learn GCP","Arkoh"));
        courseJdbcRepository.insert(new Course(2,"Learn Azure","James"));
        courseJdbcRepository.insert(new Course(3,"Learn AWS","Godwill"));

         courseJdbcRepository.delete(2L);

        System.out.println(courseJdbcRepository.findById(3L));
        System.out.println(courseJdbcRepository.findById(1L));
    }
}
