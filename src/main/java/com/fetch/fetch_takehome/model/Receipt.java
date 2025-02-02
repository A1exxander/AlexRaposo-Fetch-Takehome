package com.fetch.fetch_takehome.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class Receipt {

    private Integer ID;
    private final String retailer;
    private final LocalDate purchaseDate;
    private final LocalTime purchaseTime;
    private final List<ReceiptProduct> items;
    private final BigDecimal total;

    public int getPoints() { // Prob should break down into separate methods in the future, but OK for now

        Double points = 0.0;

        points += retailer.replaceAll("[^a-zA-Z0-9]", "").length(); // Swap to regex query in the future

        if (total.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            points += 50;
        }

        if (total.remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO) == 0) {
            points += 25;
        }

        points += items.size() / 2 * 5;

        if (purchaseTime.isAfter(LocalTime.of(13, 59)) && purchaseTime.isBefore(LocalTime.of(16, 1))) {
            points += 10;
        }

        for (ReceiptProduct item : items) {
            String trimmedDesc = item.getShortDescription().trim();
            if (trimmedDesc.length() % 3 == 0) {
                points += (int) Math.ceil(item.getPrice().multiply(new BigDecimal("0.2")).doubleValue());
            }
        }

        if (purchaseDate.getDayOfMonth() % 2 != 0) {
            points += 6;
        }

        return points.intValue();

    }

}