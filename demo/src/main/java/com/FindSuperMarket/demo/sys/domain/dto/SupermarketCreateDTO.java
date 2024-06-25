package com.FindSuperMarket.demo.sys.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SupermarketCreateDTO {
    private String name;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Long> categoryIds;
    private List<OperatingHoursDTO> operatingHours;
}
