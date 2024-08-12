package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Repository.RepositoryJobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceJobPost {

    private final RepositoryJobPost repositoryJobPost;

    public List<JobPost> getJobPosts()
    {
        return repositoryJobPost.findAll();
    }

    public void addJobPost(JobPost jobPost)
    {
        repositoryJobPost.save(jobPost);
    }

    public boolean updateJobPost(Integer id,JobPost jobPost)
    {
        JobPost j = repositoryJobPost.getReferenceById(id);
        if(j == null)
        {
            return false;
        }
        j.setTitle(jobPost.getTitle());
        j.setDescription(jobPost.getDescription());
        j.setLocation(jobPost.getLocation());
        j.setSalary(jobPost.getSalary());
        j.setPostingDate(jobPost.getPostingDate());
        repositoryJobPost.save(j);
        return true;
    }

    public boolean deleteJobPost(Integer id)
    {
        if(repositoryJobPost.existsById(id))
        {
            repositoryJobPost.deleteById(id);
            return true;
        }
        return false;
    }
}
