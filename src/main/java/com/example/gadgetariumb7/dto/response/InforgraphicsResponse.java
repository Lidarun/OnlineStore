package com.example.gadgetariumb7.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class InforgraphicsResponse {
    private Long soldPrice;
    private int soldCount;
    private Long orderPrice;
    private int orderCount;
    private Long currentPeriodPerDay;
    private Long previousPeriodPerDay;
    private Long currentPeriodPerMonth;
    private Long previousPeriodPerMonth;
    private Long currentPeriodPerYear;
    private Long previousPeriodPerYear;
}
