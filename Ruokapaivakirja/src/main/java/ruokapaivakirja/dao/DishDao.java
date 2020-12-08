package ruokapaivakirja.dao;

import java.sql.SQLException;
import java.util.List;
import ruokapaivakirja.domain.Dish;

public interface DishDao<T> {
    
    Dish create(Dish dish) throws Exception;
    
    List<Dish> getAll() throws Exception;
    
    Dish read(int id) throws Exception;
    
}