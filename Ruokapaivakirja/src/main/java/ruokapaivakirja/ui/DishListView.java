
package ruokapaivakirja.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;

/**
 *
 * @author jarkko
 */
public class DishListView {
    private ObservableList<Dish> dishList;
    private DishService dishService;

    public DishListView() {
        
    }

    public ObservableList<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(ObservableList<Dish> dishList) {
        this.dishList = dishList;
    }

    void SetDishService(DishService dishService) {
        this.dishService = dishService;
        this.dishList = FXCollections.observableArrayList(dishService.getDishes());
    }
    
    
}
