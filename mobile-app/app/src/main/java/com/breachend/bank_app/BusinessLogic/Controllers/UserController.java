package com.breachend.bank_app.BusinessLogic.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.breachend.bank_app.DataAccess.Repository.UserRepository;
import com.breachend.bank_app.DataAccess.Model.User.UserModel;

public class UserController {
    private Context context;
    private UserRepository userRepository;

    public UserController(Context context){
        this.context = context;
        this.userRepository = new UserRepository(context);
    }

    public void register(String name, String email, String password){
        if(validateName(name) && validateEmail(email) && validatePassword(password)){
            this.userRepository.create(new UserModel(name, email, password));
        }
    }

    public UserModel Login(String email, String password){
        if(validateEmail(email) && validatePassword(password)){
            UserModel user = this.userRepository.getByEmail(email);
            if(user != null){
                Toast.makeText(context, "Incorrect email", Toast.LENGTH_SHORT).show();
                return null;
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

    private boolean validateName(String name){
        if(name.length() > 2)
            return true;
        Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show();
        return false;
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
