package com.example.springjpa.repository.search;

import com.example.springjpa.domain.Board;
import com.example.springjpa.domain.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {

        // 객체를 기반으로 쿼리 생성.
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        // 검색 조건이 있으면
        if ((types != null && types.length > 0) && keyword != null) {

            // 조건 처리하는 booleanBuilder 생성
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            // 검색 조건 확인 제목인지, 내용인지, 작성자인지
            for (String type : types) {

                switch (type) {
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                    default:
                        break;
                }
            } // end for
            query.where(booleanBuilder);
        } // end if

        // bno는 0보다 커야함.
        query.where(board.bno.gt(0L));

        // 페이징 처리
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();
        long count = query.fetchCount();


        // 결과 반환을 위한 페이지 구현체
        return new PageImpl<>(list, pageable, count);
    }
}
