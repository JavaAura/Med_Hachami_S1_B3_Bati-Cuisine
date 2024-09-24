package com.baticuisine.repository;

import java.sql.SQLException;

import com.baticuisine.Model.Material;


public interface MaterialRepository {
    Boolean addMaterial(Material material);
}
