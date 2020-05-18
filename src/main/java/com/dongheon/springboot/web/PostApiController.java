package com.dongheon.springboot.web;

import com.dongheon.springboot.service.post.PostService;
import com.dongheon.springboot.web.dto.PostSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save (@RequestBody PostSaveRequestsDto requestsDto) {
        return postService.save(requestsDto);
    }
}
