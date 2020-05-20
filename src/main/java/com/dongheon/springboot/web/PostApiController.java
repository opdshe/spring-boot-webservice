package com.dongheon.springboot.web;

import com.dongheon.springboot.service.post.PostService;
import com.dongheon.springboot.web.dto.PostResponseDto;
import com.dongheon.springboot.web.dto.PostSaveRequestsDto;
import com.dongheon.springboot.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestsDto requestsDto) {
        return postService.save(requestsDto);
    }

    @PostMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
