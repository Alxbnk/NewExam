package com.example.demo.Services;

import com.example.demo.Models.Event;
import com.example.demo.Models.Judge;
import com.example.demo.Models.Kitchen;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;


    //LOGIN
    public void loginStatus(Model model) {userRepo.loginStatus(model);
    }


//KITCHENS

    @Override
    public List<Kitchen> getKitchens() {

        return userRepo.getKitchens();
    }

    @Override
    public Kitchen addKitchen(Kitchen kitchen) {

        return userRepo.addKitchen(kitchen);
    }

    @Override
    public Kitchen readKitchen(int id) {

        return userRepo.readKitchen(id);
    }

    @Override
    public Kitchen editKitchen(Kitchen kitchen) {

        return userRepo.editKitchen(kitchen);
    }

    @Override
    public boolean deleteKitchen(int id) {

        return userRepo.deleteKitchen(id);
    }

    @Override
    public void addKitchenToEvent(int id) {
        userRepo.addKitchenToEvent(id);
    }

    //JUDGES

    @Override
    public List<Judge> getJudges() {

        return userRepo.getJudges();
    }

    @Override
    public Judge addJudge(Judge judge) {

        return userRepo.addJudge(judge);
    }

    @Override
    public Judge readJudge(int id) {

        return userRepo.readJudge(id);
    }

    @Override
    public Judge editJudge(Judge judge) {

        return userRepo.editJudge(judge);
    }

    @Override
    public boolean deleteJudge(int id) {

        return userRepo.deleteJudge(id);
    }

//LOGGEDIN USER

    public boolean loginMatch(User user) {
        boolean loginMatch;

        User loginUser = userRepo.findLogin(user.getUsername(),user.getPassword());

        if(loginUser.getUsername() != null && loginUser.getPassword() != null) {
            loginMatch = true;
        }
        else{
            loginMatch = false;
        }

        return loginMatch;
    }

    @Override
    public User loggedIn(User user) {

        user = userRepo.findLogin(user.getUsername(),user.getPassword());
        return user;
    }

//SIGN UP

    public boolean signUpMatch(User user){
        boolean signUpMatch;

        User loginUser = userRepo.findLogin(user.getUsername(),user.getPassword());

        if(user.getUsername().equals("") || user.getPassword().equals("") || loginUser.getUsername() != null || loginUser.getPassword() != null){
            signUpMatch = false;
        }
        else{
            signUpMatch = true;
        }

        return signUpMatch;
    }

    @Override
    public User addUser (User user) {


        return userRepo.addUser(user);
    }



//CONFIRMS

    @Override
    public void confirmKitchen(int id) {

        userRepo.confirmKitchen(id);
    }

    @Override
    public boolean confirmJudge(Judge judge) {

        return userRepo.confirmJudge(judge);
    }
}
