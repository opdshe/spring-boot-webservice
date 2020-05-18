package com.dongheon.springboot.service.post;

import com.dongheon.springboot.domain.posts.PostRepository;
import com.dongheon.springboot.web.dto.PostSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestsDto requestsDto) {
        return postRepository.save(requestsDto.toEntity()).getId();
    }
}
