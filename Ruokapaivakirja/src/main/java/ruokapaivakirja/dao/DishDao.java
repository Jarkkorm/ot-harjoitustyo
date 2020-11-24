package ruokapaivakirja.dao;

import java.util.List;
import ruokapaivakirja.domain.Dish;

public interface DishDao {
    
    Dish create(Dish dish) throws Exception;
    
    List<Dish> getAll();
    
}