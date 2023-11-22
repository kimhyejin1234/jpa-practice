package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Setter @Getter @ToString
public class PageResponseDTO {
    private  int startPage;
    private  int endPage;
    private  int currentPage;

    private boolean prev;
    private boolean next;

    private int totalCount;

    //힌 페이지에 배치할 페이지 버튼 수(1~10 // 11~20)
    private  static  final  int PAGE_COUNT = 10;

    public PageResponseDTO(Page<Post> pageData) {
        //기존에 사용했던 PageCreator 랑 다를게 없어요~
        //매개값으로 전달된 Page객체가 많은 정보를 제공하기 때문에 로직이 좀 더 간편해진 것 뿐입니다.
        this.totalCount = (int) pageData.getTotalElements();
        this.currentPage = pageData.getPageable().getPageNumber() + 1;
        this.endPage
                = (int) (Math.ceil((double) currentPage / PAGE_COUNT) * PAGE_COUNT);
        this.startPage = endPage - PAGE_COUNT + 1;

        int realEnd = pageData.getTotalPages();

        if(realEnd < this.endPage) this.endPage = realEnd;

        this.prev = startPage > 1;
        this.next = endPage < realEnd;

    }
}
