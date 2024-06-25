package com.FindSuperMarket.demo.sys.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class NearbySearchDTO {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Double radiusInKm;
    private List<Long> categoryIds;
}
