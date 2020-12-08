package ruokapaivakirja.domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ruokapaivakirja.dao.DishDao;
import ruokapaivakirja.dao.MealDao;
import ruokapaivakirja.dao.SqlMealDao;

/**
 *
 * Service class for Meal
 */
public class MealService {
    private MealDao mealDao;
    private DishDao dishDao;
    private List<String> categories = new ArrayList<String>();
    
    /**
     * Sets the Daos to use 
     * @param dishDao Doa used for storing Dish objects
     * @param mealDao Doa used to store Meal objects
     */
    public MealService(MealDao mealDao, DishDao dishDao) {
        this.mealDao = mealDao;
        this.dishDao = dishDao;
        this.categories.add("Aamiainen");
        this.categories.add("Lounas");
        this.categories.add("Välipala");
        this.categories.add("Päivällinen");
        this.categories.add("Iltapala");
    }
    
    /**
     * Creates Meal and stores it 
     * @param date date of meal
     * @param dish Dish connected to meal
     * @param category meals category
     * @return resurns created meal
     */
    public Meal createMeal(Date date, Dish dish, String category) {
        Meal meal = new Meal(date, dish, category);
        try {   
            mealDao.create(meal);
        } catch (Exception ex) {
            
        }
        return meal;
    }
    
    /**
     * Gets a list of all Meal objects from Dao
     * @return list of Meals
     */
    public List<Meal> getMeals() {
        List<Meal> meals = new ArrayList<>();
        try {
            meals = mealDao.getAll();
        } catch (Exception ex) {
        } 
        return meals;
    }
    
    /**
     * Sets Meal to done
     * @param id of meal to mark done
     */
    public void markDone(int id) {
        try {
            mealDao.setDone(id);
        } catch (Exception ex) {
        }
    }
    
    /**
     * Gets list of Meal categories
     * @return category list
     */
    public List<String> getCategories() {
        return this.categories;
    }
    
}
