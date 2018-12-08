package com.example.demo.Services;

import com.example.demo.Models.Event;
import com.example.demo.Models.Judge;
import com.example.demo.Models.Kitchen;
import com.example.demo.Models.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {



    //KITCHENS
    List<Kitchen> getKitchens();
    Kitchen addKitchen(Kitchen kitchen);
    Kitchen readKitchen(int id);
    Kitchen editKitchen(Kitchen kitchen);
    boolean deleteKitchen(int id);
    void addKitchenToEvent(int id);

    //JUDGE
    List<Judge> getJudges();
    Judge addJudge(Judge judge);
    Judge readJudge(int id);
    Judge editJudge(Judge judge);
    boolean deleteJudge(int id);

    //LOGGEDIN USER
    boolean loginMatch(User user);
    User loggedIn(User user);

    //SIGN UP
    boolean signUpMatch(User user);
    User addUser(User user);

    //CONFIRM
    void confirmKitchen(int id);
    boolean confirmJudge(Judge judge);

    //LOGIN
    void loginStatus(Model model);
}
