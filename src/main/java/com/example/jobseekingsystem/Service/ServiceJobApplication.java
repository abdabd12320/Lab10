package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Repository.RepositoryJobApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceJobApplication {

    private final RepositoryJobApplication repositoryJobApplication;

    public List<JobApplication> getJobApplications()
    {
        return repositoryJobApplication.findAll();
    }

    public void addJobApplication(JobApplication jobApplication)
    {
        repositoryJobApplication.save(jobApplication);
    }

    public boolean updateJobApplication(Integer id, JobApplication jobApplication)
    {
        JobApplication j = repositoryJobApplication.getReferenceById(id);
        if(j == null)
        {
            return false;
        }
        j.setUserID(jobApplication.getUserID());
        j.setJobPostID(jobApplication.getJobPostID());
        repositoryJobApplication.save(j);
        return true;
    }

    public boolean deleteJobApplication(Integer id)
    {
        if(repositoryJobApplication.existsById(id))
        {
            repositoryJobApplication.deleteById(id);
            return true;
        }
        return false;
    }
}
