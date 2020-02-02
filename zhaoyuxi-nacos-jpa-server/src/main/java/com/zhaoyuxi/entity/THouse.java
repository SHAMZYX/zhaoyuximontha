package com.zhaoyuxi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_house")
public class THouse {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String courseName;
  private Integer fraction;
  private Integer stuId;




}
