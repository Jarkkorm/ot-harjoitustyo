package ruokapaivakirja.dao;

import java.sql.SQLException;
import java.util.List;
import ruokapaivakirja.domain.Dish;

/**
 * Interface storing data for Dishes
 * @param <T>
 */
public interface DishDao<T> {
    
    /**
     * Stores new dish to database
     * @param dish
     * @return
     * @throws Exception
     */
    Dish create(Dish dish) throws Exception;
    
    /**
     * Gets all stored dishes as list
     * @return
     * @throws Exception
     */
    List<Dish> getAll() throws Exception;
    
    /**
     * Gets dish that have specified id
     * @param id
     * @return
     * @throws Exception
     */
    Dish read(int id) throws Exception;
    
}