package com.breachend.bank_app.Presentation.Activities;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.breachend.bank_app.BusinessLogic.Controllers.UserController;
import com.breachend.bank_app.R;

public class WelcomeActivity extends AppCompatActivity {
    private TextView emailTextView;
    private ListView listOfUsers;
    private UserController userController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.userController = new UserController(this);

        Intent myIntent = getIntent();
        String email = myIntent.getStringExtra("email");

        emailTextView = (TextView) findViewById(R.id.text_email);
        emailTextView.setText("Welcome "+email);

        listOfUsers = (ListView) findViewById(R.id.user_list);

        String[] emailList = userController.getAllEmails();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                emailList);
        listOfUsers.setAdapter(adapter);


    }

    public void signOut(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
