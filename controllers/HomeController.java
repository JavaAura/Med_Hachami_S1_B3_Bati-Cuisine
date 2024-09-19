package controllers;

import Utils.Utils;
import View.ClientView;
import View.HomeView;

public class HomeController {
    final HomeView homeView;

    public HomeController(){
        this.homeView = new HomeView();
    }
    
    public void start(){
        this.homeView.showMenu();
    }

  
}
