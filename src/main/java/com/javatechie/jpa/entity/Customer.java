package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String gender;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID" ,referencedColumnName = "id")  // id l customer ds reference
    private List<Product> products;

}
