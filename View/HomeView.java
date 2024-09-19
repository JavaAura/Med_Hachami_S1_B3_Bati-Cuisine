package View;

import Utils.Utils;
import controllers.HomeController;

public class HomeView {
    final ClientView clientView;
    public HomeView(){
        this.clientView = new ClientView();
    }

    public void showMenu(){
        int choice = 0;
        
        do {
            Utils.clear();
            System.out.println("=== Bienvenue dans l'application de gestion des projets de rénovation de cuisines === \n"); 
            System.out.println("=== Menu Principal ===");
    
            System.out.println("1. Créer un nouveau projet");
            System.out.println("2. Afficher les projets existants");
            System.out.println("3. Calculer le coût d'un projet");
            System.out.println("4. Quitter");
            choice = Utils.getInputInt("Choisissez une option :");
    
            switch (choice) {
                case 1:
                    this.clientView.showMenu();
    
                    break;
                case 2:
                System.out.println("existing pro");
                
                break;
                case 3:
                System.out.println("cout total");
                
                    break;  
            
                default:
                    break;
            }
    
    
            
        } while (choice != 4);
    }

    
    
}
