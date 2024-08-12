package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.ApiResponse.ApiResponse;
import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Service.ServiceJobApplication;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v/job-application")
@RequiredArgsConstructor
public class ControllerJobApplication {

    private final ServiceJobApplication serviceJobApplication;

    @GetMapping("/get")
    public ResponseEntity getJobApplications()
    {
        return ResponseEntity.status(200).body(serviceJobApplication.getJobApplications());
    }
    @PostMapping("/add")
    public ResponseEntity addJobApplication(@Valid@RequestBody JobApplication jobApplication, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceJobApplication.addJobApplication(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("Job application added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJobApplication(@PathVariable Integer id,@Valid@RequestBody JobApplication jobApplication, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(serviceJobApplication.updateJobApplication(id, jobApplication))
        {
            return ResponseEntity.status(200).body(new ApiResponse("Job application updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Bad request"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id)
    {
        if(serviceJobApplication.deleteJobApplication(id))
        {
            return ResponseEntity.status(200).body(new ApiResponse("Job application deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Bad request"));
    }

}
