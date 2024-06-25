package com.FindSuperMarket.demo.sys.repository;

import com.FindSuperMarket.demo.sys.domain.entity.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket,Long> {
    List<Supermarket> findByLatitudeBetweenAndLongitudeBetween(
            BigDecimal latMin, BigDecimal latMax, BigDecimal lonMin, BigDecimal lonMax);

}
