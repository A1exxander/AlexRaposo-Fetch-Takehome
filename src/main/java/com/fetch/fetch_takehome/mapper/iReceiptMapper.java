package com.fetch.fetch_takehome.mapper;

import com.fetch.fetch_takehome.dto.ReceiptDTO;
import com.fetch.fetch_takehome.dto.ReceiptIDDTO;
import com.fetch.fetch_takehome.dto.ReceiptPointsDTO;
import com.fetch.fetch_takehome.model.Receipt;

public interface iReceiptMapper {
    public ReceiptIDDTO toReceiptIDDTO(Integer ID);
    public ReceiptPointsDTO toReceiptPointsDTO(Integer points);
    public Receipt toReceipt(ReceiptDTO receiptDTOO);
}
