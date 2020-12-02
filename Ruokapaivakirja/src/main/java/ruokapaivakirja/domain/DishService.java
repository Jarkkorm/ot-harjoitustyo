/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruokapaivakirja.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.dao.DishDao;
import ruokapaivakirja.dao.MealDao;

/**
 *
 * @author jarkko
 */
public class DishService {
    private DishDao dishDao;

    public DishService(DishDao dishDao) {
        this.dishDao = dishDao;
    }
    
    public boolean createDish(String description, int calories, double proteins, double carbs, double sugar, double fat) {
        Dish dish = new Dish(description, calories, proteins, carbs, sugar, fat);
        try {   
            dishDao.create(dish);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }    
    
    public List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();
        try {
            dishes = dishDao.getAll();
        } catch (Exception ex) {
            System.out.println("List error: " + ex);
        } 
        return dishes;
    }
    
}
