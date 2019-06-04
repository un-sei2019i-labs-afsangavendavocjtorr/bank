package com.breachend.bank_app.BusinessLogic.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.breachend.bank_app.DataAccess.Models.AccountDataModel;
import com.breachend.bank_app.DataAccess.Models.TransactionModel;
import com.breachend.bank_app.DataAccess.Models.UserModel;
import com.breachend.bank_app.DataAccess.Repositories.AccountDataRepository;
import com.breachend.bank_app.DataAccess.Repositories.PasswordRepository;
import com.breachend.bank_app.DataAccess.Repositories.TransactionRepository;
import com.breachend.bank_app.DataAccess.Repositories.UserRepository;

public class TransactionController {
    private Context context;
    private UserRepository userRepository;
    private TransactionRepository transactionRepository;
    private AccountDataRepository accountDataRepository;

    public TransactionController(Context context){
        this.context = context;
        this.userRepository = new UserRepository(context);
        this.transactionRepository = new TransactionRepository(context);
        this.accountDataRepository = new AccountDataRepository(context);
    }

    public AccountDataModel makeTransaction(String senderEmail, String receiverEmail, double amount){
        UserModel sender = this.userRepository.getByEmail(senderEmail);

        if (!isValidAmount(amount, sender)) return null;

        UserModel receiver = this.userRepository.getByEmail(receiverEmail);

        AccountDataModel accountSender = accountDataRepository.getByIdUser(sender.getId());
        AccountDataModel accountReceiver = accountDataRepository.getByIdUser(receiver.getId());

        accountSender.setBalance(accountSender.getBalance() - amount);
        accountReceiver.setBalance(accountReceiver.getBalance() + amount);

        this.accountDataRepository.UpdateAccount(accountReceiver);
        this.accountDataRepository.UpdateAccount(accountSender);
        this.transactionRepository.create(new TransactionModel(1, receiver.getId(), sender.getId(), 0, "Hoy", "Ok", amount));

        return accountSender;
    }

    public AccountDataModel getAccountBalance(String email){
        UserModel user = this.userRepository.getByEmail(email);
        AccountDataModel account = accountDataRepository.getByIdUser(user.getId());
        return account;
    }

    private boolean isValidAmount(double amount, UserModel user ){
        AccountDataModel account = accountDataRepository.getByIdUser(user.getId());
        // Toast.makeText (context, account.getBalance() + "  " + amount, Toast.LENGTH_SHORT).show();
        return !(account.getBalance() - amount < 0);
    }


}
