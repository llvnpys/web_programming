package com.example.servletproject.service;

import com.example.servletproject.dto.TodoDTO;
import com.example.servletproject.repository.TodoMemoryRepository;
import com.example.servletproject.repository.TodoRepository;
import com.example.servletproject.vo.TodoVO;

import java.util.List;
import java.util.stream.Collectors;

public enum TodoService {
    INSTANCE;



    // 등록
    public void register(TodoDTO todoDTO) {

    }


    // 리스트
    public List<TodoDTO> getList() {
        List<TodoVO> list = TodoMemoryRepository.INSTANCE.findAll();

        List<TodoDTO> result = list.stream().
                map(todo -> TodoMemoryRepository.INSTANCE.getModelMapper()
                        .map(todo, TodoDTO.class))
                .collect(Collectors.toList());

        return result;

    }

    // 수정

    // 삭제
}
