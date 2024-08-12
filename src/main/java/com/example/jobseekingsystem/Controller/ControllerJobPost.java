package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.ApiResponse.ApiResponse;
import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Service.ServiceJobPost;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v/job-post")
@RequiredArgsConstructor
public class ControllerJobPost {

    private final ServiceJobPost serviceJobPost;

    @GetMapping("/get")
    public ResponseEntity getJobPost()
    {
        return ResponseEntity.status(200).body(serviceJobPost.getJobPosts());
    }
    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid@RequestBody JobPost jobPost, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceJobPost.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job post added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id,@Valid@RequestBody JobPost jobPost,Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(serviceJobPost.updateJobPost(id, jobPost))
        {
            return ResponseEntity.status(200).body(new ApiResponse("Job post updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Bad request"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id)
    {
        if(serviceJobPost.deleteJobPost(id))
        {
            return ResponseEntity.status(200).body(new ApiResponse("Job post deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Bad request"));
    }
}
