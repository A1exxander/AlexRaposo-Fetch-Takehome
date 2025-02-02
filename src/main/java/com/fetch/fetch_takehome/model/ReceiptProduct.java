package com.fetch.fetch_takehome.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ReceiptProduct {
    final private String shortDescription;
    final private BigDecimal price;
}
