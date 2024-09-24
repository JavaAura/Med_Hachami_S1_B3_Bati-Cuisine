package com.baticuisine.service.Impl;

import com.baticuisine.Model.MainOeuvre;
import com.baticuisine.repository.MainOeuvreRepository;
import com.baticuisine.repository.Impl.MainOeuvreRepositoryImpl;
import com.baticuisine.service.MainOeuvreService;

public class MainOeuvreServiceImpl implements MainOeuvreService {

    final MainOeuvreRepository mainOeuvreRepository;


    public MainOeuvreServiceImpl(MainOeuvreRepositoryImpl mainOeuvreRepositoryImpl){
        this.mainOeuvreRepository = mainOeuvreRepositoryImpl;
    }

    @Override
    public Boolean addMainOeuvre(MainOeuvre mainOeuvre) {
       return this.mainOeuvreRepository.addMainOeuvre(mainOeuvre);
    }
    
}
