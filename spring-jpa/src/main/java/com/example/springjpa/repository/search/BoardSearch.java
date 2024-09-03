package com.example.springjpa.repository.search;

import com.example.springjpa.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    Page<Board> search1(Pageable pageable);

    // types : 제목(t), 내용(c), 작성자(w) 로 구성
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}
