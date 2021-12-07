package com.example.web3.models;

import lombok.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Named
@RequestScoped
@Entity
@Table(name = "points", indexes = {@Index(name = "id", columnList = "id")})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Point implements Serializable {
    @Id
    @SequenceGenerator(name="id",sequenceName="ID", allocationSize=1)
    private int id;
    @Column(name = "x")
    @Min(-5)
    @Max(5)
    private float x = 0.1f;
    @Column(name = "y")
    @Min(-3)
    @Max(5)
    private Double y;
    @Column(name = "r")
    @Min(1)
    @Max(5)
    private Double r;
    @Column(name = "result")
    private boolean hit;
    @Column(name = "cur_time")
    private String time;

}
