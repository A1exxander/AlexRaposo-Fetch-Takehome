package com.fetch.fetch_takehome.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

class ReceiptTest { // Should prob switch to a parameterized test

        @Test
        void testMAndMCornerMarketReceipt() {

            // Arrange
            List<ReceiptProduct> items = Arrays.asList(
                    new ReceiptProduct("Gatorade", BigDecimal.valueOf(2.25)),
                    new ReceiptProduct("Gatorade", BigDecimal.valueOf(2.25)),
                    new ReceiptProduct("Gatorade", BigDecimal.valueOf(2.25)),
                    new ReceiptProduct("Gatorade", BigDecimal.valueOf(2.25))
            );

            Receipt receipt = new Receipt(
                    "M&M Corner Market",
                    LocalDate.of(2022, 3, 20),
                    LocalTime.of(14, 33),
                    items,
                    new BigDecimal(9.00)
            );

            // Act
            int calculatedPoints = receipt.getPoints();
            final int EXPECTED_POINTS = 109;

            // Assert
            assertEquals(EXPECTED_POINTS, calculatedPoints);

        }

    @Test
    void testTargetReceipt() {

        // Arrange
        List<ReceiptProduct> items = Arrays.asList(
                new ReceiptProduct("Mountain Dew 12PK", BigDecimal.valueOf(6.49)),
                new ReceiptProduct("Emils Cheese Pizza", BigDecimal.valueOf(12.25)),
                new ReceiptProduct("Knorr Creamy Chicken",  BigDecimal.valueOf(1.26)),
                new ReceiptProduct("Doritos Nacho Cheese", BigDecimal.valueOf(3.35)),
                new ReceiptProduct("   Klarbrunn 12-PK 12 FL OZ  ",  BigDecimal.valueOf(12.00))
        );

        Receipt receipt = new Receipt(
                "Target",
                LocalDate.of(2022, 1, 1),
                LocalTime.of(13, 01),
                items,
                new BigDecimal(35.35)
        );

        // Act
        int calculatedPoints = receipt.getPoints();
        final int EXPECTED_POINTS = 28;

        // Assert
        assertEquals(EXPECTED_POINTS, calculatedPoints);

    }

}
