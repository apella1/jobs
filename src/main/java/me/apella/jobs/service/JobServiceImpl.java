package me.apella.jobs.service;

import me.apella.jobs.model.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {
    private Long nextId = 1L;
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (Objects.equals(job.getId(), id)) return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for (Job job : jobs)
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                return true;
            }
        return false;
    }
}
