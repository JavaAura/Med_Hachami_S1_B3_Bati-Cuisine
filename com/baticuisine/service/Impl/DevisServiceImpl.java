package com.baticuisine.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baticuisine.Model.Devis;
import com.baticuisine.repository.DevisRepository;
import com.baticuisine.repository.Impl.DevisRepositoryImpl;
import com.baticuisine.service.DevisService;

public class DevisServiceImpl implements DevisService {

    private static final Logger logger = LoggerFactory.getLogger(DevisServiceImpl.class);
    final DevisRepository devisRepository;

    public DevisServiceImpl(DevisRepositoryImpl devisRepositoryImpl){
        this.devisRepository = devisRepositoryImpl;
    }

    @Override
    public void addDevis(Devis devis) {
       Boolean added = this.devisRepository.addDevis(devis);
       if(added){
        System.out.println("Devis enregistré avec succès !");
       }else{
        System.out.println("Devis n'a pas ete enregistré !");

        }
    }
    
}
