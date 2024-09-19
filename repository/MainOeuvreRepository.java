package repository;



import java.sql.SQLException;

import Model.MainOeuvre;


public interface  MainOeuvreRepository {
        Boolean addMainOeuvre(MainOeuvre mainOeuvre) throws SQLException;

}
