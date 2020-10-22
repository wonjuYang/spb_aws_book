package com.wonju.www.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //SpringDataJpa에서 제공되지 않는 메소드는 이렇ㄱ 작성
    List<Posts> findAllDesc();

}
