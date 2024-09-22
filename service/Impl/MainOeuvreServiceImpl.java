package service.Impl;

import Model.MainOeuvre;
import repository.MainOeuvreRepository;
import service.MainOeuvreService;

public class MainOeuvreServiceImpl implements MainOeuvreService {

    final MainOeuvreRepository mainOeuvreRepository;


    public MainOeuvreServiceImpl(MainOeuvreRepository mainOeuvreRepository){
        this.mainOeuvreRepository = mainOeuvreRepository;
    }

    @Override
    public Boolean addMainOeuvre(MainOeuvre mainOeuvre) {
       return this.mainOeuvreRepository.addMainOeuvre(mainOeuvre);
    }
    
}
