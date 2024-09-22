package service.Impl;

import Model.Material;
import repository.MaterialRepository;
import service.MaterialService;


public class MaterialServiceImpl implements MaterialService {

    final MaterialRepository materialRepository;


    public MaterialServiceImpl(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
    }

    @Override
    public Boolean addMaterial(Material material) {
         return  this.materialRepository.addMaterial(material);
    }


   
    
}
