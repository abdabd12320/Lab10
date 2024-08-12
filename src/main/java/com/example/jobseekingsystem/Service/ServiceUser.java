package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUser {

    private final RepositoryUser repositoryUser;

    public List<User> getUsers()
    {
        return repositoryUser.findAll();
    }

    public void addUser(User user)
    {
        repositoryUser.save(user);
    }

    public boolean updateUser(Integer id,User user)
    {
        User u = repositoryUser.getReferenceById(id);

        if(u == null){
            return false;}

        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        repositoryUser.save(u);
        return true;
    }

    public boolean deleteUser(Integer id)
    {
        if(repositoryUser.existsById(id))
        {
            repositoryUser.deleteById(id);
            return true;
        }
        return false;
    }
}
