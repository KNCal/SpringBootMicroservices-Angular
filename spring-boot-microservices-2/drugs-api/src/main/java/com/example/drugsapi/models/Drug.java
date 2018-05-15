package com.example.drugsapi.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "DRUGS")
public class Drug {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "PRODUCT_CODE")
  private String productcode;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "DISTRIBUTION_PATTERN")
  private String distribution;

  @Column(name = "RECALL_INITIATION_DATE")
  private String recallinitiationdate;

  @Column(name = "RECALLING_FIRM")
  private String recallingfirm;

  @Column(name = "STATUS")
  private String status;

}
