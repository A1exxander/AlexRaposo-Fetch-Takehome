package com.fetch.fetch_takehome.mapper;

import com.fetch.fetch_takehome.dto.ReceiptDTO;
import com.fetch.fetch_takehome.dto.ReceiptIDDTO;
import com.fetch.fetch_takehome.dto.ReceiptPointsDTO;
import com.fetch.fetch_takehome.model.Receipt;
import com.fetch.fetch_takehome.model.ReceiptProduct;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceiptMapper implements iReceiptMapper {

    @Override
    public Receipt toReceipt(ReceiptDTO receiptDTO) {

        List<ReceiptProduct> items = receiptDTO.getItems().stream()
                .map(dto -> new ReceiptProduct(
                        dto.getShortDescription(),
                        new BigDecimal(dto.getPrice())
                ))
                .collect(Collectors.toList());

        return new Receipt(
                receiptDTO.getRetailer(),
                LocalDate.parse(receiptDTO.getPurchaseDate()),
                LocalTime.parse(receiptDTO.getPurchaseTime()),
                items,
                new BigDecimal(receiptDTO.getTotal())
        );

    }

    @Override
    public ReceiptIDDTO toReceiptIDDTO(Integer ID) {
        return new ReceiptIDDTO(ID);
    }

    @Override
    public ReceiptPointsDTO toReceiptPointsDTO(Integer points) {
        return new ReceiptPointsDTO(points);
    }

}
