package com.example.springjpa.service;

import com.example.springjpa.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("register test title 1")
                .content("r t c 1")
                .writer("test user1")
                .build();

        Long resultBno = boardService.register(boardDTO);

//        Assertions.assertThat(resultBno).isEqualTo(boardDTO.getBno());


    }

    @Test
    public void testReadOne() {

        BoardDTO boardDTO = boardService.readOne(100L);

        Assertions.assertThat(boardDTO.getBno()).isEqualTo(100L);

    }

    @Test
    public void testModify() {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(100L)
                .title("register test title 2")
                .content("r t c 2")
                .writer("test user1")
                .build();

        boardService.modify(boardDTO);

        Assertions.assertThat(boardService.readOne(100L).getContent()).isEqualTo(boardDTO.getContent());

    }

    @Test
    public void testDelete() {
        boardService.remove(100L);

        Assertions.assertThat(boardService.readOne(100L)).isNull();
    }



}