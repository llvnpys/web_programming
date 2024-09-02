package com.example.springjpa.repository;

import com.example.springjpa.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

//    @Test
//    public void cleanAll() {
//        boardRepository.deleteAll();
//    }

    @Test
    public void testInsert() {
        IntStream.range(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("title " + i)
                    .content("content " + i)
                    .writer("user " + (i % 10))
                    .build();

            Board result = boardRepository.save(board);

            log.info("bno: " + result.getBno());
        });


    }

    @Test
    public void testSelect() {
        Optional<Board> result = boardRepository.findById(99L);

        Board board = result.orElseThrow();

        log.info(board.toString());

    }

    @Test
    public void testUpdate() {
        Optional<Board> result = boardRepository.findById(99L);
        Board board = result.orElseThrow();
        board.change("changed title 99", "changed content 99");

        boardRepository.save(board);
    }

    @Test
    public void testDelete() {
        boardRepository.deleteById(99L);
    }

}