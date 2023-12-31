package com.study.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"employees"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long id;

    @Column(name = "dept_name",nullable = false)
    private  String name;

    //양항향 매핑에서는 상대방 엔터디의 갱신에 관여할 수 없다.
    //단순히 읽기 전용(조회) 만으로 사용해야 한다.
    //mappedBy 에는 상대방 엔터티의 조인되는 필드미ㅕㅇ을 작성
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();//초기화가 필요합니다.(npe방지)

}
