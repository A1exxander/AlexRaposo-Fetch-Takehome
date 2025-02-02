package com.fetch.fetch_takehome.service;

import com.fetch.fetch_takehome.dto.ReceiptDTO;
import com.fetch.fetch_takehome.model.Receipt;
import com.fetch.fetch_takehome.dto.ReceiptIDDTO;
import com.fetch.fetch_takehome.dto.ReceiptPointsDTO;
import com.fetch.fetch_takehome.mapper.iReceiptMapper;
import com.fetch.fetch_takehome.repository.iReceiptRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ReceiptService implements iReceiptService {

    @Autowired
    private iReceiptMapper receiptMapper;

    @Autowired
    private iReceiptRepository receiptRepository;

    @Override
    public ReceiptPointsDTO getReceiptPoints(Integer ID) {
        Receipt receipt = receiptRepository.get(ID);
        return receiptMapper.toReceiptPointsDTO(receipt.getPoints());
    }

    @Override
    public ReceiptIDDTO saveReceipt(ReceiptDTO receiptDTO) {
        Receipt receipt = receiptMapper.toReceipt(receiptDTO);
        Integer receiptID = receiptRepository.save(receipt);
        return receiptMapper.toReceiptIDDTO(receipt.getID());
    }

}
