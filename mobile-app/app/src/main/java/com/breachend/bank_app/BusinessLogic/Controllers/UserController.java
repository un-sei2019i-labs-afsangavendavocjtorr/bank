package com.breachend.bank_app.BusinessLogic.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.breachend.bank_app.DataAccess.Models.PasswordModel;
import com.breachend.bank_app.DataAccess.Repositories.PasswordRepository;
import com.breachend.bank_app.DataAccess.Repositories.UserRepository;
import com.breachend.bank_app.DataAccess.Models.UserModel;

import java.util.ArrayList;

public class UserController {
    private Context context;
    private UserRepository userRepository;
    private PasswordRepository passwordRepository;

    public UserController(Context context){
        this.context = context;
        this.userRepository = new UserRepository(context);
        this.passwordRepository = new PasswordRepository(context);
    }

    public UserModel register(String email, String password){
        if(validateEmail(email) && validatePassword(password)){
            //crear una contraseña
            // return this.userRepository.create(new UserModel(email, password));
            this.userRepository.create(new UserModel("Gabo", "hoy" , "1", 1,  email));
            UserModel newUser = this.userRepository.getByEmail(email);
            this.passwordRepository.create(new PasswordModel(newUser.getId(), password, "1", "Hoy"));
            return newUser;
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

            PasswordModel passwordModel = this.passwordRepository.getByIdUser(user.getId());
            if (passwordModel  == null){
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
