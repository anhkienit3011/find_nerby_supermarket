package com.FindSuperMarket.demo.sys.repository;

import com.FindSuperMarket.demo.sys.domain.entity.OperatingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatingHoursRepository extends JpaRepository<OperatingHours, Long> {

    List<OperatingHours> findBySupermarketId(Long supermarketId);
    List<OperatingHours> findBySupermarketIdAndDayOfWeek(Long supermarketId, Integer dayOfWeek);
}
