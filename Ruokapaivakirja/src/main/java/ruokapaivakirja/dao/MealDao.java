package ruokapaivakirja.dao;

import java.sql.Date;
import java.util.List;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.Meal;

/**
 * Interface storing data for meals
 * @author jarkko
 * @param <T>
 */
public interface MealDao<T> {
    
    /**
     * Stores new meal to database
     * @param meal
     * @return
     * @throws Exception
     */
    Meal create(Meal meal) throws Exception;
    
    /**
     * Gets all active stored meal as list
     * @return
     * @throws Exception
     */
    List<Meal> getAll() throws Exception;
   
    /**
     * Sets meal with id to done
     * @param id
     * @throws Exception
     */
    void setDone(int id) throws Exception;

    /**
     * Gets list of meals of specified date
     * @param date
     * @return
     * @throws Exception
     */
    List<Meal> getAllOfDay(Date date) throws Exception;

    /**
     * Changes specified meal
     * @param meal
     * @throws Exception
     */
    void updateMeal(Meal meal) throws Exception;

    /**
     * Removes meal that has specified id
     * @param id
     * @throws Exception
     */
    public void removeMeal(int id) throws Exception;

    /**
     * Gets list of all done meals
     * @return
     * @throws Exception
     */
    public List<Meal> getAllDone() throws Exception;
    
}
