package com.wonju.www.springboot.service.posts;


import com.wonju.www.springboot.domain.posts.Posts;
import com.wonju.www.springboot.domain.posts.PostsRepository;
import com.wonju.www.springboot.web.dto.PostsListResponseDto;
import com.wonju.www.springboot.web.dto.PostsResponseDto;
import com.wonju.www.springboot.web.dto.PostsSaveRequestDto;
import com.wonju.www.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //트랙잭션 범위는 유지하되 조회 기능만 남겨두어 조회 속도 개선
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
     }


}
