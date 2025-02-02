package com.fetch.fetch_takehome.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ReceiptDTO {

    final private String retailer;
    final private LocalDate purchaseDate;
    final private LocalTime purchaseTime;
    final private List<ReceiptProductDTO> items;
    final private Double total;

}
