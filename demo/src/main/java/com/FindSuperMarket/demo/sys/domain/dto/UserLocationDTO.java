package com.FindSuperMarket.demo.sys.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserLocationDTO {
    private Long userId;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
