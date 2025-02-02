package com.fetch.fetch_takehome.controller;

import com.fetch.fetch_takehome.dto.ReceiptDTO;
import com.fetch.fetch_takehome.dto.ReceiptIDDTO;
import com.fetch.fetch_takehome.dto.ReceiptPointsDTO;
import com.fetch.fetch_takehome.service.iReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiptController implements iReceiptController{

    @Autowired
    iReceiptService receiptService;

    @Override
    @GetMapping("receipts/{ID}/points")
    public ResponseEntity<ReceiptPointsDTO> getReceiptPoints(@PathVariable Integer ID){

        ReceiptPointsDTO receiptPointsDTO = receiptService.getReceiptPoints(ID);
        if (receiptPointsDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(receiptPointsDTO);

    }

    @Override
    @PostMapping("receipts/process")
    public ResponseEntity<ReceiptIDDTO> saveReceipt(@RequestBody ReceiptDTO receiptDTO) {
        ReceiptIDDTO receiptIDDTO = receiptService.saveReceipt(receiptDTO);
        return ResponseEntity.ok(receiptIDDTO);
    }

}
