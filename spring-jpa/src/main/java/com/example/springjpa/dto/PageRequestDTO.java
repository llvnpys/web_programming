package com.example.springjpa.dto;

// 페이징 관련 정보(page/ size), 검색 종류, 키워드 지정

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    private String type;
    private String keyword;
    private String link;


    // String -> String[] 로 바꾸는 기능 필요
    public String[] getTypes() {
        if(type == null || type.isEmpty()) {
            return null;
        }

        return type.split("");
    }

    public Pageable getPageable(String... props) {

        // Null 들어가면 안 되는데, 처리 뒤에서 할 듯?
        return PageRequest.of(this.page - 1, this.size, Sort.by(props).descending());
    }

    // 쿼리 파라미터 생성
    public String getLink() {

        if (link == null) {
            StringBuilder builder = new StringBuilder();

            builder.append("page= " + this.page);
            builder.append("&size= " + this.size);

            if(type != null && type.length() > 0){
                builder.append("&type= " + type);
            }

            if (keyword != null) {
                try {
                    builder.append("&keyword= " + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }

            link = builder().toString();
        }

        return link;
    }
}
