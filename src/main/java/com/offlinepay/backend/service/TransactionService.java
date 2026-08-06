package com.offlinepay.backend.service;

import com.offlinepay.backend.dto.TransferRequest;
import com.offlinepay.backend.dto.TransferResponse;
import com.offlinepay.backend.model.Transaction;
import com.offlinepay.backend.model.User;
import com.offlinepay.backend.model.Wallet;
import com.offlinepay.backend.repository.TransactionRepository;
import com.offlinepay.backend.repository.UserRepository;
import com.offlinepay.backend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository  transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

     @Transactional
    public TransferResponse transferMoney(TransferRequest req) {

         // find sender
         User sender = userRepository.findById(req.getSenderId())
                 .orElseThrow(() -> new RuntimeException("Sender not found"));

         // find Receiver

         User receiver = userRepository.findById(req.getReceiverId())
                 .orElseThrow(() -> new RuntimeException("Receiver not found"));

         // find sender  wallet
         Wallet senderWallet = walletRepository.findByUser(sender)
                 .orElseThrow(() -> new RuntimeException("Sender wallet not found"));


         //  find Receiver wallet
         Wallet receiverWallet = walletRepository.findByUser(receiver)
                 .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

         // check balance
         if (senderWallet.getBalance() < req.getAmount()) {
             throw new RuntimeException("Insufficient balance");

         }
         // deduct sender balance
         senderWallet.setBalance(senderWallet.getBalance() - req.getAmount());

         // add receiver balance
         receiverWallet.setBalance(receiverWallet.getBalance() + req.getAmount());

         //  saved wallets
         walletRepository.save(senderWallet);
         walletRepository.save(receiverWallet);

         // create Transaction
         Transaction transaction = new Transaction();
         transaction.setSender(sender);
         transaction.setReceiver(receiver);
         transaction.setAmount(req.getAmount());
         transaction.setStatus("SUCCESS");


         // saved Transaction
         Transaction saved = transactionRepository.save(transaction);
         //return response
         return new TransferResponse(
                 saved.getId(),
                 sender.getId(),
                 receiver.getId(),
                 saved.getAmount(),
                 saved.getStatus(),
                 saved.getCreatedAt()
         );
     }
   public List<TransferResponse> getHistory (Long userId){

         User  user = userRepository.findById(userId)
                 .orElseThrow(()-> new RuntimeException("User noy found"));

         List<Transaction> transactions = transactionRepository.findBySenderOrReceiver(user,user);

          return transactions.stream()
                  .map(t-> new TransferResponse(
                          t.getId(),
                          t.getSender().getId(),
                          t.getReceiver().getId(),
                          t.getAmount(),
                          t.getStatus(),
                          t.getCreatedAt()
                  ))
                  .toList();



    }
}
