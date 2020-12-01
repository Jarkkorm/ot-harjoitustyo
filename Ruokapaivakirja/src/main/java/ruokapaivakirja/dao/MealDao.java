package ruokapaivakirja.dao;

import java.util.List;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.Meal;
/**
 *
 * @author jarkko
 */
public interface MealDao<T> {
    
    void create(Meal meal, Dish dish) throws Exception;
    
    List<Meal> getAll() throws Exception;
    
    void setDone(int id) throws Exception;
    
}
