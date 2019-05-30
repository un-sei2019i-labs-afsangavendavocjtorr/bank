package com.breachend.bank_app.BusinessLogic.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.breachend.bank_app.DataAccess.Repository.UserRepository;
import com.breachend.bank_app.DataAccess.Models.UserModel;

import java.util.ArrayList;

public class UserController {
    private Context context;
    private UserRepository userRepository;

    public UserController(Context context){
        this.context = context;
        this.userRepository = new UserRepository(context);
    }

    public UserModel register(String email, String password){
        if(validateEmail(email) && validatePassword(password)){
            return this.userRepository.create(new UserModel(email, password));
        }else{
            return null;
        }
    }

    public UserModel loginOrRegister(String email, String password){
        if(validateEmail(email) && validatePassword(password)){
            UserModel user = this.userRepository.getByEmail(email);
            if(user == null){
                return register(email, password);
            }
            if (!user.getPassword().equals(password)){
                Toast.makeText(context, "Incorrect password", Toast.LENGTH_SHORT).show();
                return null;
            }
            return user;
        }else{
            return null;
        }
    }

    public String[] getAllEmails(){
        ArrayList<UserModel> users = this.userRepository.getAll();
        String[] emailList = new String[users.size()];
        for(int i = 0; i < users.size(); i++){
            emailList[i] = users.get(i).getEmail();
        }
        return emailList;
    }

    private boolean validateEmail(String email){
        if(email.contains("@") && email.length() > 3)
            return true;
        Toast.makeText(context, "Please enter a correct email", Toast.LENGTH_SHORT).show();
        return false;
    }

    private boolean validatePassword(String password){
        if(password.length() > 4)
            return true;
        Toast.makeText(context, "Please enter a long password", Toast.LENGTH_SHORT).show();
        return false;
    }
}
