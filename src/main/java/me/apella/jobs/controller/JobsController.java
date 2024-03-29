package me.apella.jobs.controller;

import me.apella.jobs.model.Job;
import me.apella.jobs.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    private JobService jobService;

    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobService.findAll();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);

        if (deleted) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with id " + id + " not found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJobById(id, updatedJob);
        if (updated) {
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with id " + id + " not found!", HttpStatus.NOT_FOUND);
    }
}
