package com.springboot.test.example.service;

import com.springboot.test.example.domain.posts.Posts;
import com.springboot.test.example.domain.posts.PostsRepository;
import com.springboot.test.example.web.HelloResponseDto.PostsUpdateRequestDto;
import com.springboot.test.example.web.HelloResponseDto.PostsResponseDto;
import com.springboot.test.example.web.HelloResponseDto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No data. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findByID(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No data. id="+ id));

        return new PostsResponseDto(entity);
    }
}
