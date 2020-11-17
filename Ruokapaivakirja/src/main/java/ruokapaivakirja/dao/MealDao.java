package ruokapaivakirja.dao;

import java.util.List;
import ruokapaivakirja.domain.Meal;
/**
 *
 * @author jarkko
 */
public interface MealDao {
    
    Meal create(Meal meal) throws Exception;
    
    List<Meal> getAll();
    
    
}
