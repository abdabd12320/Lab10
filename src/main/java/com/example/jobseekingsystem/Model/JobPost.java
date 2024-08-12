package com.example.jobseekingsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title should not be empty")
    @Size(min = 5,message = "title must be more than 4 characters")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String description;

    @NotEmpty(message = "location should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String location;

    @NotNull(message = "salary should not be null")
    @Positive(message = "salary should be positive")
    @Column(columnDefinition = "DOUBLE NOT NULL") //CHECK(salary >= 0)
    private double salary;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "VARCHAR(11)")
    private LocalDate postingDate;
}
