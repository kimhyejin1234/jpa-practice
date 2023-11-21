package com.study.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;
@Getter @Setter @EqualsAndHashCode(of = "id")
//jpa연관관계 매핑에서 연관관계 데이터는  toString 에서 제외해야 합니다.
@ToString(exclude = {"department"})
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private  Long id;

    @Column(name = "emp_name", nullable = false)
    private  String name;

    //EAGER:항상 무조건 조인을 수행
    //LAZY:필요한 경우에만 조인을 수행.(실무에서 주로 사용)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private  Department department;

}
