package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Job_Post;
import tn.esprit.spring.services.JobPostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class JobPostController {
    @Autowired
    private JobPostService jobPostService;

    @GetMapping
    private APIResponse<List<Job_Post>> getPosts() {
        List<Job_Post> allPosts = jobPostService.findAllPosts();
        return new APIResponse<>(allPosts.size(), allPosts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Job_Post>> getPostsWithSort(@PathVariable String field) {
        List<Job_Post> jobPostsWithSorting = jobPostService.findPostsWithSorting(field);
        return new APIResponse<>(jobPostsWithSorting.size(), jobPostsWithSorting);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Job_Post>> getPostsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Job_Post> postsWithPagination = jobPostService.findPostsWithPagination(offset, pageSize);
        return new APIResponse<>(postsWithPagination .getSize(), postsWithPagination );
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Job_Post>> getPostsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Job_Post> postsWithPagination = jobPostService.findPostsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(postsWithPagination.getSize(), postsWithPagination);
    }


}
