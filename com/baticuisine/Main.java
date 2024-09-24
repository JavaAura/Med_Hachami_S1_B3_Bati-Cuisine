package com.baticuisine;

// import Utils.Utils;
// import View.root;


import com.baticuisine.View.*;

import com.baticuisine.repository.Impl.ClientRepositoryImpl;
import com.baticuisine.repository.Impl.MaterialRepositoryImpl;
import com.baticuisine.repository.Impl.MainOeuvreRepositoryImpl;
import com.baticuisine.repository.Impl.ProjetRepositoryImpl;
import com.baticuisine.repository.Impl.DevisRepositoryImpl;


import com.baticuisine.service.Impl.*;
import com.baticuisine.service.Impl.MaterialServiceImpl;
import com.baticuisine.service.Impl.ProjetServiceImpl;
import com.baticuisine.service.Impl.MainOeuvreServiceImpl;
import com.baticuisine.service.Impl.DevisServiceImpl;












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

      DevisRepositoryImpl devisRepositoryImpl = new DevisRepositoryImpl();
      DevisServiceImpl devisServiceImpl = new DevisServiceImpl(devisRepositoryImpl);



      root root = new root(clientServiceImpl, materialServiceImpl, mainOeuvreServiceImpl , projetServiceImpl,devisServiceImpl);

      root.showMenu();



   }
}
