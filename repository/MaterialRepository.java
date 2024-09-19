package repository;

import Model.Material;

import java.sql.SQLException;


public interface MaterialRepository {
    Boolean addMaterial(Material material) throws SQLException;
}
