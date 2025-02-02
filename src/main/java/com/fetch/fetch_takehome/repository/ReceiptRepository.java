package com.fetch.fetch_takehome.repository;

import com.fetch.fetch_takehome.model.Receipt;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ReceiptRepository implements iReceiptRepository {

    private final Map<Integer, Receipt> receiptMap = new ConcurrentHashMap<>(); // Each HTTP request will spawn a new thread, so lets use a threads safe hashmap

    @Override
    public Receipt get(Integer ID) {
        return receiptMap.get(ID);
    }

    @Override
    public Integer save(Receipt receipt) {
        int receiptID = receiptMap.size() + 1; // If you add delete operations in the future, you will need to have a variable to keep track of the latest ID assigned
        receipt.setID(receiptID);
        receiptMap.put(receiptID, receipt);
        return receiptID;
    }

}
