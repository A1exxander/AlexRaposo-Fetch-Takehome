package com.fetch.fetch_takehome.controller;

import com.fetch.fetch_takehome.dto.ReceiptDTO;
import com.fetch.fetch_takehome.dto.ReceiptIDDTO;
import com.fetch.fetch_takehome.dto.ReceiptPointsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface iReceiptController {
    public ResponseEntity<ReceiptPointsDTO> getReceiptPoints(@PathVariable Integer ID);
    public ResponseEntity<ReceiptIDDTO> saveReceipt(@RequestBody ReceiptDTO receiptDTO);
}
