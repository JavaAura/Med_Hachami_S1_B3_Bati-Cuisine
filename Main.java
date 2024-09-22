import Utils.Utils;
import View.root;
import repository.ClientRepository;
import repository.Impl.ClientRepositoryImpl;
import repository.Impl.MainOeuvreRepositoryImpl;
import repository.Impl.MaterialRepositoryImpl;
import repository.Impl.ProjetRepositoryImpl;
import service.MaterialService;
import service.Impl.ClientServiceImpl;
import service.Impl.MainOeuvreServiceImpl;
import service.Impl.MaterialServiceImpl;
import service.Impl.ProjetServiceImpl;

public class Main {

     public static void main(String[] args){
        ClientRepositoryImpl clientRepository = new ClientRepositoryImpl();
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl(clientRepository);

        MaterialRepositoryImpl materialRepositoryImpl = new MaterialRepositoryImpl();
        MaterialServiceImpl materialServiceImpl = new MaterialServiceImpl(materialRepositoryImpl);


        MainOeuvreRepositoryImpl mainOeuvreRepositoryImpl = new MainOeuvreRepositoryImpl();
        MainOeuvreServiceImpl mainOeuvreServiceImpl = new MainOeuvreServiceImpl(mainOeuvreRepositoryImpl);

        ProjetRepositoryImpl projetRepositoryImpl = new ProjetRepositoryImpl();
        ProjetServiceImpl projetServiceImpl = new ProjetServiceImpl(projetRepositoryImpl);



    
       root root = new root(clientServiceImpl, materialServiceImpl, mainOeuvreServiceImpl , projetServiceImpl);

       root.showMenu();



    }
}
