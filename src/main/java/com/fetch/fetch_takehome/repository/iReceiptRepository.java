package com.fetch.fetch_takehome.repository;

import com.fetch.fetch_takehome.model.Receipt;

public interface iReceiptRepository {
    public Receipt get(Integer ID);
    public Integer save(Receipt receipt);
}
