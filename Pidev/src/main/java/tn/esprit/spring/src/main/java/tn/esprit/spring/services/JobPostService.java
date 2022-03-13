package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Job_Post;
import tn.esprit.spring.repository.JobPostRepository;

import java.util.List;

@Service
public class JobPostService {

    @Autowired
    JobPostRepository jobPostRepository;


    public List<Job_Post> findAllPosts() {
        return jobPostRepository.findAll();
    }


    public List<Job_Post> findPostsWithSorting(String field){
        return  jobPostRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Job_Post> findPostsWithPagination(int offset, int pageSize){
        Page<Job_Post> job_posts = jobPostRepository.findAll(PageRequest.of(offset, pageSize));
        return  job_posts;
    }

    public Page<Job_Post> findPostsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Job_Post> job_posts = jobPostRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  job_posts;
    }

}

