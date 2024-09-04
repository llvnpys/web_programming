package com.example.springjpa.service;

import com.example.springjpa.dto.BoardDTO;
import com.example.springjpa.dto.PageRequestDTO;
import com.example.springjpa.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);


    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
