package ruokapaivakirja.dao;

import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.domain.Dish;

/**
 *
 * @author jarkko
 */
public class SqlDishDao implements DishDao {
    public List<Dish> dishes;
    
    public SqlDishDao() {
        dishes = new ArrayList<>();
    }

    @Override
    public List<Dish> getAll() {
        return dishes;
    }

    @Override
    public Dish create(Dish dish) throws Exception {
        dishes.add(dish);
        return dish;
    }
}
