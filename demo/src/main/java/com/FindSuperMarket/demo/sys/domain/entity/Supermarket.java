package com.FindSuperMarket.demo.sys.domain.entity;

import com.FindSuperMarket.demo.sys.domain.root.BaseEntity_;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "supermarkets")
@Data
@EqualsAndHashCode(callSuper = true)
public class Supermarket extends BaseEntity_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private BigDecimal latitude;

    @Column(nullable = false)
    private BigDecimal longitude;

    @ManyToMany
    @JoinTable(
            name = "supermarket_categories",
            joinColumns = @JoinColumn(name = "supermarket_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "supermarket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OperatingHours> operatingHours = new ArrayList<>();
}