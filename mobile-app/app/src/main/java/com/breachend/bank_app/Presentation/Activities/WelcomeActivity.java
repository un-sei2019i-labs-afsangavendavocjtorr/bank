package com.breachend.bank_app.Presentation.Activities;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.breachend.bank_app.BusinessLogic.Controllers.TransactionController;
import com.breachend.bank_app.BusinessLogic.Controllers.UserController;
import com.breachend.bank_app.DataAccess.Models.AccountDataModel;
import com.breachend.bank_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private TextView emailTextView;
    private TextView balanceTextView;
    private UserController userController;
    private TransactionController transactionController;
    private Spinner dropdown;
    private Button sendMoneyButton;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.userController = new UserController(this);
        this.transactionController = new TransactionController(this);
        this.context = this;

        Intent myIntent = getIntent();
        final String email = myIntent.getStringExtra("email");

        emailTextView = (TextView) findViewById(R.id.text_email);
        emailTextView.setText("Welcome "+email);

        balanceTextView = (TextView)  findViewById(R.id.text_balance);
        balanceTextView.setText("Your current Balance is " + transactionController.getAccountBalance(email).getBalance());

        this.dropdown = findViewById(R.id.receiverEmailsSpinner);
        String[] emailList = userController.getAllEmails();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                removeEmail(emailList, email));
        dropdown.setAdapter(adapter);

        this.sendMoneyButton = (Button) findViewById(R.id.send_money_button);
        this.sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText amountEditText = (EditText) findViewById(R.id.amount_editText);
                double amount =Double.parseDouble(amountEditText.getText().toString());

                String receiverEmail = dropdown.getSelectedItem().toString();

                AccountDataModel result = transactionController.makeTransaction(email, receiverEmail, amount);
                if (result == null){
                    Toast.makeText (context, "Saldo insuficiente", Toast.LENGTH_SHORT).show();
                    return;
                }

                balanceTextView.setText("Your current Balance is " + result.getBalance());
            }
        });

    }

    private String[] removeEmail(String[] emailList, String email){
        List<String> list = new ArrayList<String>(Arrays.asList(emailList));
        list.remove(email);
        return list.toArray(new String[0]);
    }

    public void signOut(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
