package ruokapaivakirja.dao;

import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.domain.Meal;

/**
 *
 * @author jarkko
 */
public class SqlMealDao implements MealDao {
    public List<Meal> meals;
    
    public SqlMealDao() {
        meals = new ArrayList<>();
    }

    private int generateId() {
        return meals.size() + 1;
    }
    
    @Override
    public Meal create(Meal meal) throws Exception {
        meal.setId(generateId());
        meals.add(meal);
        return meal;
    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }

    @Override
    public void setDone(int id) throws Exception {
        for (Meal t : meals) {
            if (t.getId() == id) {
                t.setDone();
            }
        }
    }
    
}
