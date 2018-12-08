package com.example.demo.Repositories;

import com.example.demo.Models.Event;
import com.example.demo.Models.Judge;
import com.example.demo.Models.Kitchen;
import com.example.demo.Models.User;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepo {

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
    User findLogin(String username, String password);

    //SIGN UP
    User addUser(User user);

    //CONFIRM
    void confirmKitchen(int id);
    boolean confirmJudge(Judge judge);

    //LOGIN
    void loginStatus(Model model);
}
