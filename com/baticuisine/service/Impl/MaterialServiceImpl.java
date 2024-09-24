package com.baticuisine.service.Impl;

import com.baticuisine.Model.Material;
import com.baticuisine.repository.MaterialRepository;
import com.baticuisine.repository.Impl.MaterialRepositoryImpl;
import com.baticuisine.service.MaterialService;


public class MaterialServiceImpl implements MaterialService {

    final MaterialRepository materialRepository;


    public MaterialServiceImpl(MaterialRepositoryImpl materialRepositoryImpl){
        this.materialRepository = materialRepositoryImpl;
    }

    @Override
    public Boolean addMaterial(Material material) {
         return  this.materialRepository.addMaterial(material);
    }

    
}
