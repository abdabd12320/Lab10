package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.ApiResponse.ApiResponse;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Service.ServiceUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v/user")
@RequiredArgsConstructor
public class ControllerUser {

    private final ServiceUser serviceUser;

    @GetMapping("/get")
    public ResponseEntity getUsers()
    {
        return ResponseEntity.status(200).body(serviceUser.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceUser.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user,Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        if(serviceUser.updateUser(id, user)) {
            return ResponseEntity.status(200).body(new ApiResponse("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Bad request"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        if(serviceUser.deleteUser(id))
        {
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Bad request"));
    }
}
