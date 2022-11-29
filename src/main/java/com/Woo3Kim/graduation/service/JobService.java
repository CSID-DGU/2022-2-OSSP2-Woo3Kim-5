package com.Woo3Kim.graduation.service;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private Job job;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //DB에 직무 저장
    public void saveJob(String jobName) {
        job.setJobName(jobName);

        jobRepository.save(job);
    }

    //모든 희망 직무 불러오기
    public List<Job> getAllJob() {
        return jobRepository.getAllJob();
    }
}
