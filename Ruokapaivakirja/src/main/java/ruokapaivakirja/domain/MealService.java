package ruokapaivakirja.domain;

import java.sql.Date;
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
    
    public boolean createMeal(Date date, Dish dish, int category, int done) {
        Meal meal = new Meal(date, dish, category);
        try {   
            mealDao.create(meal, dish);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public List<Meal> getMeals() {
        List<Meal> meals = new ArrayList<>();
        try {
            meals = mealDao.getAll();
        } catch (Exception ex) {
        } 
        return meals;
    }
    
    public void markDone(int id) {
        try {
            mealDao.setDone(id);
        } catch (Exception ex) {
        }
    }
}
