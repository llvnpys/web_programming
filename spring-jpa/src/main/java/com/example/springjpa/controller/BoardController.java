package com.example.springjpa.controller;

import com.example.springjpa.dto.PageRequestDTO;
import com.example.springjpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

    }
}
