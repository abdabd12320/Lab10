package com.example.jobseekingsystem.Repository;

import com.example.jobseekingsystem.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJobPost extends JpaRepository<JobPost,Integer> {
}
