package com.study.jpa.chap05_practice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString(exclude = {"hashTags"})
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "tbl_post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private  Long id;//글번호


    @Column(nullable = false)
    private String writer;//작성자

    @Column(nullable = false)
    private  String title;//제목

    private  String content;//내용

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDate;//작성시간

    @UpdateTimestamp
    private  LocalDateTime updateDate;//수정시간

    @OneToMany(mappedBy = "post")
    private List<HashTag> hashTags = new ArrayList<>();

}
