package ruokapaivakirja.domain;

import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.dao.MealDao;

/**
 *
 * @author jarkko
 */
public class MealService {
    private MealDao mealDao;
    private List<Meal> mealList;

    public MealService() {
        this.mealList = new ArrayList();
    }
    
    public List<Meal> getMealList() {
        return mealList;
    }

    public void addToMeal(String meal) {
        mealList.add(new Meal(meal));
    }
    
    

}
