package com.example.servletproject.repository;

import com.example.servletproject.dto.TodoDTO;
import com.example.servletproject.vo.TodoVO;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum TodoMemoryRepository implements TodoRepository {
    INSTANCE;

    private static ModelMapper modelMapper = new ModelMapper();

    private static Map<Long, TodoVO> store = new HashMap<>();

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public void save(TodoDTO todoDTO) {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        store.put(todoDTO.getTno(), todoVO);
    }

    @Override
    public List<TodoVO> findAll() {
        return store.values().stream().
                collect(Collectors.toList());
    }


}
