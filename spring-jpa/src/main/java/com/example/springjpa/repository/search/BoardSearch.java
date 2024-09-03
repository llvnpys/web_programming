package com.example.springjpa.repository.search;

import com.example.springjpa.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    Page<Board> search1(Pageable pageable);
}
