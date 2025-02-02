package com.fetch.fetch_takehome.service;

import com.fetch.fetch_takehome.dto.ReceiptDTO;
import com.fetch.fetch_takehome.dto.ReceiptIDDTO;
import com.fetch.fetch_takehome.dto.ReceiptPointsDTO;

public interface iReceiptService {
    public ReceiptPointsDTO getReceiptPoints(Integer ID);
    public ReceiptIDDTO saveReceipt(ReceiptDTO receiptDTO);
}
