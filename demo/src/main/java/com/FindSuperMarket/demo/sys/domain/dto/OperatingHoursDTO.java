package com.FindSuperMarket.demo.sys.domain.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class OperatingHoursDTO {
    private Integer dayOfWeek;
    private LocalTime openTime;
    private LocalTime closeTime;
}
