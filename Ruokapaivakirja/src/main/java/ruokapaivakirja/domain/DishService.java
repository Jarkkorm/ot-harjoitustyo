package ruokapaivakirja.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.dao.DishDao;
import ruokapaivakirja.dao.MealDao;

/**
 *
 * Service class for Dish 
 */
public class DishService {
    private DishDao dishDao;

    /**
     * Sets the to Dao use 
     * @param dishDao Doa used for storing Dish objects
     */
    public DishService(DishDao dishDao) {
        this.dishDao = dishDao;
    }
    
    /**
     * Creates Dish and stores it 
     * @param description of Dish
     * @param calories
     * @param proteins
     * @param carbs
     * @param sugar
     * @param fat
     * @return returns created Dish
     */
    public Dish createDish(String description, int calories, double proteins, double carbs, double sugar, double fat) {
        Dish dish = new Dish(description, calories, proteins, carbs, sugar, fat);
        try {   
            dish = dishDao.create(dish);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dish;
    }    
    
    /**
     * Gets a list of all Dish objects from Dao
     * @return a list of Dishes
     */
    public List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();
        try {
            dishes = dishDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return dishes;
    }
    
}
