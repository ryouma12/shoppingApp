package com.example.task1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trans_ID")
    private Long id;
    @Column(name = "name")
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @OneToMany(mappedBy = "transactions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reports> reportses = new ArrayList<>();

    @OneToMany(mappedBy = "transactions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Logs> logses = new ArrayList<>();

}
