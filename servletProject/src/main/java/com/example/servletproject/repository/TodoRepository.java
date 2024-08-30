package com.example.servletproject.repository;

import com.example.servletproject.dto.TodoDTO;
import com.example.servletproject.vo.TodoVO;

import java.util.List;

public interface TodoRepository {
    void save(TodoDTO todoDTO);

    List<TodoVO> findAll();
}
