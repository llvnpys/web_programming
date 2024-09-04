package com.example.springjpa.dto;

// 화면에 DTO 목록과 시작, 끝 페이지 등에 대한 처리

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    // 페이지 시작, 끝 번호
    private int start;
    private int end;

    // 이전 페이지 존재 여부
    private boolean prev;
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        // 페이지가 없을 때
        if (total <= 0) {
            return;
        }

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        // 한 번에 10개의 페이지까지 나타내므로 1 ~ 10
        this.end = (int) ((Math.ceil(this.page / 10.0)) * 10);
        this.start = this.end - 9;

        int last = (int) (Math.ceil(total / (double)size));

        // 표현하고자 하는 페이지의 끝이 전체 페이지의 끝보다 넘어가면 안 됨
        this.end = end > last ? last : end;

        this.prev = this.start > 1;

        // 여기 봐야함
        this.next = end != last;
    }
}
