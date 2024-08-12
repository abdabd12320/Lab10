package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "userID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userID;

    @NotNull(message = "userID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer jobPostID;
}
