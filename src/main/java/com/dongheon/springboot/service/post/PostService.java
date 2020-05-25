package com.dongheon.springboot.service.post;

import com.dongheon.springboot.domain.posts.Post;
import com.dongheon.springboot.domain.posts.PostRepository;
import com.dongheon.springboot.web.dto.PostListResponseDto;
import com.dongheon.springboot.web.dto.PostResponseDto;
import com.dongheon.springboot.web.dto.PostSaveRequestsDto;
import com.dongheon.springboot.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestsDto requestsDto) {
        return postRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        return new PostResponseDto(entity);
    }

    @Transactional
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.finAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }
}
