package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
       return args-> {
            Student priyasha = new Student(
                    1L,
                    "Akhouri Priyasha",
                    "akhouri.priyasha@gmail.com",
                    LocalDate.of(2022, Month.APRIL, 3)
            );
           Student abhisht = new Student(
                   2L,
                   "Abhisht Jindal",
                   "abhishtjindal@gmail.com",
                   LocalDate.of(2025, Month.APRIL, 4)
           );
          studentRepository.saveAll(
                  List.of(priyasha, abhisht)
          );
        };
    }
}
