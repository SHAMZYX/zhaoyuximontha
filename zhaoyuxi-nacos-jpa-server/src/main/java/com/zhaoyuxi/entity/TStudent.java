package com.zhaoyuxi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "t_student")
public class TStudent {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String stuNo;

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "stuId", updatable = false)
  private List<THouse> tHouses;


}
