package com.offlinepay.backend.controller;


import com.offlinepay.backend.dto.TransferRequest;
import com.offlinepay.backend.dto.TransferResponse;
import com.offlinepay.backend.model.Transaction;
import com.offlinepay.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
     private TransactionService transactionService;

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest request){
         return  transactionService.transferMoney(request);

    }
      @GetMapping("/history/{userId}")
    public List<TransferResponse> getHistory(@PathVariable Long userId){
         return  transactionService.getHistory(userId);
      }
}
