package com.FindSuperMarket.demo.sys.domain.entity;

import com.FindSuperMarket.demo.sys.domain.root.BaseEntity_;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Supermarket> supermarkets = new HashSet<>();
}
