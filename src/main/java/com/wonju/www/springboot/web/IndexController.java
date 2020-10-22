package com.wonju.www.springboot.web;


import com.wonju.www.springboot.domain.posts.Posts;
import com.wonju.www.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){ // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }



    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
