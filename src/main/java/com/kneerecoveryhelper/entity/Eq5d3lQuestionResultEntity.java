package com.kneerecoveryhelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "eq5d3l_question_result")
@Getter
@Setter
@Accessors(chain = true)
public class Eq5d3lQuestionResultEntity  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column()
  private Integer points;

  @Column(name = "question_number")
  private Integer questionNumber;

  @ManyToOne
  @JoinColumn(name = "eq5d3l_id", nullable = false)
  private Eq5d3lResultEntity eq5d3lResult;

}
