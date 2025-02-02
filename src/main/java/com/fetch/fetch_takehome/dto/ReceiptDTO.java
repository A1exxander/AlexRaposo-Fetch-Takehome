package com.fetch.fetch_takehome.dto;

import lombok.Data;
import java.util.List;

@Data
public class ReceiptDTO { // BTW, these fields are all strings because it seems like in the JSON payload in the example, you use strings

    final private String retailer;
    final private String purchaseDate;
    final private String purchaseTime;
    final private List<ReceiptProductDTO> items;
    final private String total;

}
