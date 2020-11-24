package ruokapaivakirja.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.dao.DishDao;
import ruokapaivakirja.dao.MealDao;
import ruokapaivakirja.dao.SqlMealDao;

/**
 *
 * @author jarkko
 */
public class MealService {
    private MealDao mealDao;
    private DishDao dishDao;
    
    public MealService(MealDao mealDao, DishDao dishDao) {
        this.mealDao = mealDao;
        this.dishDao = dishDao;
    }
    
    public boolean createMeal(LocalDate date, Dish dish, int category) {
        Meal meal = new Meal(date, dish, category);
        try {   
            mealDao.create(meal);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    

}
