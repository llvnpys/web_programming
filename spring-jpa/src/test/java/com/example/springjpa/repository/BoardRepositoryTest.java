package com.example.springjpa.repository;

import com.example.springjpa.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Board> pageResult = boardRepository.findAll(pageable);

        log.info(String.valueOf(pageResult.getTotalElements()));
        log.info(String.valueOf(pageResult.getTotalPages()));
        log.info(String.valueOf(pageResult.getNumber()));
        log.info(String.valueOf(pageResult.getSize()));

        List<Board> content = pageResult.getContent();



        content.stream()
                .forEach(i -> log.info(i.toString()));

        Pageable pageable1 = pageResult.nextPageable();

        Page<Board> page2 = boardRepository.findAll(pageable1);

        List<Board> list2 = page2.getContent();

        list2.forEach(i -> log.info(i.toString()));


    }

    @Test
    public void testSearch1() {
        Pageable page = PageRequest.of(1, 10, Sort.by("bno").descending());

        boardRepository.search1(page);
    }

    @Test
    public void testSearchALl() {
        Pageable page = PageRequest.of(0, 10, Sort.by("bno").descending());

        String[] types = {"t", "c", "w"};

        String keyword = "1";


        Page<Board> list = boardRepository.searchAll(types, keyword, page);

        log.info(String.valueOf(list.getTotalPages()));
        log.info(String.valueOf(list.getTotalElements()));
        log.info(String.valueOf(list.getNumber()));
        log.info(String.valueOf(list.getSize()));

        // 이전 페이지, 다음 페이지

        log.info(list.hasPrevious() + " : " + list.hasNext());

        list.getContent().forEach(board -> log.info(String.valueOf(board)));




    }



}