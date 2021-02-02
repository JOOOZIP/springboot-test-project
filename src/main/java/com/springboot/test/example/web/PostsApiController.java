package com.springboot.test.example.web;

import com.springboot.test.example.service.PostsService;
import com.springboot.test.example.web.HelloResponseDto.PostsUpdateRequestDto;
import com.springboot.test.example.web.HelloResponseDto.PostsResponseDto;
import com.springboot.test.example.web.HelloResponseDto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findByID(id);
    }

}
