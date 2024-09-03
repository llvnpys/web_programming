package com.example.springjpa.repository.search;

import com.example.springjpa.domain.Board;
import com.example.springjpa.domain.QBoard;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {


    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board;

        JPQLQuery<Board> query = from(board);

        query.where(board.title.contains("1"));

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }
}
